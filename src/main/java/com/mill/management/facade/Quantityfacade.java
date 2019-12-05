package com.mill.management.facade;

import com.mill.management.dataDto.QuantityData;
import com.mill.management.entity.Quantity;

public interface Quantityfacade {
    boolean saveQuantity(QuantityData quantity);
}
