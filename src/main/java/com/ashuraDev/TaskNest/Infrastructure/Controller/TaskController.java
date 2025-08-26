package com.ashuraDev.TaskNest.Infrastructure.Controller;

import com.ashuraDev.TaskNest.Application.DTOs.TaskRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.TaskResponseDTO;
import com.ashuraDev.TaskNest.Application.useCases.TaskUseCaseImpl;
import com.ashuraDev.TaskNest.Domain.Models.Task;
import com.ashuraDev.TaskNest.Infrastructure.Mapper.TaskDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskUseCaseImpl taskUseCase;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(@PathVariable Long id){
        Task task = TaskDTOMapper.toDomain(new TaskRequestDTO());
        Task saved = taskUseCase.createTask(task);
        return ResponseEntity.ok(TaskDTOMapper.toResponse(saved));

    }
}
