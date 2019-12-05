package com.mill.management.entity;

import com.mill.management.entity.commonfields.TableCommonFields;
import com.mill.management.entity.compositeKeyClasses.QuantityKey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;

@Table(name = "Quantity")
@Entity
@Data
@EqualsAndHashCode(exclude = {"product"}, callSuper = false)
@ToString(exclude = {"product"})
public class Quantity extends TableCommonFields {

    @Id
    @GeneratedValue
    @Column(name = "quantity_id")
    private long quantityId;

    @OneToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private Product product;

    private double availableQty;
    private String quantityType;
    private boolean isActive;
}
