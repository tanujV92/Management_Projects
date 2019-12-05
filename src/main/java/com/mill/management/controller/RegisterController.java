package com.mill.management.controller;

import com.mill.management.entity.User;
import com.mill.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> registerUser(
            @RequestBody User user
            ){
            return  new ResponseEntity<>((userRepository.save(user)!=null)? HttpStatus.CREATED:HttpStatus.BAD_REQUEST) ;
    }
}
