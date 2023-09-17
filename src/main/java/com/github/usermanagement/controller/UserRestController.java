package com.github.usermanagement.controller;

import com.github.usermanagement.entity.Users;
import com.github.usermanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** Created by Mahsa.Hadiyan  Date: 9/12/2023   Time: 11:29 AM */
@RestController
public class UserRestController {

    UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    private ResponseEntity<Users> register(@RequestBody Users users) throws Exception {
        userService.registerUser(users);
        return ResponseEntity.ok(users);
    }


    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody Users users) throws Exception {
        String token = userService.loginUser(users);
        return ResponseEntity.ok(token);
    }


}
