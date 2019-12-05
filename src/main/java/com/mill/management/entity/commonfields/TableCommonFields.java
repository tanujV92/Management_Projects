package com.mill.management.entity.commonfields;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class TableCommonFields {

    @Column(name = "created_on")
    private Date createdOn = new Date();
    @Column(name = "modified_on")
    private Date modifiedOn = new Date();
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "isActive")
    private boolean isActive = false;
}
