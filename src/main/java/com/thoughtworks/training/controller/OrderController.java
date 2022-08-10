package com.thoughtworks.training.controller;

import com.thoughtworks.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public Map<String, Object> findMessageByOrderId(@PathVariable String orderId){
       return  orderService.findMessageByOrderId(orderId);


    }

}
