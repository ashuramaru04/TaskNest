package com.ashuraDev.TaskNest.Application.Port.Input;

import com.ashuraDev.TaskNest.Domain.Models.Project;

import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    void deleteProject(Long id);

    List<Project> getProjectById(Long id);

    List<Project> getTaskByProjectId(Long projectId);

    List<Project> getUserByProjectId(Long userId);


}
