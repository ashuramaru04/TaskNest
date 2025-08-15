package com.ashuraDev.TaskNest.Infrastructure.Entities;

import com.ashuraDev.TaskNest.Domain.Models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "projects")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String projectState;
    private Long ownerId;
    private Boolean active;
    private LocalDate starDate;
    private LocalDate endDate;
    private List<User> assignedUsers;



}