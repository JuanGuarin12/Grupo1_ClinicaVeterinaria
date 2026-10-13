package com.itm.clinicaveterinaria.models.domain;

import java.time.LocalDate;

public class Vacuna {
    private String nombre;
    private LocalDate fechaAplicacion;
    private LocalDate proximaFecha;

    private Animal animal;

    public Vacuna(String nombre, LocalDate fechaAplicacion, LocalDate proximaFecha, Animal animal) {
        this.nombre = nombre;
        this.fechaAplicacion = fechaAplicacion;
        this.proximaFecha = proximaFecha;
        this.animal = animal;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }
    public void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public LocalDate getProximaFecha() {
        return proximaFecha;
    }
    public void setProximaFecha(LocalDate proximaFecha) {
        this.proximaFecha = proximaFecha;
    }

    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

}
