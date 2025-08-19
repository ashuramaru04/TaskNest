package com.ashuraDev.TaskNest.Application.Port.Out;

import com.ashuraDev.TaskNest.Domain.Models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    void deleteById(Long id);
    List<Task> findByProjectId(Long projectId);
    List<Task> findByUserId(Long userId);
}