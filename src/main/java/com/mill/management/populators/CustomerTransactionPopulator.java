package com.mill.management.populators;

import com.mill.management.dataDto.CustomerTransactionData;
import com.mill.management.dataDto.ProductData;
import com.mill.management.entity.CustTransactions;
import com.mill.management.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerTransactionPopulator {

    @Autowired
    private ProductDataPopulator productDataPopulator;

    public CustomerTransactionData populator(CustomerTransactionData custTransactionData, CustTransactions custTransactions){
        custTransactionData.setCgst(custTransactions.getCgst());
        custTransactionData.setInvoiceNumber(custTransactions.getInvoiceNumber());
        custTransactionData.setSgst(custTransactions.getSgst());
        custTransactionData.setTotalAmount(custTransactions.getTotalAmount());
        custTransactionData.setTransactionDate(custTransactions.getTransactionDate());
        List<ProductData> productData = new ArrayList<>();
        if(custTransactions.getProducts()!=null && custTransactions.getProducts().size()>0){
            for (Product product : custTransactions.getProducts()){
                productData.add(productDataPopulator.populate(product,new ProductData(),true));
            }
            custTransactionData.setProducts(productData);
        }
        return custTransactionData;
    }

}
