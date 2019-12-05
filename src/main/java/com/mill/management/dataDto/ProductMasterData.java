package com.mill.management.dataDto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ProductMasterData {
    private long productCount;
    private long categoryCount;
    private List<ProductData> products;
    private Set<String> categoryNameList;
    private Set<String> productsNameList;
}
