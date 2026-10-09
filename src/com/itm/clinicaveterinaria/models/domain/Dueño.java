package com.itm.clinicaveterinaria.models.domain;

import com.itm.clinicaveterinaria.models.structures.ListaSimple;

public class Dueño extends Persona {
    private String direccion;
    private ListaSimple<Animal> animales;

    public Dueño(String identificacion, String nombre, String telefono, String direccion) {
        super(identificacion, nombre, telefono);
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
        this.animales = new ListaSimple<>();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ListaSimple<Animal> getAnimales() {
        return animales;
    }

    public void agregarAnimal(Animal animal) {
        if (animal != null) {
            this.animales.insertarFinal(animal);
        }
    }

    @Override
    public String rolEnClinica() {
        return "Dueño (Animales a cargo: " + animales.getTamano() + ")";
    }
}