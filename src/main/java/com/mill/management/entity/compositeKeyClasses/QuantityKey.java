package com.mill.management.entity.compositeKeyClasses;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class QuantityKey implements Serializable {
    private double availableQty;
    private String availableQtyType;

}
