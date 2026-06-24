package com.zeynep.momentum.service;

import com.zeynep.momentum.dto.RegisterRequest;
import com.zeynep.momentum.dto.AuthResponse;
import com.zeynep.momentum.entity.User;
import com.zeynep.momentum.repository.UserRepository;
import com.zeynep.momentum.exception.EmailAlreadyExistsException;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();

        User savedUser = userRepository.save(user);

        return AuthResponse.builder()
                .userId(savedUser.getId())
                .email(savedUser.getEmail())
                .message("Registration successfull")
                .build();

    }



}
