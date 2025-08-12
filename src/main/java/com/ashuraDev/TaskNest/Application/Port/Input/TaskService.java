package com.ashuraDev.TaskNest.Application.Port.Input;

import com.ashuraDev.TaskNest.Domain.Models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task createTask(Task task);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);

    Optional<Task> getTaskById(Long id);

    List<Task> getTasksByUserId(Long userId);

    void completeTask(Long taskId);
}
