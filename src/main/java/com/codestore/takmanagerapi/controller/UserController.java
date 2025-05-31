package com.codestore.takmanagerapi.controller;

import com.codestore.takmanagerapi.Dto.UserLoginDto;
import com.codestore.takmanagerapi.Dto.UserRegisterDto;
import com.codestore.takmanagerapi.Service.UserService.UserService;
import com.codestore.takmanagerapi.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDto dto) {
        userService.registerUser(dto);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDto dto) {
        try {
            UserEntity user = userService.login(dto);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }
}
