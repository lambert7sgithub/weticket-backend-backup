package com.thoughtworks.training.controller;

import com.thoughtworks.training.controller.dto.UserProfileResponse;
import com.thoughtworks.training.controller.dto.UserSignInRequest;
import com.thoughtworks.training.controller.dto.UserUpdateRequest;
import com.thoughtworks.training.exception.RoleException;
import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService service;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody UserSignInRequest request) throws RoleException {
        return service.register(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserUpdateRequest request) throws UserException {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileResponse> profile(@PathVariable String id) throws UserException {
        return service.profile(id);
    }
}
