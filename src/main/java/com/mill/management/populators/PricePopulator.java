package com.mill.management.populators;

import com.mill.management.dataDto.PriceData;
import com.mill.management.entity.Price;
import org.springframework.stereotype.Component;

@Component
public class PricePopulator {

    public PriceData populate(PriceData priceData, Price price){

        priceData.setPrice(price.getPrice());
        priceData.setPriceType(price.getPriceType());
        priceData.setSurcharges(price.getSurcharges());
        priceData.setSurchargeType(price.getSurchargeType());
        priceData.setCreatedBy(price.getCreatedBy());
        priceData.setCreatedOn(price.getCreatedOn());
        priceData.setModifiedBy(price.getModifiedBy());
        priceData.setModifiedOn(price.getModifiedOn());

        return priceData;
    }

}
