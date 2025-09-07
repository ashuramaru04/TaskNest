package com.ashuraDev.TaskNest.Infrastructure.Mapper;

import com.ashuraDev.TaskNest.Application.DTOs.TaskRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.TaskResponseDTO;
import com.ashuraDev.TaskNest.Domain.Models.Task;

public class TaskDTOMapper {

    public static Task toDomain(TaskRequestDTO dto){
        return new Task(
                null,
                dto.getTitle(),
                dto.getDescription(),
                dto.getDueDate(),
                false,
                dto.getUserId(),
                dto.getProjectId()
        );
    }
    public static TaskResponseDTO toResponse(Task task){
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.isCompleted());
        dto.setDueDate(task.getDueDate());
        dto.setUserId(task.getUserId());
        dto.setProjectId(task.getProjectId());
        return dto;
    }

}
