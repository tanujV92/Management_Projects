package com.mill.management.dataDto;

import lombok.Data;
import java.util.List;

@Data
public class QuantityData {
    private double availableQty;
    private String availableQtyType;
    private List<ProductData> products;
}
