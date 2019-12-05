package com.mill.management.dataDto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CategoryData {

    private String name;
    private String type;
    private List<ProductData> products;
    private Date createdOn;
    private Date modifiedOn;
    private String createdBy;
    private String modifiedBy;
}
