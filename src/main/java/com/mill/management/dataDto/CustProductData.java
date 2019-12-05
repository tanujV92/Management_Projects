package com.mill.management.dataDto;

import lombok.Data;

@Data
public class CustProductData {
    private String name;
    private long productId;
    private double qty;
    private String qtyType;

}
