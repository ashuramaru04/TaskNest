package com.ashuraDev.TaskNest.Infrastructure.Mapper;

import com.ashuraDev.TaskNest.Application.DTOs.UserRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.UserResponseDTO;
import com.ashuraDev.TaskNest.Domain.Models.User;

public class UserDTOMapper {

    public static User toDomain(UserRequestDTO dto){
        return new User(
                null,
                dto.getUserName(),
                dto.getEmail()
        );
    }
    public static UserResponseDTO toResponse(User user){
     return new UserResponseDTO(
        user.getId(),
        user.getName(),
        user.getEmail());
    }
}
