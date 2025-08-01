package com.ashuraDev.TaskNest.Domain.Models;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Project {
    private  final Long id;
    private String projectName;
    private String description;
    private String projectState;
    private Boolean active;
    private LocalDate starDate;
    private LocalDate expirationDate;
    private final List<User> assignedUsers;

    public Project(Long id, List<User> assignedUsers) {
        this.id = id;
        this.assignedUsers = assignedUsers;
    }


    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
    //show project details
    public void updateDetails(String projectName,String description, String projectState, boolean active, LocalDate starDate, LocalDate expirationDate){
        this.projectName = projectName;
        this.description = description;
        this.projectState = projectState;
        this.active = active;
        this.starDate = starDate;
        this.expirationDate = expirationDate;
    }
    //if the project are expired
    public boolean isOverDue(){
        return LocalDate.now().isAfter(expirationDate);
    }
    //if the current date is before the project's start date
    public boolean isUpcoming(){
        return LocalDate.now().isBefore(starDate);
    }

    public void assignUser (User user) {
        if(!assignedUsers.contains(user)) {
        assignedUsers.add(user);
        }

    }
    public void unassignUser (User user){
        assignedUsers.remove(user);
    }

    public boolean isUserAssigned(User user){
        return assignedUsers.contains(user);
    }

    public List<User> getAssignedUsers(User user){
        return List.copyOf(assignedUsers);
    }
}


