package com.thoughtworks.training.model.dto;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
    private String name;
    private String username;
    private String password;
    private String captchaCode;
    private String email;
}
