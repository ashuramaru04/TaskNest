package com.ashuraDev.TaskNest.Application.Port.Input;

import com.ashuraDev.TaskNest.Domain.Models.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project createProject(Project project);

    void deleteProject(Long id);

    Project updateProject(Long id, Project project);

    List<Project> getALLProjects();

    Optional<Project> getProjectById(Long id);

    List<Project> getTaskByProjectId(Long projectId);

    List<Project> getProjectsByOwnerId(Long userId);



}
