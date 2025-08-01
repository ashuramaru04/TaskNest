package com.ashuraDev.TaskNest.Domain.Ports.Input.UserUseCase;

import com.ashuraDev.TaskNest.Domain.Models.User;

public interface DeleteUserUseCase {
     void deleteUserById(long id);

}
