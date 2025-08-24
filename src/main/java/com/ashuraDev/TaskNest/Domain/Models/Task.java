package com.ashuraDev.TaskNest.Domain.Models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
    private Long projectId;
    private Long userId;




    //Mapper constructor
    public Task(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
