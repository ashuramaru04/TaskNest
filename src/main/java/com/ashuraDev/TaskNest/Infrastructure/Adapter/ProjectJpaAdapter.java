package com.ashuraDev.TaskNest.Infrastructure.Adapter;

import com.ashuraDev.TaskNest.Application.Port.Out.ProjectRepository;
import com.ashuraDev.TaskNest.Domain.Models.Project;
import com.ashuraDev.TaskNest.Infrastructure.Mapper.ProjectEntityMapper;
import com.ashuraDev.TaskNest.Infrastructure.Repository.SpringDataProjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProjectJpaAdapter implements ProjectRepository {

    private final SpringDataProjectRepository repository;
    private final ProjectEntityMapper mapper;

    public ProjectJpaAdapter(SpringDataProjectRepository repository, ProjectEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Project save(Project project) {
        return mapper.toDomain(repository.save(mapper.toEntity(project)));
    }

    @Override
    public List<Project> findProjectById(Long id) {
        return List.of();
    }

    @Override
    public Optional<Project> update(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Project> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProjectById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Project> getByOwnerId(Long userId) {
        return repository.findByOwnerId(userId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
