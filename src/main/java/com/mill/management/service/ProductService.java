package com.mill.management.service;

import com.mill.management.dataDto.ProductData;
import com.mill.management.dataDto.ProductMasterData;
import com.mill.management.exceptions.DuplicateEntryException;
import com.mill.management.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductFacade productFacade;

    public boolean saveProduct(ProductData product) throws DuplicateEntryException {
        boolean res=false;
        try {
            res= productFacade.saveProduct(product);
        }catch (SQLException e){
              throw new DuplicateEntryException("Product with name : /*"+product.getName()+"*/ is already Exist.");
        }
        return res;
    }
    public ProductMasterData getAllProducts(){
        return productFacade.getAllTheProducts();
    }


}
