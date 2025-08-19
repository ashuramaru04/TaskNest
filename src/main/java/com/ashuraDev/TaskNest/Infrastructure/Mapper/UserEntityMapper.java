package com.ashuraDev.TaskNest.Infrastructure.Mapper;

import com.ashuraDev.TaskNest.Domain.Models.User;
import com.ashuraDev.TaskNest.Infrastructure.Entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail()
        );
    }
}
