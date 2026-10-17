package com.itm.clinicaveterinaria.models.domain;

import com.itm.clinicaveterinaria.structures.Cola;

public class SalaDeEspera {
    private String nombre;
    private Cola<Animal> fila;

    public SalaDeEspera(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la sala no puede ser nulo ni estar vacío");
        }
        this.nombre = nombre;
        this.fila = new Cola<>(); // Se inicializa la cola vacía obligatoriamente
    }

    public String getNombre() {
        return nombre;
    }

    public Cola<Animal> getFila() {
        return fila;
    }
}
