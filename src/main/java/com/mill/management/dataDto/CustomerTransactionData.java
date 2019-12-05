package com.mill.management.dataDto;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class CustomerTransactionData {

    private CustomerData customer;
    private List<ProductData> products;
    private Date transactionDate;
    private double totalAmount;
    private float cgst;
    private float sgst;
    private String invoiceNumber;

}
