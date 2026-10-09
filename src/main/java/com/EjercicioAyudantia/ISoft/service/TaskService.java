package com.EjercicioAyudantia.ISoft.service;

import com.EjercicioAyudantia.ISoft.model.Task;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

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

    public List<Task> listar(String prioridad, String titulo, String fechaLimite) {
        return tareas.values().stream()
                .filter(tarea -> prioridad == null || prioridad.equalsIgnoreCase(tarea.getPrioridad()))
                .filter(tarea -> titulo == null
                        || (tarea.getTitulo() != null
                        && tarea.getTitulo().toLowerCase().contains(titulo.toLowerCase())))
                .filter(tarea -> fechaLimite == null || fechaLimite.equals(tarea.getFechaLimite()))
                .sorted(Comparator.comparing(Task::getId))
                .collect(Collectors.toList());
    }

    public Task completar(Long id) {
        Task tarea = tareas.get(id);
        if (tarea == null) {
            return null;
        }
        tarea.setCompletada(true);
        return tarea;
    }
}
