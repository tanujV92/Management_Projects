package com.mill.management.repository;

import com.mill.management.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    @Query(value = "select p from Product as p where product_Id = :product_id")
    Product findByProduct_Id(@Param("product_id") long id);
    Product findByName(String productName);

    @Query(value = "select p from Product as p where name = ?1 and type = ?2")
    Product findByNameAndType(String name,String type);
}
