package com.mill.management.dataDto;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class ProductData {

    private String name;
    private String type;
    private Date mfgDate;
    private Date expDate;
    private Date createdOn;
    private Date modifiedOn;
    private String createdBy;
    private String modifiedBy;
    private Set<CategoryData> categories;
    private double availableQty;
    private String availableQtyType;
    private long price;
    private String priceType;
    private long surcharges;
    private String surchargeType;
}
