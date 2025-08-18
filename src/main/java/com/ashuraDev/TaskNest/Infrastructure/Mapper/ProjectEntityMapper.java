package com.ashuraDev.TaskNest.Infrastructure.Mapper;

import com.ashuraDev.TaskNest.Application.DTOs.ProjectRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.ProjectResponseDTO;
import com.ashuraDev.TaskNest.Domain.Models.Project;


public class ProjectEntityMapper {

    public Project toDomain(ProjectRequestDTO dto, Long id){
        return new Project(
                id,
                dto.getName(),
                dto.getDescription(),
                dto.getStarDate(),
                dto.getEndDate()
        );
    }

    public ProjectResponseDTO toEntity(Project project) {
        return new ProjectResponseDTO(
                project.getId(),
                project.getProjectName(),
                project.getDescription(),
                project.getProjectState(),
                project.getActive(),
                project.getOwnerId(),
                project.getStarDate(),
                project.getUpdateAt()


        );
    }
}
