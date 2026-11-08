package com.itm.clinicaveterinaria.models.domain;

import java.time.LocalDate;

public class Evolucion {
    private int numeroFicha;
    private LocalDate fecha;
    private double temperaturaC; 
    private double pesoKg;
    private String observacion; 

    public Evolucion(int numeroFicha, LocalDate fecha, double temperaturaC, double pesoKg, String observacion) {
        this.numeroFicha = numeroFicha; 
        this.fecha = fecha; 
        this.temperaturaC = temperaturaC;
        this.pesoKg = pesoKg; 
        this.observacion = observacion; 
    }

    public int getNumeroFicha() {
        return numeroFicha; 
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getTemperaturaC() {
        return temperaturaC;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public String getObservacion() {
        return observacion;
    }

    @Override 
    public String toString() {
        return numeroFicha + ";" + fecha + "," + temperaturaC + ";" + pesoKg + ";" + observacion;
    }

}
