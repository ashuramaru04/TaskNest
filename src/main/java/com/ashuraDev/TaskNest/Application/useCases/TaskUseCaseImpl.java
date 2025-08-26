package com.ashuraDev.TaskNest.Application.useCases;


import com.ashuraDev.TaskNest.Application.Port.Input.TaskService;
import com.ashuraDev.TaskNest.Application.Port.Out.TaskRepository;
import com.ashuraDev.TaskNest.Domain.Models.Task;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TaskUseCaseImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskUseCaseImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task createTask(Task task) {
        task.setCompleted(false);
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("El título de la tarea es obligatorio");
        }
        return taskRepository.save(task) ;
    }

    @Override
    public Task updateTask(Long id, Task updatetask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("task not find"));
        existingTask.setTitle(updatetask.getTitle());
        existingTask.setDescription(updatetask.getDescription());
        existingTask.setDueDate(updatetask.getDueDate());

        return taskRepository.save(existingTask);
    }


    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);

    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);

    }

    @Override
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task assignTask(Long taskId, Long userId) {
        Optional<Task> taskOpt = taskRepository.findById(taskId);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setUserId(userId);
            return taskRepository.save(task);
        }
        throw new RuntimeException("Task not found with id: " + taskId);
    }
    public Task markAsCompleted(Long taskId) {
        Optional<Task> taskOpt = taskRepository.findById(taskId);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setCompleted(true);
            return taskRepository.save(task);
        }
        throw new RuntimeException("Task not found with id: " + taskId);
    }

    @Override
    public void completeTask(Long taskId) {
        taskRepository.findById(taskId)
                .map(task -> {
                    task.setCompleted(true);
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("task not find:" + taskId));
    }
    public List<Task> getTasksByProject(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

}
