package com.itm.clinicaveterinaria.service;

import com.itm.clinicaveterinaria.models.domain.Animal;
import com.itm.clinicaveterinaria.models.domain.Consulta;
import com.itm.clinicaveterinaria.models.domain.Vacuna;
import com.itm.clinicaveterinaria.models.structures.ListaSimple;
import com.itm.clinicaveterinaria.models.structures.Pila;

public class AnimalService {

    public void registrarConsulta(Animal animal, Consulta consulta) {
        if (animal != null && consulta != null) {
            animal.getConsultas().insertarFinal(consulta);
            animal.getHistorialConsultas().push(consulta);
        }
    }

    public String listarHistorialConsultas(Animal animal) {
        if (animal == null) {
            return "Animal no válido.";
        }

        Pila<Consulta> original = animal.getHistorialConsultas();

        if (original.isEmpty()) {
            return "No hay consultas registradas en el historial de este animal.";
        }

       Pila<Consulta> auxiliar = new Pila<>();
       StringBuilder sb = new StringBuilder();
       int contador  = 1;

       while (!original.isEmpty()) {
        Consulta c = original.pop();
        sb.append(contador).append(". Fecha: ").append(c.getFecha())
            .append(" | Motivo: ").append(c.getMotivo())
            .append("| Diagnóstico: ").append(c.getDiagnostico()).append("\n");
        auxiliar.push(c);
        contador++;
       }

       while(!auxiliar.isEmpty()) {
        original.push(auxiliar.pop());
       }

       return sb.toString();
    }

    public ListaSimple<Consulta> obtenerConsultas(Animal animal) {
        return animal != null ? animal.getConsultas() : new ListaSimple<>();
    }

    public Consulta buscarConsultaPorIndice(Animal animal, int indice) {
        if (animal == null) return null;
        try {
            return animal.getConsultas().buscarPorIndice(indice);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean eliminarConsulta(Animal animal, Consulta consulta) {
        if (animal != null && consulta != null) {
            return animal.getConsultas().eliminarPorValor(consulta);
        }
        return false;
    }

    public void registrarVacuna(Animal animal, Vacuna vacuna) {
        if (animal != null && vacuna != null) {
            animal.getVacunas().insertarFinal(vacuna);
        }
    }

    public ListaSimple<Vacuna> obtenerVacunas(Animal animal) {
        return animal != null ? animal.getVacunas() : new ListaSimple<>();
    }

    public Vacuna buscarVacunaPorIndice(Animal animal, int indice) {
        if (animal == null) return null;
        try {
            return animal.getVacunas().buscarPorIndice(indice);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean eliminarVacuna(Animal animal, Vacuna vacuna) {
        if (animal != null && vacuna != null) {
            return animal.getVacunas().eliminarPorValor(vacuna);
        }
        return false;
    }
}