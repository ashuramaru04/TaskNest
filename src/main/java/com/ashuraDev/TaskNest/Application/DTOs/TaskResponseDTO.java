package com.ashuraDev.TaskNest.Application.DTOs;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TaskResponseDTO {
    Long id;
    String title;
    String description;
    boolean state;
    LocalDate dueDate;
    Long userId;
    Long projectId;
    LocalDate createdAt;
    LocalDate updateAt;


}
