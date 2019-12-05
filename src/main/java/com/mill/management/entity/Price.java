package com.mill.management.entity;

import com.mill.management.entity.commonfields.TableCommonFields;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "PRICE")
@Data
@ToString(exclude = "product")
@EqualsAndHashCode(exclude = "product", callSuper = false)
public class Price extends TableCommonFields {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long priceId;
    @Column(name = "price")
    private long price;
    @Column(name = "priceType")
    private String priceType;
    private long surcharges;
    @Column(name = "surchargeType")
    private String surchargeType;

    @ManyToOne(cascade = {CascadeType.ALL,CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinColumn(name = "product_Id",nullable = false)
    private Product product;
}

