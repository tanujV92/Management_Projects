package com.mill.management.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
public class ProductWsDto {

    @NotNull
    private String name;
    @NotNull
    private String type;
    private Date mfgDate;
    private Date expDate;
    private Set<CategoryWsDto> categories;
    private double availableQty;
    private String availableQtyType;
    private long price;
    private String priceType;
    private Date createdOn;
    private Date modifiedOn;
    private String createdBy;
    private String modifiedBy;
    private long surcharges;
    private String surchargeType;
}
