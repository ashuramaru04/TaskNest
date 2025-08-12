package com.ashuraDev.TaskNest.Infrastructure.Entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isAdmin;
    private String userName;
    private String email;
    private String fullName;
    private String passwordHash;



}
