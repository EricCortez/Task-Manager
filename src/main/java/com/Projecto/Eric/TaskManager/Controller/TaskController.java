package com.Projecto.Eric.TaskManager.Controller;

import com.Projecto.Eric.TaskManager.DTO.TaskRequest;
import com.Projecto.Eric.TaskManager.DTO.TaskResponse;
import com.Projecto.Eric.TaskManager.Sevice.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAll() {
        return ResponseEntity.ok(taskService.getAllTasks(null));
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody TaskRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.create(request, null));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskResponse> complete(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.complete(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(@PathVariable Long id,
                                               @RequestBody TaskRequest request) {
        return ResponseEntity.ok(taskService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TaskResponse>> filter(@RequestParam boolean completed) {
        return ResponseEntity.ok(taskService.getByCompleted(completed));
    }

}
