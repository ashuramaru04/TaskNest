package com.ashuraDev.TaskNest.Domain.Ports.Input.UserUseCase;

import com.ashuraDev.TaskNest.Domain.Models.User;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {

    Optional<User> getUserById(long id);

    List<User> getALLUser();
}
