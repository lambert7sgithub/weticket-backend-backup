package com.thoughtworks.training.controller;

import com.thoughtworks.training.entity.Order;
import com.thoughtworks.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public Order findMessageByOrderId(@PathVariable String orderId){

        return orderService.findMessageByOrderId(orderId);
    }

}
