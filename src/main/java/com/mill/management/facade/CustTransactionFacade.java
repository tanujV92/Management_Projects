package com.mill.management.facade;

import com.mill.management.dataDto.CustTransactionData;

public interface CustTransactionFacade {

    boolean placeOrder(CustTransactionData custTransactionData);
}
