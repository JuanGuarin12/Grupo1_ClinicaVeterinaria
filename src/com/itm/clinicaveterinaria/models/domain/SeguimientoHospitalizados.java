package com.itm.clinicaveterinaria.models.domain;

import com.itm.clinicaveterinaria.structures.ListaDoble;

public class SeguimientoHospitalizados {
    private String clinica;
    private ListaDoble<Evolucion> evoluciones;

    public SeguimientoHospitalizados(String clinica) {
        if (clinica == null || clinica.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la clínica no puede ser nulo o vacío");
        }
        this.clinica = clinica; 
        this.evoluciones = new ListaDoble<>();
    }

    public String getClinica() {
    return clinica;
    }

    public ListaDoble<Evolucion> getEvoluciones() {
        return evoluciones;
    }
}
