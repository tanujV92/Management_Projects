package com.mill.management.entity;


import com.mill.management.entity.commonfields.TableCommonFields;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
@Data
public class Category extends TableCommonFields {

    @Column(name = "ID")
    @GeneratedValue
    @Id
    private long categoryId;
    private String name;
    private String type;

    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();
}
