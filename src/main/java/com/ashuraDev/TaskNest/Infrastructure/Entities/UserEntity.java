package com.ashuraDev.TaskNest.Infrastructure.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isAdmin;
    private String userName;
    private String email;
    private String fullName;
    private String passwordHash;
    private Boolean isActive;
    private LocalDate createAt;
    private LocalDate updateAt;


}
