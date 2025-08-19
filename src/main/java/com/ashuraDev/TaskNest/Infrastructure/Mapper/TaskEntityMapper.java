package com.ashuraDev.TaskNest.Infrastructure.Mapper;

import com.ashuraDev.TaskNest.Domain.Models.Task;
import com.ashuraDev.TaskNest.Infrastructure.Entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskEntityMapper {

    public TaskEntity toEntity(Task task) {
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.isCompleted(),
                task.getProjectId(),
                task.getUserId()
        );
    }

    public Task toDomain(TaskEntity entity) {
        return new Task(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getDueDate(),
                entity.isCompleted(),
                entity.getProjectId(),
                entity.getUserId()
        );
    }
}
