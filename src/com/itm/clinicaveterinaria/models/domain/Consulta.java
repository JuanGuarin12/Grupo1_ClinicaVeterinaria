package com.itm.clinicaveterinaria.models.domain;

import java.time.LocalDate;

public class Consulta { 
    
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private LocalDate fecha;

    private Animal animal;
    private Veterinario veterinario;

    public Consulta(String motivo, String diagnostico, String tratamiento, LocalDate fecha, Animal animal, Veterinario veterinario) {
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.fecha = fecha;
        this.animal = animal;
        this.veterinario = veterinario;
    }

    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}
