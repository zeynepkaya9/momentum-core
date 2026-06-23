package com.zeynep.momentum.controller;

import com.zeynep.momentum.dto.UserRequestDto;
import com.zeynep.momentum.dto.UserResponseDto;
import com.zeynep.momentum.entity.User;
import com.zeynep.momentum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(
            @Valid @RequestBody UserRequestDto request
    ){

        return userService.createUser(request);

    }
}
