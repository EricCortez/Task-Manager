package com.Projecto.Eric.TaskManager.model;

import com.Projecto.Eric.TaskManager.model.Priority;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setPriority(jakarta.annotation.Priority priority) {
    }

    public void setPriority(Priority priority) {
    }
}