package com.ashuraDev.TaskNest.Domain.Models;



import lombok.Data;

import java.time.LocalDate;

@Data
public class Tasks {
    private long id;
    private String title;
    private String description;
    private String state;
    private LocalDate expirationDate;
    private String assignedUser;
    private LocalDate isOverDue;


}
