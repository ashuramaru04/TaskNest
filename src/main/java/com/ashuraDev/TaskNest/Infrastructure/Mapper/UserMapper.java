package com.ashuraDev.TaskNest.Infrastructure.Mapper;

import com.ashuraDev.TaskNest.Application.DTOs.UserRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.UserResponseDTO;
import com.ashuraDev.TaskNest.Domain.Models.User;
import com.ashuraDev.TaskNest.Infrastructure.Entities.UserEntity;

import java.time.LocalDate;

public class UserMapper {

    public static User toDomain(UserRequestDTO dto){
        return new User (
                null,
                dto.getUserName(),
                dto.getEmail(),
                dto.getPassword(),
                true,
                LocalDate.now()
        );
    }

    public static UserResponseDTO toResponseDTO(User user){
        UserResponseDTO dto= new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setIsActive(user.isActive());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdateAt(user.getUpdateAt());
        return dto;
    }
    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUserName(user.getUserName());
        entity.setEmail(user.getEmail());
        entity.setFullName(user.getFullName());
        entity.setIsAdmin(user.isAdmin());
        entity.setPasswordHash(user.getPasswordHash());
        entity.setIsActive(user.isActive());
        entity.setCreateAt(user.getCreatedAt());
        entity.setUpdateAt(user.getUpdateAt());
        return entity;
    }


    public static User toDomain(UserEntity entity) {
        User user = new User(
                entity.getId(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getPasswordHash(),
                entity.getIsActive(),
                entity.getCreateAt()
        );
        user.setAdmin(entity.getIsAdmin());
        user.setFullName(entity.getFullName());
        user.setUpdateAt(entity.getUpdateAt());
        return user;
    }
}
