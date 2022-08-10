package com.thoughtworks.training.controller;

import com.thoughtworks.training.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dates")
public class DateController {
    @Autowired
    public DateService dateService;

    @GetMapping
    public List<String> findDates() {
        return dateService.generateDates();
    }
}
