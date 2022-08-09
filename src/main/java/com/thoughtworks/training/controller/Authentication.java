package com.thoughtworks.training.controller;

import com.thoughtworks.training.model.dto.UserLoginRequest;
import com.thoughtworks.training.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/session")
public class Authentication {
    @Resource
    private UserService service;

    @PostMapping
    public ResponseEntity<Void> login(@RequestBody UserLoginRequest request) {
        return service.login(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> logout(@PathVariable String id) {
        return service.logout(id);
    }
}
