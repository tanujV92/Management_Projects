package com.mill.management.facadeImpl;

import com.mill.management.dataDto.CustomerData;
import com.mill.management.entity.Customer;
import com.mill.management.facade.CustomerFacade;
import com.mill.management.repository.CustomerRepository;
import com.mill.management.reversepopulators.CustomerReversePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerFacadeImpl implements CustomerFacade {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerReversePopulator customerReversePopulator;

    @Override
    public boolean createCustomer(CustomerData customerData) {
        return customerRepository.save(customerReversePopulator.reversePopulator(new Customer(),customerData))!=null;
    }

}
