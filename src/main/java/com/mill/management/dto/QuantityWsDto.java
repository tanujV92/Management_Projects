package com.mill.management.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuantityWsDto {
    private double availableQty;
    private String availableQtyType;
    private List<ProductWsDto> products;
}
