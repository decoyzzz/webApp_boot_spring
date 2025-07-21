package com.examplewebapp.mywebapp.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.examplewebapp.mywebapp.service.TaskService;
import com.examplewebapp.mywebapp.dto.Task;


@RestController
@RequestMapping
public class TaskController {
    
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task)
    {
        Task created = taskService.addTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("tasks/{id}")
    public ResponseEntity<Void> toggleTask(@PathVariable Long id)
    {
        taskService.toggleTask(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id)
    {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
