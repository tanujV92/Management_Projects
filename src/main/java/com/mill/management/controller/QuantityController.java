package com.mill.management.controller;

import com.mill.management.controller.basecontroller.BaseController;
import com.mill.management.dataDto.ProductData;
import com.mill.management.dataDto.QuantityData;
import com.mill.management.dto.ProductWsDto;
import com.mill.management.dto.QuantityWsDto;
import com.mill.management.entity.Quantity;
import com.mill.management.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quantity")
public class QuantityController extends BaseController {

    @Autowired
    private QuantityService quantityService;

    @PostMapping("/update")
    public ResponseEntity<?> updateExistingProductQuantity(
            @RequestBody QuantityWsDto quantity
            ){
            getMapperFactory().classMap(QuantityWsDto.class, QuantityData.class).byDefault();
            return new ResponseEntity<>((quantityService.sveQuantity(getMapperFactory().getMapperFacade().map(quantity,QuantityData.class)))? HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }
}
