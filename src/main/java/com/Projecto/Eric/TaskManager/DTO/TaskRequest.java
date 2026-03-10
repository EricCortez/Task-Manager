package com.Projecto.Eric.TaskManager.DTO;


import com.Projecto.Eric.TaskManager.model.Priority;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskRequest {
    private String title;
    private String description;
    private Priority priority;
    private LocalDateTime dueDate;
}