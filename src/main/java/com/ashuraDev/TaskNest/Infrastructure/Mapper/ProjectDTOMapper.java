package com.ashuraDev.TaskNest.Infrastructure.Mapper;

import com.ashuraDev.TaskNest.Application.DTOs.ProjectRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.ProjectResponseDTO;
import com.ashuraDev.TaskNest.Domain.Models.Project;

public class ProjectDTOMapper {

    // De DTO de request a modelo de dominio
    public static Project toDomain(ProjectRequestDTO dto) {
        if (dto == null) return null;

        return Project.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .ownerId(dto.getOwnerId()) // relación con el usuario dueño del proyecto
                .build();
    }

    // De modelo de dominio a DTO de response
    public static ProjectResponseDTO toResponse(Project project) {
        if (project == null) return null;

        return ProjectResponseDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .ownerId(project.getOwnerId())
                .build();
    }
}