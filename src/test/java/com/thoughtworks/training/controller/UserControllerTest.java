//package com.thoughtworks.training.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.thoughtworks.training.model.dto.UserSignInRequest;
//import com.thoughtworks.training.service.UserService;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import javax.annotation.Resource;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @Author: Lynn
// * @Date: 2022/8/8 22:54
// */
//class UserControllerTest {
//    @Resource
//    private UserService service;
//    @Autowired
//    private MockMvc client;
//    @Test
//    void register() throws Exception {
//        UserSignInRequest signInRequest = new UserSignInRequest("name","password","kaptcha","email");
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(signInRequest);
//        client.perform(MockMvcRequestBuilders.post("/user")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void profile() {
//    }
//}
