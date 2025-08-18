
package com.ashuraDev.TaskNest.Infrastructure.Mapper;

import com.ashuraDev.TaskNest.Application.DTOs.ProjectRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.ProjectResponseDTO;
import com.ashuraDev.TaskNest.Domain.Models.Project;
import com.ashuraDev.TaskNest.Infrastructure.Entities.ProjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectEntityMapper {

    // Domain -> Entity
    public ProjectEntity toEntity(Project project) {
        if (project == null) return null;
        ProjectEntity entity = new ProjectEntity();
        entity.setId(project.getId());
        entity.setName(project.getName());
        entity.setDescription(project.getDescription());
        entity.setStartDate(project.getStartDate());
        entity.setEndDate(project.getEndDate());
        entity.setOwnerId(project.getOwnerId());
        return entity;
    }

    // Entity -> Domain
    public Project toDomain(ProjectEntity entity) {
        if (entity == null) return null;
        return new Project(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getOwnerId()
        );
    }

    // Domain -> Response DTO
    public ProjectResponseDTO toResponseDTO(Project project) {
        if (project == null) return null;
        return new ProjectResponseDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate(),
                project.getOwnerId()
        );
    }

    // Request DTO -> Domain
    public Project toDomain(ProjectRequestDTO dto) {
        if (dto == null) return null;
        return new Project(
                null,
                dto.getName(),
                dto.getDescription(),
                dto.getStartDate(),
                dto.getEndDate(),
                dto.getOwnerId()
        );
    }
}