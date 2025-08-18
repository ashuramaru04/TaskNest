package com.ashuraDev.TaskNest.Domain.Models;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@Data
public class Project {
    private  Long id;
    private String projectName;
    private String description;
    private String projectState;
    private Long ownerId;
    private Boolean active;
    private LocalDate starDate;
    private LocalDate endDate;
    private LocalDate createAt;
    private LocalDate UpdateAt;
    private List<User> assignedUsers;

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public void updateDetails(String projectName,String description, String projectState, boolean active, LocalDate starDate, LocalDate expirationDate){
        this.projectName = projectName;
        this.description = description;
        this.projectState = projectState;
        this.active = active;
        this.starDate = starDate;
        this.endDate = expirationDate;
    }

    public boolean isOverDue(){
        return LocalDate.now().isAfter(endDate);
    }

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

    public Project(Long id, String name, String description, LocalDate startDate, LocalDate endDate) {

        this.projectName = name;
        this.description = description;
        this.starDate = startDate;
        this.endDate = endDate;
    }

}


