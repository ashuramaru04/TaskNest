package com.ashuraDev.TaskNest.Domain.Models;



import lombok.Data;

import java.time.LocalDate;

@Data
public class Task {
    private long id;
    private String title;
    private String description;
    private boolean state;
    private LocalDate dueDate;
    private String assignedUser;
    private LocalDate createAt;
    private LocalDate updateAt;
    private LocalDate isOverDue;
    private Boolean completed;

}
