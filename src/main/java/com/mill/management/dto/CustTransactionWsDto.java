package com.mill.management.dto;

import lombok.Data;
import java.util.List;

@Data
public class CustTransactionWsDto {

    private long customerId;
    private List<CustProductWsDto> products;
}
