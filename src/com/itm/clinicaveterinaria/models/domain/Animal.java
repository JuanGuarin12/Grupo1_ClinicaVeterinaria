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


    public Pila<Consulta> getHistorialConsultas() {
        return historialConsultas;
    }

    public void setHistorialConsultas(Pila<Consulta> historialConsultas) {
        this.historialConsultas = historialConsultas;
    }

    public Animal(int edadAnios, String especie, String nombre, String numeroFicha, String raza) {
       
      
        
        this.numeroFicha = numeroFicha;
        this.edadAnios = edadAnios;
        this.especie = especie;
        this.nombre = nombre;
        this.raza = raza;
        this.historialConsultas = new Pila<>(); 
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
  

    public void verificarNumeroficha (String numeroFicha){
    if(numeroFicha==null){
        throw new IllegalArgumentException("el numero de ficha es invalido");
    }
}
    public void registrarConsulta(Consulta consulta) {
        historialConsultas.push(consulta);
    }

    
    public Consulta verUltimaConsulta() {
        return historialConsultas.peek();
    }

    
    public Consulta retirarUltimaConsulta() {
        return historialConsultas.pop();
    }

    public void MostrarInfo(){
    System.out.println("nombre:" + this.nombre);
    System.out.println("especie:" + this.especie);  
    System.out.println("raza:" + this.raza);
    System.out.println("edad:" + this.edadAnios + " años");
    

    }

    
}
