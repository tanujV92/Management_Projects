package com.mill.management.dataDto;

import lombok.Data;
import java.util.List;

@Data
public class CustTransactionData {

    private long customerId;
    private List<CustProductData> products;
}
