package com.ashuraDev.TaskNest.Domain.Ports.Input.UserUseCase;

import com.ashuraDev.TaskNest.Domain.Models.User;

import java.util.Optional;

public interface UpdateUserUseCase {
    Optional<User> updateUser(Long id, User updateUser);
}
