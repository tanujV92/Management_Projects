package com.mill.management.dto;

import lombok.Data;
import java.util.List;

@Data
public class CustomerTransactionMasterWsDto {

    private long totalTransactions;
    private List<CustomerTransactionWsDto> transactions;

}
