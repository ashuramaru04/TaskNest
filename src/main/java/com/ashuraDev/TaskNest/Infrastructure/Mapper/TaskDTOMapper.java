package com.ashuraDev.TaskNest.Infrastructure.Mapper;

import com.ashuraDev.TaskNest.Application.DTOs.TaskRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.TaskResponseDTO;
import com.ashuraDev.TaskNest.Domain.Models.Task;

public class TaskDTOMapper {

    public static Task toDomain(TaskRequestDTO dto){
        return new Task(
                null,
                dto.getTitle(),
                dto.getDescription()
        );
    }
    public static TaskResponseDTO toResponse(Task task){
        return new TaskResponseDTO(
                task.getUserId(),
                task.getTitle(),
                task.getDescription()

                );
    }

}
