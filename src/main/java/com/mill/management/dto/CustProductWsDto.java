package com.mill.management.dto;

import lombok.Data;

@Data
public class CustProductWsDto {

    private String name;
    private double qty;
    private long productId;
    private String qtyType;

}
