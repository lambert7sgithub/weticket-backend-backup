package com.thoughtworks.training.controller;

import com.thoughtworks.training.controller.dto.SocialFormRequest;
import com.thoughtworks.training.controller.mapper.SocialFormMapper;
import com.thoughtworks.training.entity.SocialForm;
import com.thoughtworks.training.service.SocialFormService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/socialForm")
public class SocialFormController {

    @Resource
    private SocialFormService socialFormService;
    @Resource
    private SocialFormMapper socialFormMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addSocialForm(@RequestBody SocialFormRequest socialFormRequest) {
        SocialForm socialForm = socialFormMapper.toEntity(socialFormRequest);
        socialFormService.append(socialForm);
    }

}
