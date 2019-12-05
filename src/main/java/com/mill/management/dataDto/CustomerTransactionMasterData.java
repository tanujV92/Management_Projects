package com.mill.management.dataDto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerTransactionMasterData {

    private long totalTransactions;
    private List<CustomerTransactionData> transactions;

}
