package com.zeynep.momentum.controller;

import com.zeynep.momentum.dto.AuthResponse;
import com.zeynep.momentum.dto.RegisterRequest;
import com.zeynep.momentum.service.AuthService;


import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request
    ){


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        authService.register(request)
                );

    }
}
