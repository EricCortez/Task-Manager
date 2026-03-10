package com.Projecto.Eric.TaskManager.Repo;

import jakarta.annotation.Priority;
import com.Projecto.Eric.TaskManager.model.Task;
import com.Projecto.Eric.TaskManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    List<Task> findByUserAndCompleted(User user, boolean completed);
    List<Task> findByUserAndPriority(User user, Priority priority);
}