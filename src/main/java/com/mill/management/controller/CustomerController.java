package com.mill.management.controller;

import com.mill.management.controller.basecontroller.BaseController;
import com.mill.management.dataDto.CustomerData;
import com.mill.management.dto.CustomerWsDto;
import com.mill.management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewCustomer(
            @RequestBody CustomerWsDto customer
            ){
                    getMapperFactory().classMap(CustomerWsDto.class, CustomerData.class).byDefault();
                    boolean res = customerService.saveCustomer(getMapperFactory().getMapperFacade().map(customer,CustomerData.class));
                    return new ResponseEntity<>((res)? HttpStatus.CREATED:HttpStatus.NOT_ACCEPTABLE);
    }
}
