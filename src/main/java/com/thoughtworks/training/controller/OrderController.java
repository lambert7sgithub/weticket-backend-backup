package com.thoughtworks.training.controller;

import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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









    @GetMapping("/user/{user_id}")
    public Map<String, Object> findOrdersByUserId(@PathVariable Integer userId, Principal principal) throws UserException {
        return  orderService.findOrdersByUserId(userId, principal);

    }

}
