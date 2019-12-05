package com.mill.management.repository;

import com.mill.management.entity.Price;
import com.mill.management.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PriceRepository extends CrudRepository<Price,Long> {

    @Query(value = "select * from Price as pr where pr.product_Id = :product_Id and pr.is_active = true ",nativeQuery = true)
    Price findActivePriceByProductName(@Param("product_Id") long product_Id);

}
