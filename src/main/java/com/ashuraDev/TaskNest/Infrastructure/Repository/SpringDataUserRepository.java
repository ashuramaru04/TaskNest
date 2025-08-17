package com.ashuraDev.TaskNest.Infrastructure.Repository;

import com.ashuraDev.TaskNest.Infrastructure.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository  extends JpaRepository<UserEntity, Long> {
}
