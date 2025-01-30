package com.authGuard.AuthGuard.controller;

import com.authGuard.AuthGuard.entity.User;
import com.authGuard.AuthGuard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public ResponseEntity<List<User>> GetAllUser() {

        List<User> users = userService.findAll();

        return  new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<?> RegisterUser(@RequestBody User user) {

        try{
            User user1 = userService.registerUser(user);
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
