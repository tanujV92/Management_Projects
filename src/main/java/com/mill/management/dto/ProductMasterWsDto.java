package com.mill.management.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductMasterWsDto {

    private long productCount;
    private long categoryCount;
    private List<ProductWsDto> products;
    private List<String> categoryNameList;
    private List<String> productsNameList;

}
