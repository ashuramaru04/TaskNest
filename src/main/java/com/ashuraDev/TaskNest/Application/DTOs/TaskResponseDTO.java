package com.ashuraDev.TaskNest.Application.DTOs;
import lombok.Data;


import java.time.LocalDate;

@Data
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDate dueDate;
    private Long userId;
    private Long projectId;

}
