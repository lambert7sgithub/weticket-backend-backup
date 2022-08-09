package com.thoughtworks.training.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.model.dto.UserLoginRequest;
import com.thoughtworks.training.model.entity.Role;
import com.thoughtworks.training.model.entity.User;
import com.thoughtworks.training.repository.RoleRepository;
import com.thoughtworks.training.repository.UserRepository;
import com.thoughtworks.training.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @Author: Lynn
 * @Date: 2022/8/8 22:54
 */
@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerTest {
    @Autowired
    private MockMvc client;
    @Resource
    private UserService service;
    @Resource
    private RoleRepository roleRepository;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserRepository userRepository;

    @BeforeEach
    void clear() {
        roleRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void login() throws Exception {
        roleRepository.save(new Role(1, "ROLE_NORMAL"));
        User user = new User();
        Role role = new Role();
        role.setName("ROLE_NORMAL");
        user.setRoles(Collections.singleton(role));
        user.setEmail("11@11.111");
        user.setPassword(passwordEncoder.encode("password"));
        user.setName("name");
        user.setUsername("name");
        userRepository.save(user);
        UserLoginRequest loginRequest = new UserLoginRequest("name", "password", "captcha");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(loginRequest);
        client.perform(MockMvcRequestBuilders.post("/session")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
