package com.EjercicioAyudantia.ISoft.controller;

import com.EjercicioAyudantia.ISoft.model.Task;
import com.EjercicioAyudantia.ISoft.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskCreationController {

    private final TaskService taskService;

    public TaskCreationController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> crear(@RequestBody Task tarea) {
        Task nuevaTarea = taskService.crear(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTarea);
    }
}
