package com.itm.clinicaveterinaria.models.domain;
import com.itm.clinicaveterinaria.structures.ListaSimple;
import com.itm.clinicaveterinaria.structures.Pila;

public class Animal {
    private String identificacion;
    private String nombre;
    private String especie;
    private String raza;
    private int edadAnios;
    private Pila<Consulta> historialConsultas;

    private ListaSimple<Consulta> consultas;
    private ListaSimple<Vacuna> vacunas;

    public Animal(int edadAnios, String especie, String nombre, String identificacion, String raza) {
        verificarIdentificacion(identificacion);

        this.edadAnios = edadAnios;
        this.especie = especie;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.raza = raza;

        this.historialConsultas = new Pila<>();
        this.consultas = new ListaSimple<>();
        this.vacunas = new ListaSimple<>();
    }

    public String getIdentificacion() { 
        return identificacion; 
    }

    public void setIdentificacion(String identificacion) { 
        verificarIdentificacion(identificacion);
        this.identificacion = identificacion; 
    }

    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public int getEdadAnios() { return edadAnios; }
    public void setEdadAnios(int edadAnios) { this.edadAnios = edadAnios; }

    public ListaSimple<Consulta> getConsultas() { return consultas; }
    public ListaSimple<Vacuna> getVacunas() { return vacunas; }

    public Pila<Consulta> getHistorialConsultas() { return historialConsultas; }

    public void verificarIdentificacion(String identificacion) {
        if (identificacion == null || identificacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La identificación es inválida");
        }
    }

    public void mostrarInfo() {
        System.out.println("Identificación: " + this.identificacion + " | Nombre: " + this.nombre + 
        " | Especie: " + this.especie + " | Raza: " + this.raza + 
        " | Edad: " + this.edadAnios + " años");
    }
}