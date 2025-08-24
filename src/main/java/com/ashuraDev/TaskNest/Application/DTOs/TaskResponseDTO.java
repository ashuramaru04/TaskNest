package com.ashuraDev.TaskNest.Application.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TaskResponseDTO {
    Long id;
    String title;
    String description;

}
