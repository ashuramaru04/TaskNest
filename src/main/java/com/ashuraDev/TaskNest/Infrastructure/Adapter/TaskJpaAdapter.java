package com.ashuraDev.TaskNest.Infrastructure.Adapter;

import com.ashuraDev.TaskNest.Application.Port.Out.TaskRepository;
import com.ashuraDev.TaskNest.Domain.Models.Task;
import com.ashuraDev.TaskNest.Infrastructure.Entities.TaskEntity;
import com.ashuraDev.TaskNest.Infrastructure.Mapper.TaskEntityMapper;
import com.ashuraDev.TaskNest.Infrastructure.Repositories.SpringDataTaskRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskJpaAdapter implements TaskRepository {

    private final SpringDataTaskRepository repository;
    private final TaskEntityMapper mapper;

    public TaskJpaAdapter(SpringDataTaskRepository repository, TaskEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Task save(Task task) {
        TaskEntity saved = repository.save(mapper.toEntity(task));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Task> findByProjectId(Long projectId) {
        return repository.findByProjectId(projectId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> findByUserId(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
