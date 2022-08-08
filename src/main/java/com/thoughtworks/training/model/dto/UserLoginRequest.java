package com.thoughtworks.training.model.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {
    private String credentialId;
    private String credential;
    private String captchaCode;
}
