package com.ashuraDev.TaskNest.Infrastructure.Repository;

import com.ashuraDev.TaskNest.Infrastructure.Entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataProjectRepository extends JpaRepository<ProjectEntity, Long> {



}
