package com.mill.management.controller;

import com.mill.management.controller.basecontroller.BaseController;
import com.mill.management.dataDto.CustTransactionData;
import com.mill.management.dto.CustTransactionWsDto;
import com.mill.management.service.CustTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class TransactionController extends BaseController {

    @Autowired
    private CustTransactionService custTransactionService;

    @PostMapping("/place")
    public ResponseEntity<?> orderProducts(
            @RequestBody CustTransactionWsDto transactionDetails
            ){
                getMapperFactory().classMap(CustTransactionWsDto.class, CustTransactionData.class).byDefault();
                boolean res = custTransactionService.placeOrder(getMapperFactory().getMapperFacade().map(transactionDetails,CustTransactionData.class));
                return new ResponseEntity<>((res)? HttpStatus.CREATED:HttpStatus.NOT_ACCEPTABLE);
    }
}
