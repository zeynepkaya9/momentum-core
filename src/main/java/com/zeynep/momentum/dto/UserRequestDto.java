package com.zeynep.momentum.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRequestDto {


    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;



    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;



    @NotBlank(message = "First name cannot be empty")
    private String firstName;



    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

}