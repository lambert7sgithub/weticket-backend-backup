package com.thoughtworks.training.controller.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignInRequest {
    private String username;
    private String password;
    private String captchaCode;
    private String email;
}
