package com.ashuraDev.TaskNest.Application.DTOs;


import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
