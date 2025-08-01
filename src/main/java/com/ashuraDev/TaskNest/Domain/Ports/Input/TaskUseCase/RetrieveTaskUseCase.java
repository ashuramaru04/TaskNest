package com.ashuraDev.TaskNest.Domain.Ports.Input.TaskUseCase;

import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTaskById(long id);

    List<Task> getALLTask();
}
