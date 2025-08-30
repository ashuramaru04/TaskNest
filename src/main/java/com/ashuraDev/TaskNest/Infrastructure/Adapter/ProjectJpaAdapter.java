package com.ashuraDev.TaskNest.Infrastructure.Adapter;

import com.ashuraDev.TaskNest.Application.Port.Out.ProjectRepository;
import com.ashuraDev.TaskNest.Domain.Models.Project;
import com.ashuraDev.TaskNest.Infrastructure.Entities.ProjectEntity;
import com.ashuraDev.TaskNest.Infrastructure.Mapper.ProjectEntityMapper;
import com.ashuraDev.TaskNest.Infrastructure.Repository.SpringDataProjectRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProjectJpaAdapter implements ProjectRepository {

    private final SpringDataProjectRepository repository;
    private final ProjectEntityMapper mapper;

    public ProjectJpaAdapter(SpringDataProjectRepository repository, ProjectEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Project save(Project project) {
        ProjectEntity entity = mapper.toEntity(project);
        ProjectEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Project> findProjectById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Project> update(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Project> findAll() {
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
        return repository.findById(userId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
