package com.ashuraDev.TaskNest.Infrastructure.Repositories;

import com.ashuraDev.TaskNest.Infrastructure.Entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataTaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByProjectId(Long projectId);
    List<TaskEntity> findByUserId(Long userId);
}
