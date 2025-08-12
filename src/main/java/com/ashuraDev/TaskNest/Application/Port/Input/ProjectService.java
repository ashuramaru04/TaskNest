package com.ashuraDev.TaskNest.Application.Port.Input;

import com.ashuraDev.TaskNest.Domain.Models.Project;

import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    void deleteProject(Long id);

    Project updateProject(Long id, Project project);

    List<Project> getProjectById(Long id);

    List<Project> getTaskByProjectId(Long projectId);

    List<Project> getProjectsByOwnerId(Long userId);



}
