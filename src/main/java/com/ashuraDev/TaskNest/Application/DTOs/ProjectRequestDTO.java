package com.ashuraDev.TaskNest.Application.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor

@Data
public class ProjectRequestDTO {
    String name;
    String description;
    LocalDate starDate;
    LocalDate endDate;
}
