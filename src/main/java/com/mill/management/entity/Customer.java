package com.mill.management.entity;

import com.mill.management.entity.commonfields.TableCommonFields;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
@Data
public class Customer extends TableCommonFields {

    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private long customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private boolean isActive=true;

}
