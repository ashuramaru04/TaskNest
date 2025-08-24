package com.ashuraDev.TaskNest.Application.useCases;

import com.ashuraDev.TaskNest.Application.Port.Input.ProjectService;
import com.ashuraDev.TaskNest.Application.Port.Out.ProjectRepository;
import com.ashuraDev.TaskNest.Domain.Models.Project;

import java.util.List;

public class ProjectUseCaseImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectUseCaseImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteProjectById(id);

    }

    @Override
    public Project updateProject(Long id, Project project) {
        Project existing = projectRepository.update(id)
                .orElseThrow(() -> new IllegalArgumentException("Proyecto no encontrado"));



        return projectRepository.save(existing);
    }


    @Override
    public List<Project> getProjectById(Long id) {
        return List.of();
    }

    @Override
    public List<Project> getTaskByProjectId(Long projectId) {
        return List.of();
    }

    @Override
    public List<Project> getProjectsByOwnerId(Long userId) {
        return List.of();
    }
}
