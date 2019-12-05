package com.mill.management.controller;

import com.mill.management.controller.basecontroller.BaseController;
import com.mill.management.dataDto.CategoryData;
import com.mill.management.dataDto.CustomerTransactionMasterData;
import com.mill.management.dto.CategoryWsDto;
import com.mill.management.dto.CustomerTransactionMasterWsDto;
import com.mill.management.service.CustTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/transaction")
public class CustomerTransactionController extends BaseController {

    {
        getMapperFactory().classMap(CategoryData.class, CategoryWsDto.class).exclude("products").register();
        getMapperFactory().classMap(CustomerTransactionMasterData.class, CustomerTransactionMasterWsDto.class).byDefault();
    }

    @Autowired
    private CustTransactionService custTransactionService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTransaction() {
        return new ResponseEntity<>(getMapperFactory().getMapperFacade().map(custTransactionService.getAllTransactions(),CustomerTransactionMasterWsDto.class),HttpStatus.OK);
    }

    @GetMapping("/{customerId}/get")
    public ResponseEntity<?> getCustomerTransaction(
            @PathVariable("customerId") long customerId
    ){
        getMapperFactory().classMap(CustomerTransactionMasterData.class,CustomerTransactionMasterWsDto.class).byDefault();
        return new ResponseEntity<>(getMapperFactory().getMapperFacade().map(custTransactionService.getCustomerTransaction(customerId),CustomerTransactionMasterWsDto.class),HttpStatus.OK);
    }
}