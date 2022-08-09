package com.thoughtworks.training.model.dto;

import com.thoughtworks.training.model.entity.Role;
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
