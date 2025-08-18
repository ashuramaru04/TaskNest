package com.ashuraDev.TaskNest.Application.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor

@Data
public class ProjectResponseDTO {
    private Long id;
    private String projectName;
    private String description;
    private String projectState;
    private boolean active;
    private Long ownerId;
    private LocalDate starDate;
    private LocalDate expirationDate;
}
