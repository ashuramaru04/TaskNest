package com.ashuraDev.TaskNest.Application.useCases;

import com.ashuraDev.TaskNest.Application.Port.Input.ProjectService;
import com.ashuraDev.TaskNest.Application.Port.Out.ProjectRepository;
import com.ashuraDev.TaskNest.Domain.Models.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<Project> getALLProjects() {
        return projectRepository.findAll();
    }


    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findProjectById(id);
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
