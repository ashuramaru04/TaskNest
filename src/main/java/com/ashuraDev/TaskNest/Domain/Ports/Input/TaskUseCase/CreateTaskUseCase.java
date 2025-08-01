package com.ashuraDev.TaskNest.Domain.Ports.Input.TaskUseCase;

import org.springframework.scheduling.config.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
