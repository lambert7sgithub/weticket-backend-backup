package com.thoughtworks.training.service;

import com.thoughtworks.training.controller.dto.UserLoginRequest;
import com.thoughtworks.training.controller.dto.UserProfileResponse;
import com.thoughtworks.training.controller.dto.UserSignInRequest;
import com.thoughtworks.training.controller.dto.UserUpdateRequest;
import com.thoughtworks.training.entity.Role;
import com.thoughtworks.training.entity.User;
import com.thoughtworks.training.repository.RoleRepository;
import com.thoughtworks.training.repository.UserRepository;
import com.thoughtworks.training.utils.JwtTokenUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

@Service
public class UserService {
    @Resource
    private UsernamePasswordUserDetailService userDetailService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private UserRepository repository;

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private JwtTokenUtil tokenUtil;

    public ResponseEntity<Void> login(UserLoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCredentialId(), request.getCredential()));
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails details = userDetailService.loadUserByUsername(request.getCredentialId());
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.AUTHORIZATION);
            headers.add(HttpHeaders.AUTHORIZATION, tokenUtil.generateJwtToken(details));
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Void> register(UserSignInRequest request) {
        Role role = roleRepository.findByName("ROLE_NORMAL").get();
        if (repository.existsByEmail(request.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User user = new User();
            user.setUsername(request.getUsername());
            user.setName(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRoles(Collections.singleton(role));
            repository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    public ResponseEntity<Void> logout(String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> update(String id, UserUpdateRequest request) {
        User user = repository.findById(Long.parseLong(id)).get();
        if (!request.getName().isEmpty()) {
            user.setName(request.getName());
        }
        if (!request.getPassword().isEmpty()) {
            user.setPassword(request.getPassword());
        }
        if (!request.getEmail().isEmpty()) {
            user.setEmail(request.getEmail());
        }
        repository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<UserProfileResponse> profile(String id) {
        User user = repository.findById(Long.parseLong(id)).get();
        UserProfileResponse response = new UserProfileResponse();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setRoles(user.getRoles());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
