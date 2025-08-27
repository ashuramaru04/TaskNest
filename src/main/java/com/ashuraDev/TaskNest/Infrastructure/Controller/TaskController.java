package com.ashuraDev.TaskNest.Infrastructure.Controller;

import com.ashuraDev.TaskNest.Application.DTOs.TaskRequestDTO;
import com.ashuraDev.TaskNest.Application.DTOs.TaskResponseDTO;
import com.ashuraDev.TaskNest.Application.useCases.TaskUseCaseImpl;
import com.ashuraDev.TaskNest.Domain.Models.Task;
import com.ashuraDev.TaskNest.Infrastructure.Mapper.TaskDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getById(@PathVariable Long id){
        return taskUseCase.getTaskById(id)
                .map(TaskDTOMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<TaskResponseDTO>> getByProject(@PathVariable Long projectId){
        List<TaskResponseDTO> task = taskUseCase.getTasksByProject(projectId)
                .stream()
                .map(TaskDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}/assign/{userId}")
    public ResponseEntity<TaskResponseDTO> assign(@PathVariable Long id, @PathVariable Long userId){
        Task updated = taskUseCase.markAsCompleted(id);
        return ResponseEntity.ok(TaskDTOMapper.toResponse(updated));
    }
    @PutMapping("/{id}/complete")
    public ResponseEntity<TaskResponseDTO> complete(@PathVariable Long id) {
        Task updated = taskUseCase.markAsCompleted(id);
        return ResponseEntity.ok(TaskDTOMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskUseCase.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
