package com.ashuraDev.TaskNest.Infrastructure.Mapper;

import com.ashuraDev.TaskNest.Domain.Models.Project;
import com.ashuraDev.TaskNest.Infrastructure.Entities.ProjectEntity;

public class ProjectEntityMapper {

    public ProjectEntity toEntity(Project domain){
        return new ProjectEntity(
                domain.getId(),
                domain.getProjectName(),
                domain.getDescription(),
                domain.getProjectState(),
                domain.getOwnerId(),
                domain.getActive(),
                domain.getStarDate(),
                domain.getEndDate(),
                domain.getAssignedUsers()

        );
    }
    public Project toDomain(ProjectEntity entity){
        return new Project(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getProjectState(),
                entity.getOwnerId(),
                entity.getActive(),
                entity.getStarDate(),
                entity.getEndDate(),
                entity.getAssignedUsers()

        );
    }
}
