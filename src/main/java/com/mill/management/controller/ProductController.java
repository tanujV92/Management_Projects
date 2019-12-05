package com.mill.management.controller;

import com.mill.management.controller.basecontroller.BaseController;
import com.mill.management.dataDto.ProductData;
import com.mill.management.dataDto.ProductMasterData;
import com.mill.management.dto.ProductMasterWsDto;
import com.mill.management.dto.ProductWsDto;
import com.mill.management.exceptions.DuplicateEntryException;
import com.mill.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProductDetails(
            @RequestBody @Valid ProductWsDto product) throws DuplicateEntryException {
        getMapperFactory().classMap(ProductWsDto.class,ProductData.class).byDefault();
        try{
            productService.saveProduct(getMapperFactory().getMapperFacade().map(product,ProductData.class));
        }catch (DuplicateEntryException e){
           throw e;
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(getProductResponse(productService.getAllProducts()),HttpStatus.OK);
    }

    private ProductMasterWsDto getProductResponse(ProductMasterData productDataList){
        getMapperFactory().classMap(ProductMasterData.class,ProductMasterWsDto.class).byDefault();
        return  getMapperFactory().getMapperFacade().map(productDataList,ProductMasterWsDto.class);
    }

}
