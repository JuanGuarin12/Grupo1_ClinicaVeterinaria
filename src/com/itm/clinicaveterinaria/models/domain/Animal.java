package com.itm.clinicaveterinaria.models.domain;
import com.itm.clinicaveterinaria.models.structures.ListaSimple;
import com.itm.clinicaveterinaria.models.structures.Pila;

public class Animal {
    private String numeroFicha;
    private String nombre;
    private String especie;
    private String raza;
    private int edadAnios;
    private Pila<Consulta> historialConsultas;


    private ListaSimple<Consulta> consultas;
    private ListaSimple<Vacuna> vacunas;

    public Animal(int edadAnios, String especie, String nombre, String numeroFicha, String raza) {
        verificarNumeroFicha(numeroFicha);

        this.edadAnios = edadAnios;
        this.especie = especie;
        this.nombre = nombre;
        this.numeroFicha = numeroFicha;
        this.raza = raza;

        this.historialConsultas = new Pila<>();
        this.consultas = new ListaSimple<>();
        this.vacunas = new ListaSimple<>();
    }

    public String getNumeroFicha() { return numeroFicha; }

    public void setNumeroFicha(String numeroFicha) { 
        verificarNumeroFicha(numeroFicha);
        this.numeroFicha = numeroFicha; }

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

    public void verificarNumeroFicha(String numeroFicha) {
        if (numeroFicha == null || numeroFicha.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de ficha es inválido");
        }
    }

    public void mostrarInfo() {
        System.out.println("Ficha: " + this.numeroFicha + " | Nombre: " + this.nombre + 
        " | Especie: " + this.especie + " | Raza: " + this.raza + 
        " | Edad: " + this.edadAnios + " años");
    }
}

