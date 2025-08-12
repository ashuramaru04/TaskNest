package com.ashuraDev.TaskNest.Application.DTOs;


import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDTO {
    private Long id;
    private String userName;
    private String email;
    private String fullName;
    private Boolean isAdmin;
    private Boolean isActive;
    private LocalDate createdAt;
    private LocalDate updateAt;


}
