package com.ashuraDev.TaskNest.Domain.Models;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;



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
    private List<User> assignedUsers;


    public Project(Long id, String projectName, String description, String projectState, Long ownerId, Boolean active, LocalDate starDate, LocalDate endDate, List<User> assignedUsers) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.projectState = projectState;
        this.ownerId = ownerId;
        this.active = active;
        this.starDate = starDate;
        this.endDate = endDate;
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
        this.endDate = expirationDate;
    }
    //if the project are expired
    public boolean isOverDue(){
        return LocalDate.now().isAfter(endDate);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<User> getAssignedUsers() {
        return assignedUsers;
    }

    public void setAssignedUsers(List<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }
}


