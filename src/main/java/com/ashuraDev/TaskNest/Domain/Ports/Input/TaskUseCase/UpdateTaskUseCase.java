package com.ashuraDev.TaskNest.Domain.Ports.Input.TaskUseCase;

import org.springframework.scheduling.config.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {

    Optional<Task> updateTask(long id, Task updateTask);

}
