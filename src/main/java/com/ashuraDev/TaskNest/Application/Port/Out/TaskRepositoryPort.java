package com.ashuraDev.TaskNest.Application.Port.Out;

import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task task);

    Optional<Task> findById(Long id);

    void deleteById (Long id);

    List<Task> findUserById(Long userId);
}
