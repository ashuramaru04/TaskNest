package com.ashuraDev.TaskNest.Infrastructure.Repository;

import com.ashuraDev.TaskNest.Infrastructure.Entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataProjectRepository extends JpaRepository<ProjectEntity, Long> {


    List<ProjectEntity> findByOwnerId(Long ownerId);

    Long id(Long id);

    Long OwnerId(Long ownerId);
}
