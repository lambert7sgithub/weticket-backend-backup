package com.thoughtworks.training.service;

import com.thoughtworks.training.entity.SocialForm;
import com.thoughtworks.training.repository.SocialFormRepository;
import com.thoughtworks.training.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class SocialFormService {

    @Resource
    private SocialFormRepository socialFormRepository;
    @Resource
    private UserRepository userRepository;

    public void append(SocialForm socialForm) {
        socialForm.setId(UUID.randomUUID().toString());
        socialFormRepository.save(socialForm);
    }
}
