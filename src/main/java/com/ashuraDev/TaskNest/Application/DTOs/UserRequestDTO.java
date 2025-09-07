package com.ashuraDev.TaskNest.Application.DTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank
    private String userName;
    @Email
    private String email;
    private String fullName;
    private String password;
    private Boolean isAdmin;
}
