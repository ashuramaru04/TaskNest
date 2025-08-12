package com.ashuraDev.TaskNest.Application.Port.Out;

import com.ashuraDev.TaskNest.Domain.Models.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Project save(Project project);
    List<Project> findProjectById(Long id);
    Optional<Project> update(Long id);
    List<Project> findAll();
    void deleteProjectById(Long id);
    List<Project> getByOwnerId(Long userId);
}
