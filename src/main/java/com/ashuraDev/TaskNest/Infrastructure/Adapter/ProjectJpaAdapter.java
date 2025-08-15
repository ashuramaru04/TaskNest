package com.ashuraDev.TaskNest.Infrastructure.Adapter;

import com.ashuraDev.TaskNest.Application.Port.Out.ProjectRepository;
import com.ashuraDev.TaskNest.Domain.Models.Project;

import java.util.List;
import java.util.Optional;

public class ProjectJpaAdapter implements ProjectRepository {

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public List<Project> findProjectById(Long id) {
        return List.of();
    }

    @Override
    public Optional<Project> update(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Project> findAll() {
        return List.of();
    }

    @Override
    public void deleteProjectById(Long id) {

    }

    @Override
    public List<Project> getByOwnerId(Long userId) {
        return List.of();
    }
}
