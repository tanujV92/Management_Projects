package com.mill.management.entity;

import com.mill.management.entity.commonfields.TableCommonFields;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Table(name = "PRODUCT")
@Entity
@EqualsAndHashCode(exclude = {"categories","quantity"}, callSuper = false)
@ToString(exclude = {"categories","quantity"})
public class Product extends TableCommonFields {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long product_Id;
    private String name;
    private String type;
    private Date mfgDate;
    private Date expDate;

    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinTable(name = "PRODUCT_CATEGORY",
    joinColumns = {@JoinColumn(name = "product_id")},
    inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories = new HashSet<>();

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Quantity quantity;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private CustTransactions custTransactions;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.ALL,CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
    private List<Price> price;
}
