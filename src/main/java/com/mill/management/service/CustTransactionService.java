package com.mill.management.service;

import com.mill.management.dataDto.CustTransactionData;
import com.mill.management.dataDto.CustomerTransactionMasterData;
import com.mill.management.facade.CustTransactionFacade;
import com.mill.management.facade.CustomerTransactionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustTransactionService {

    @Autowired
    private CustTransactionFacade custTransactionFacade;

    @Autowired
    private CustomerTransactionFacade customerTransactionFacade;

    public boolean placeOrder(CustTransactionData custTransactionData){
        return custTransactionFacade.placeOrder(custTransactionData);
    }

    public CustomerTransactionMasterData getCustomerTransaction(long custId){
            return customerTransactionFacade.getAllTransactionForACustomer(custId);
    }

    public CustomerTransactionMasterData getAllTransactions(){
        return customerTransactionFacade.getAllTheTransactions();
    }

}
