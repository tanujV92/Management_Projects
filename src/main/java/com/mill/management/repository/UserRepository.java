package com.mill.management.repository;

import com.mill.management.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByEmailAndPassword(String email,String password);

}
