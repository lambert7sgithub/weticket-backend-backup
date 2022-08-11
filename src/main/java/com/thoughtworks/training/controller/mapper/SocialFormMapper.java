package com.thoughtworks.training.controller.mapper;

import com.thoughtworks.training.controller.dto.SocialFormRequest;
import com.thoughtworks.training.entity.SocialForm;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SocialFormMapper {

    public SocialForm toEntity(SocialFormRequest socialFormRequest){
        SocialForm socialForm = new SocialForm();
        BeanUtils.copyProperties(socialFormRequest,socialForm);
        return socialForm;
    }
}
