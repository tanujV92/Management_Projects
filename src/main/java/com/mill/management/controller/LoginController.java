package com.mill.management.controller;

import com.mill.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> loginUser(
            @RequestParam("user_name") String userName,
            @RequestParam("password") String password
    ){
            return new ResponseEntity<>((userRepository.findByEmailAndPassword(userName,password)!=null)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }
}
