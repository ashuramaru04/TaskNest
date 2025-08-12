package com.ashuraDev.TaskNest.Application.useCases;


import com.ashuraDev.TaskNest.Application.Port.Input.TaskService;
import com.ashuraDev.TaskNest.Application.Port.Out.TaskRepository;
import com.ashuraDev.TaskNest.Domain.Models.Task;


import java.util.List;
import java.util.Optional;

public class TaskUseCaseImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskUseCaseImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task createTask(Task task) {
        task.setCompleted(false);
        return taskRepository.save(task) ;
    }

    @Override
    public Task updateTask(Long id, Task updatetask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("task not find"));
        existingTask.setTitle(updatetask.getTitle());
        existingTask.setDescription(updatetask.getDescription());
        existingTask.setExpirationDate(updatetask.getExpirationDate());
        existingTask.setAssignedUser(updatetask.getAssignedUser());

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
        return taskRepository.findUserById(userId);
    }

    @Override
    public void completeTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()-> new IllegalArgumentException("task not find"));
        task.setCompleted(true);
        taskRepository.save(task);


    }
}
