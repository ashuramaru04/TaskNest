package com.ashuraDev.TaskNest.Domain.Models;



import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;


@Data
public class User {
    private final Long id;
    private boolean isAdmin;
    private String userName;
    private String email;
    private String fullName;
    private String passwordHash;
    private boolean isActive;
    private LocalDate createdAt;
    private LocalDate updateAt;

    //create a user
    public User(Long id, String username, String email, String passwordHash, boolean active, LocalDate createdAt) {
        this.id = id;
        this.userName = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.isActive = active;
        this.createdAt = createdAt;

    }


// tell us if the User is active

    public void activate() {
        this.isActive = true;
    }
    public void deactivate() {
        this.isActive = false;
    }



}


