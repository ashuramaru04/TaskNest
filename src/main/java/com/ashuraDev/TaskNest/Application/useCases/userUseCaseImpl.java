package com.ashuraDev.TaskNest.Application.useCases;

import com.ashuraDev.TaskNest.Application.Port.Input.UserService;
import com.ashuraDev.TaskNest.Application.Port.Out.UserRepository;
import com.ashuraDev.TaskNest.Domain.Models.User;

import java.util.List;
import java.util.Optional;

public class userUseCaseImpl implements UserService {
    private final UserRepository userRepository;

    public userUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        User user= UserMapper

        return null;
    }

    @Override
    public Optional<User> updateUser(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public List<User> getUserById(Long id) {
        return List.of();
    }

    @Override
    public List<User> getALLusers() {
        return List.of();
    }
}
