package com.mill.management.reversepopulators;

import com.mill.management.dataDto.CustomerData;
import com.mill.management.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerReversePopulator {

    public Customer reversePopulator(Customer customer, CustomerData customerData){
            customer.setActive(true);
            customer.setFirstName(customerData.getFirstName());
            customer.setMiddleName(customerData.getMiddleName());
            customer.setLastName(customerData.getLastName());
            customer.setCreatedOn(new Date());
            return customer;
    }
}
