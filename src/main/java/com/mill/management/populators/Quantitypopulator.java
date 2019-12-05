package com.mill.management.populators;

import com.mill.management.dataDto.ProductData;
import com.mill.management.entity.Quantity;
import org.springframework.stereotype.Component;

@Component
public class Quantitypopulator {

    public void populate(Quantity quantity, ProductData productData){
            productData.setAvailableQty(quantity.getAvailableQty());
            productData.setAvailableQtyType(quantity.getQuantityType());
    }

}
