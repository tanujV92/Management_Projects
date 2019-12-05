package com.mill.management.reversepopulators;

import com.mill.management.dataDto.PriceData;
import com.mill.management.entity.Price;
import com.mill.management.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceReversePopulator {

    @Autowired
    private ProductReversePopulator productReversePopulator;

    public Price reversePopulator(Price price, PriceData priceData,boolean isSetProduct){
        price.setActive(true);
        price.setCreatedBy(priceData.getCreatedBy());
        price.setPrice(priceData.getPrice());
        price.setPriceType(priceData.getPriceType());
        price.setSurcharges(priceData.getSurcharges());
        price.setSurchargeType(priceData.getSurchargeType());
        price.setCreatedOn(priceData.getCreatedOn());
        price.setModifiedBy(priceData.getModifiedBy());
        price.setModifiedOn(priceData.getModifiedOn());
        if(isSetProduct){
            price.setProduct(productReversePopulator.reversePopulator(new Product(),priceData.getProduct(),false,false));
        }
        return price;
    }
}
