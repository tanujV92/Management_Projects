package com.mill.management.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class CategoryWsDto {

    private String name;
    private String type;
    private List<ProductWsDto> products;
    private Date createdOn;
    private Date modifiedOn;
    private String createdBy;
    private String modifiedBy;
}
