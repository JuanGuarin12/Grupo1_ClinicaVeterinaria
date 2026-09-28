package com.itm.clinicaveterinaria.models.domain;

public class Dueño extends Persona {
    private String direccion;
    private Animal[] animales; 
    private int cantidadAnimales; 

    public Dueño(String identificacion, String nombre, String telefono, String direccion) {
        super(identificacion, nombre, telefono);
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
        this.animales = new Animal[5];
        this.cantidadAnimales = 0; 
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Animal[] getAnimales() {
        return animales;
    }
    
    public int getCantidadAnimales() {
        return cantidadAnimales;
    }

    public void agregarAnimal(Animal animal) {
        if (animal != null) {

            if (cantidadAnimales == animales.length) {
                Animal[] nuevoArreglo = new Animal[animales.length * 2];
                for (int i = 0; i < animales.length; i++) {
                    nuevoArreglo[i] = animales[i];
                }
                animales = nuevoArreglo;
            }
            
            animales[cantidadAnimales] = animal;
            cantidadAnimales++;
        }
    }

    @Override
    public String rolEnClinica() {
        return "Dueño (Animales a cargo: " + cantidadAnimales + ")";
    }
}