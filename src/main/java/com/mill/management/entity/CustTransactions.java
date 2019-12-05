package com.mill.management.entity;

import com.mill.management.entity.commonfields.TableCommonFields;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "customer_transactions")
@Data
@ToString(exclude = "products")
@EqualsAndHashCode(exclude = "products", callSuper = false)
public class CustTransactions extends TableCommonFields {

    @Column(name = "trans_id")
    @Id
    @GeneratedValue
    private long transactionId;

    @OneToOne
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE,mappedBy = "custTransactions")
    private List<Product> products;

    private Date transactionDate;
    private double totalAmount;
    private float cgst;
    private float sgst;
    private String invoiceNumber;

}
