package com.thoughtworks.training.controller.dto;

import com.thoughtworks.training.entity.Role;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {
    private String username;
    private String email;
    private Set<Role> roles;
}
