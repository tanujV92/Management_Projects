package com.mill.management.facade;

import com.mill.management.dataDto.ProductData;
import com.mill.management.dataDto.ProductMasterData;
import com.mill.management.entity.Product;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface ProductFacade {

    Product findProductByName(String productName);
    Product findProductById(long productId);

    boolean saveProduct(ProductData product) throws SQLException;

    ProductMasterData getAllTheProducts();
}
