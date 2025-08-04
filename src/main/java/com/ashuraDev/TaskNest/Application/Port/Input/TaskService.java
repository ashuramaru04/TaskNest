package com.ashuraDev.TaskNest.Application.Port.Input;

import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);

    Task getTaskById(Long id);

    List<Task> getTasksByUserId(Long userId);

    void completeTask(Long taskId);
}
