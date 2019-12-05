package com.mill.management.dto;

import com.mill.management.dataDto.ProductData;
import lombok.Data;

@Data
public class PriceWsDto {
    private long price;
    private String priceType;
    private long surcharges;
    private String surchargeType;
    private ProductData product;
}
