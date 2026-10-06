package com.EjercicioAyudantia.ISoft.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Task {

    private Long id;
    private String titulo;
    private String prioridad;
    private String fechaLimite;
    private boolean completada = false;

    @JsonCreator
    public Task() {
    }

    public Task(Long id, String titulo, String prioridad, String fechaLimite, boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
        this.completada = completada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
