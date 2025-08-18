package com.ashuraDev.TaskNest.Application.DTOs;

import lombok.Data;

import java.time.LocalDate;


@Data
public class TaskRequestDTO {
    String title;
    String description;
    LocalDate dueDate;
    Long userId;
    Long projectId;

}
