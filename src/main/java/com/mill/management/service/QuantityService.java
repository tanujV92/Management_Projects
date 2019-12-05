package com.mill.management.service;

import com.mill.management.dataDto.QuantityData;
import com.mill.management.entity.Quantity;
import com.mill.management.facade.Quantityfacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuantityService {

    @Autowired
    private Quantityfacade quantityfacade;

    public boolean sveQuantity(QuantityData quantity){
            return  quantityfacade.saveQuantity(quantity);
    }
}
