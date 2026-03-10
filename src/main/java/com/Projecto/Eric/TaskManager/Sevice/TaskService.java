package com.Projecto.Eric.TaskManager.Sevice;

import com.Projecto.Eric.TaskManager.DTO.TaskRequest;
import com.Projecto.Eric.TaskManager.DTO.TaskResponse;
import com.Projecto.Eric.TaskManager.model.Task;
import com.Projecto.Eric.TaskManager.model.User;
import com.Projecto.Eric.TaskManager.Repo.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepository;

    public List<TaskResponse> getAllTasks(User user) {
        return taskRepository.findByUser(user)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TaskResponse create(TaskRequest request, User user) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());
        task.setCompleted(false);
        task.setUser(user);
        return toResponse(taskRepository.save(task));
    }

    public TaskResponse complete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(true);
        return toResponse(taskRepository.save(task));
    }

    private TaskResponse toResponse(Task task) {
        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setCompleted(task.isCompleted());
        response.setPriority(task.getPriority());
        response.setDueDate(task.getDueDate());
        return response;
    }

    public TaskResponse update(Long id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());
        return toResponse(taskRepository.save(task));
    }
    public void delete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }

    public List<TaskResponse> getByCompleted(boolean completed) {
        return taskRepository.findByUserAndCompleted(null, completed)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}