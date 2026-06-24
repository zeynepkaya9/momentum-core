package com.zeynep.momentum.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponse {

    private Long userId;

    private String email;

    private String message;
}
