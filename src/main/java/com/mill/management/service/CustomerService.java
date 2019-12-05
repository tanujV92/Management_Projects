package com.mill.management.service;

import com.mill.management.dataDto.CustomerData;
import com.mill.management.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerFacade customerFacade;

    public boolean saveCustomer(CustomerData customerData){
            return customerFacade.createCustomer(customerData);
    }

}
