package com.ashuraDev.TaskNest.Application.Port.Input;

import com.ashuraDev.TaskNest.Domain.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    Optional<User> updateUser(Long id);

    void deleteUser(Long id);

    List<User> getUserById(Long id);

    List<User> getALLusers();

}
