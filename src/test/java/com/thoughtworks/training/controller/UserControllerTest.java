package com.thoughtworks.training.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.model.dto.UserSignInRequest;
import com.thoughtworks.training.model.entity.Role;
import com.thoughtworks.training.repository.RoleRepository;
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

/**
 * @Author: Lynn
 * @Date: 2022/8/8 22:54
 */
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Resource
    private UserService service;
    @Autowired
    private MockMvc client;
    @Resource
    private RoleRepository roleRepository;

    @BeforeEach
    void clear() {
        roleRepository.deleteAll();
    }

    @Test
    void register() throws Exception {
        roleRepository.save(new Role(1, "ROLE_NORMAL"));
        UserSignInRequest signInRequest = new UserSignInRequest("name", "password", "kaptcha", "email");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(signInRequest);
        client.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
