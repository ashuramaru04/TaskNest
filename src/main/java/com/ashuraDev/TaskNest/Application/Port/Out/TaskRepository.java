package com.ashuraDev.TaskNest.Application.Port.Out;



import com.ashuraDev.TaskNest.Domain.Models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);

    Optional<Task> findById(Long id);

    Optional<Task> update(Long id);

    void deleteById (Long id);

    List<Task> findUserById(Long userId);
}
