package com.itm.clinicaveterinaria.models.domain;

public class Animal {
    private String numeroFicha;
    private String nombre;
    private String especie;
    private String raza;
    private int edadAnios;

    public Animal(int edadAnios, String especie, String nombre, String numeroFicha, String raza) {
        this.edadAnios = edadAnios;
        this.especie = especie;
        this.nombre = nombre;
        this.numeroFicha = numeroFicha;
        this.raza = raza;

    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdadAnios() {
        return edadAnios;
    }

    public void setEdadAnios(int edadAnios) {
        this.edadAnios = edadAnios;
    }
    // agrega condicion de numero de ficha para que no sea nulo y que si es nulo
    // salga un error y no copile

    public void verificarNumeroficha(String numeroFicha) {
        if (numeroFicha == null) {
            throw new IllegalArgumentException("el numero de ficha es invalido");
        }
    }

    public void MostrarInfo() {
        System.out.println("nombre:" + this.nombre);
        System.out.println("especie:" + this.especie);
        System.out.println("raza:" + this.raza);
        System.out.println("edad:" + this.edadAnios + " años");

    }

}
