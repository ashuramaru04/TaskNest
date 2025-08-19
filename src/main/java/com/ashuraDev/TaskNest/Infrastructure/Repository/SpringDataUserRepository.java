package com.ashuraDev.TaskNest.Infrastructure.Repository;

import com.ashuraDev.TaskNest.Infrastructure.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataUserRepository  extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
