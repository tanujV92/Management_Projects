package com.mill.management.facadeImpl;

import com.mill.management.dataDto.ProductData;
import com.mill.management.dataDto.QuantityData;
import com.mill.management.entity.Product;
import com.mill.management.entity.Quantity;
import com.mill.management.facade.Quantityfacade;
import com.mill.management.repository.ProductRepository;
import com.mill.management.repository.QuantityRepository;
import com.mill.management.reversepopulators.QuantityReversePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class QuantityFacadeImpl implements Quantityfacade {

    @Autowired
    private QuantityRepository quantityRepository;

    @Autowired
    private QuantityReversePopulator quantityReversePopulator;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean saveQuantity(QuantityData quantity) {

        Quantity updateQuantity = quantityReversePopulator.reversepopulator(new Quantity(),quantity);
        updateAllProducts(quantity.getProducts(),updateQuantity);
        return true;
        //  return quantityRepository.save(updateQuantity)!=null;
    }

    private void updateAllProducts(List<ProductData> productData,Quantity quantity){
            for (ProductData data:productData){
                Product product=productRepository.findByNameAndType(data.getName(),data.getType());
                if(product!=null){
                    product.setQuantity(quantity);
                    productRepository.save(product);
                }
            }
    }
}
