package com.mill.management.repository;

import com.mill.management.entity.CustTransactions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerTransRepository extends CrudRepository<CustTransactions,Long> {

    List<CustTransactions> findByCustomer_CustomerId(long custId);

}
