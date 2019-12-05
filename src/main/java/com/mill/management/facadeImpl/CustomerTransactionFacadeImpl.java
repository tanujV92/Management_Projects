package com.mill.management.facadeImpl;

import com.mill.management.dataDto.CustomerTransactionData;
import com.mill.management.dataDto.CustomerTransactionMasterData;
import com.mill.management.entity.CustTransactions;
import com.mill.management.facade.CustomerTransactionFacade;
import com.mill.management.populators.CustomerTransactionPopulator;
import com.mill.management.repository.CustomerTransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerTransactionFacadeImpl implements CustomerTransactionFacade {

    @Autowired
    private CustomerTransRepository customerTransRepository;

    @Autowired
    private CustomerTransactionPopulator customerTransactionPopulator;

    @Override
    public CustomerTransactionMasterData getAllTheTransactions() {
        CustomerTransactionMasterData customerTransactionMasterData=new CustomerTransactionMasterData();
        List<CustTransactions> custTransactions = (List<CustTransactions>)customerTransRepository.findAll();
        customerTransactionMasterData.setTransactions(populateCustTransData(custTransactions));
        customerTransactionMasterData.setTotalTransactions(custTransactions.size());
        return customerTransactionMasterData;
    }

    @Override
    public CustomerTransactionMasterData getAllTransactionForACustomer(long customerId) {
        CustomerTransactionMasterData customerTransactionMasterData=new CustomerTransactionMasterData();
        List<CustTransactions> custTransactions = customerTransRepository.findByCustomer_CustomerId(customerId);
        customerTransactionMasterData.setTotalTransactions(custTransactions.size());
        customerTransactionMasterData.setTransactions(populateCustTransData(custTransactions));
        return customerTransactionMasterData;
    }

    private List<CustomerTransactionData> populateCustTransData(List<CustTransactions> custTransactions){
        List<CustomerTransactionData> customerTransactionData=new ArrayList<>();
        for(CustTransactions custTransactions1: custTransactions){
            customerTransactionData.add(customerTransactionPopulator.populator(new CustomerTransactionData(),custTransactions1));
        }
        return customerTransactionData;
    }

}
