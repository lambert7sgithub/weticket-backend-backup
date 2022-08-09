package com.thoughtworks.training.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.model.dto.UserLoginRequest;
import com.thoughtworks.training.model.dto.UserSignInRequest;
import com.thoughtworks.training.model.entity.Role;
import com.thoughtworks.training.repository.RoleRepository;
import com.thoughtworks.training.repository.UserRepository;
import com.thoughtworks.training.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Lynn
 * @Date: 2022/8/8 22:54
 */
@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationTest {
    @Autowired
    private MockMvc client;
    @Resource
    private UserService service;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    void setUp() {
        roleRepository.deleteAll();
        userRepository.deleteAll();
    }
    @Test
    void login() throws Exception {
//        System.out.println(roleRepository.findAll());
//        roleRepository.save(new Role(5,"ROLE_NORMAL"));
//        System.out.println(roleRepository.findAll());
//        UserSignInRequest signInRequest = new UserSignInRequest("name","password","kaptcha","email");
//        service.register(signInRequest);
//
//        UserLoginRequest loginRequest = new UserLoginRequest("name","password","kaptcha");
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(signInRequest);
//        client.perform(MockMvcRequestBuilders.post("/session")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
