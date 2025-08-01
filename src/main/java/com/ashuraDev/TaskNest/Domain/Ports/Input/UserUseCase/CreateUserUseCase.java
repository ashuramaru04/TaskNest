package com.ashuraDev.TaskNest.Domain.Ports.Input.UserUseCase;

import com.ashuraDev.TaskNest.Domain.Models.User;


public interface CreateUserUseCase{
    User createUser(User user);

}
