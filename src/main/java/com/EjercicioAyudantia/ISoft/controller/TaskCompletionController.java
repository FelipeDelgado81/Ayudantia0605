package com.EjercicioAyudantia.ISoft.controller;

import com.EjercicioAyudantia.ISoft.model.Task;
import com.EjercicioAyudantia.ISoft.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskCompletionController {

    private final TaskService taskService;

    public TaskCompletionController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Task> completar(@PathVariable Long id) {
        Task tarea = taskService.completar(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarea);
    }
}
