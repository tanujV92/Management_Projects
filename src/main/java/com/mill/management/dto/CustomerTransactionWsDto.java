package com.mill.management.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class CustomerTransactionWsDto {

    private CustomerWsDto customer;
    private List<ProductWsDto> products;
    private Date transactionDate;
    private double totalAmount;
    private float cgst;
    private float sgst;
    private String invoiceNumber;
}
