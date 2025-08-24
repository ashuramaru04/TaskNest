package com.ashuraDev.TaskNest.Infrastructure.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isAdmin;
    @Column(nullable = false)
    private String name;


    @Column(nullable = false, unique = true)
    private String email;

    private String fullName;
    private String passwordHash;
    private Boolean isActive;
    private LocalDate createAt;
    private LocalDate updateAt;


    public UserEntity(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
