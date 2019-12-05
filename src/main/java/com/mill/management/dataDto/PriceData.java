package com.mill.management.dataDto;

import lombok.Data;

import java.util.Date;

@Data
public class PriceData {
    private long price;
    private String priceType;
    private long surcharges;
    private String surchargeType;
    private ProductData product;
    private String createdBy;
    private String modifiedBy;
    private Date createdOn;
    private Date modifiedOn;
}
