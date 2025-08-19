package com.ashuraDev.TaskNest.Infrastructure.Adapter;

import com.ashuraDev.TaskNest.Application.Port.Out.UserRepository;
import com.ashuraDev.TaskNest.Domain.Models.User;
import com.ashuraDev.TaskNest.Infrastructure.Entities.UserEntity;
import com.ashuraDev.TaskNest.Infrastructure.Mapper.UserEntityMapper;
import com.ashuraDev.TaskNest.Infrastructure.Repository.SpringDataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements UserRepository {

    private final SpringDataUserRepository repository;
    private final UserEntityMapper mapper;

    @Override
    public User save(User user) {
        UserEntity saved = repository.save(mapper.toEntity(user));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
