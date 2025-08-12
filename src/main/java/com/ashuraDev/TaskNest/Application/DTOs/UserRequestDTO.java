package com.ashuraDev.TaskNest.Application.DTOs;


import lombok.Data;

@Data
public class UserRequestDTO {

    private String userName;
    private String email;
    private String fullName;
    private String password;
    private Boolean isAdmin;
}
