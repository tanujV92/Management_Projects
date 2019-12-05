package com.mill.management.repository;

import com.mill.management.entity.Quantity;
import org.springframework.data.repository.CrudRepository;

public interface QuantityRepository extends CrudRepository<Quantity,Long> {
}
