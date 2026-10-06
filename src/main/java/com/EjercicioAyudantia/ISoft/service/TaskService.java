package com.EjercicioAyudantia.ISoft.service;

import com.EjercicioAyudantia.ISoft.model.Task;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final Map<Long, Task> tareas = new ConcurrentHashMap<>();
    private final AtomicLong contadorId = new AtomicLong(0);

    public Task crear(Task tarea) {
        Long id = contadorId.incrementAndGet();
        Task nuevaTarea = new Task(
                id,
                tarea.getTitulo(),
                tarea.getPrioridad(),
                tarea.getFechaLimite(),
                false
        );
        tareas.put(id, nuevaTarea);
        return nuevaTarea;
    }
}
