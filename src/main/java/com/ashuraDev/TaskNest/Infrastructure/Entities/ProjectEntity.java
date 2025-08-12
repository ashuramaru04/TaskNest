package com.ashuraDev.TaskNest.Infrastructure.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "projects")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private long ownerId;
    private LocalDate starDate;
    private LocalDate endDate;

    public ProjectEntity() {
    }

}