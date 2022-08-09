package com.thoughtworks.training.model.dto;

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
