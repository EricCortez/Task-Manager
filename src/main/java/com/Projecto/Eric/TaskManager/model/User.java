package com.Projecto.Eric.TaskManager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data                        // Lombok — genera getters/setters
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
}