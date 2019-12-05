package com.mill.management.facadeImpl;

import com.mill.management.dataDto.CustProductData;
import com.mill.management.dataDto.CustTransactionData;
import com.mill.management.entity.*;
import com.mill.management.exceptions.NoCustomerAvailableException;
import com.mill.management.facade.CustTransactionFacade;
import com.mill.management.repository.*;
import com.mill.management.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustTransactionFacadeImpl implements CustTransactionFacade {

    @Autowired
    private CustTransactionRepository custTransactionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private QuantityRepository quantityRepository;

    @Autowired
    private RandomStringGenerator randomStringGenerator;

    @Override
    public boolean placeOrder(CustTransactionData custTransactionData) {

        Customer customer=findTheCustomer(custTransactionData.getCustomerId());
        CustTransactions custTransactions=createOrder();
        findAllProductAndUpdateAvlblQtyAndPrice(custTransactionData.getProducts(),custTransactions);
        custTransactions.setCustomer(customer);
        return custTransactionRepository.save(custTransactions)!=null;
    }

    private double calculateTotalAmt(Product product, double initPrice,double qty){
            Price price = priceRepository.findActivePriceByProductName(product.getProduct_Id());
            initPrice+=(price.getPrice()*qty);
            return initPrice;
    }

    private Customer findTheCustomer(long custId){
        Customer customer=null;
        try{
                customer = customerRepository.findById(custId).get();
        }catch (RuntimeException e){

        }
        if(customer==null){
            throw new NoCustomerAvailableException("No Customer is Available. Please create a New Customer First.");
        }
        return customer;
    }

    private void findAllProductAndUpdateAvlblQtyAndPrice(List<CustProductData> productIds,CustTransactions custTransactions){
        List<Product> products=new ArrayList<>();
        double price = 0;
        for (CustProductData product:productIds){
            Product foundProduct = productRepository.findByProduct_Id(product.getProductId());
            foundProduct.setCustTransactions(custTransactions);
            price += calculateTotalAmt(foundProduct,price,product.getQty());
            updateproductQty(product.getQty(),foundProduct);
                products.add(foundProduct);
        }

       // custTransactions.setProducts(products);
        custTransactions.setTotalAmount(price);
    }

    private Product updateproductQty(Double usedQty,Product product){
        Quantity quantity = product.getQuantity();
        quantity.setAvailableQty(quantity.getAvailableQty()-usedQty);
        product.setQuantity(quantity);
        quantityRepository.save(quantity);
        productRepository.save(product);
        return product;
    }

    private CustTransactions createOrder(){
            CustTransactions custTransactions=new CustTransactions();
            custTransactions.setInvoiceNumber(randomStringGenerator.generateInvoiceNumber());
            custTransactions.setTransactionDate(new Date());
            custTransactions.setActive(true);
            custTransactions.setCreatedBy("Tanuj");
            custTransactions.setCreatedOn(new Date());
            return custTransactions;
    }
}
