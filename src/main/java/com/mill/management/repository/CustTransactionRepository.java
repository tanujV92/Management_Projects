package com.mill.management.repository;

import com.mill.management.entity.CustTransactions;
import org.springframework.data.repository.CrudRepository;

public interface CustTransactionRepository extends CrudRepository<CustTransactions,Long> {
}
