package com.mill.management.reversepopulators;

import com.mill.management.dataDto.QuantityData;
import com.mill.management.entity.Quantity;
import com.mill.management.entity.compositeKeyClasses.QuantityKey;
import org.springframework.stereotype.Component;

@Component
public class QuantityReversePopulator {

        public Quantity reversepopulator(Quantity quantity, QuantityData quantityData){
            quantity.setAvailableQty(quantityData.getAvailableQty());
            quantity.setQuantityType(quantityData.getAvailableQtyType());
            quantity.setActive(true);
            return quantity;
        }
}
