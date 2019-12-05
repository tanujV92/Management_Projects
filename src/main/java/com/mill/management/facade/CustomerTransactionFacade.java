package com.mill.management.facade;

import com.mill.management.dataDto.CustomerTransactionMasterData;

public interface CustomerTransactionFacade {

    CustomerTransactionMasterData getAllTheTransactions();
    CustomerTransactionMasterData  getAllTransactionForACustomer(long customerId);
}
