package com.itm.clinicaveterinaria.service;

import com.itm.clinicaveterinaria.models.domain.Animal;
import com.itm.clinicaveterinaria.models.domain.Consulta;
import com.itm.clinicaveterinaria.models.domain.Vacuna;
import com.itm.clinicaveterinaria.models.structures.ListaSimple;
import com.itm.clinicaveterinaria.models.structures.Pila;

public class AnimalService {

    public void registrarConsulta(Animal animal, Consulta consulta) {
        if (animal == null || consulta == null) {
            throw new IllegalArgumentException("Animal o consulta no pueden ser nulos");
        }
        animal.getConsultas().insertarFinal(consulta);
        animal.getHistorialConsultas().push(consulta);
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
        
        int indiceReal = animal.getConsultas().getTamano() - 1;

        while (!original.isEmpty()) {
            Consulta c = original.pop();
            sb.append("[").append(indiceReal).append("] Fecha: ").append(c.getFecha())
              .append(" | Motivo: ").append(c.getMotivo())
              .append(" | Diagnóstico: ").append(c.getDiagnostico()).append("\n");
            auxiliar.push(c);
            indiceReal--; 
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

    // eliminarUltimaConsultaHistorial -> Eliminan de la pila: pop 


    // eliminar de la lista: eliminar por indice
    public boolean eliminarConsulta(Animal animal, Consulta consulta) {
        if (animal != null && consulta != null) {
            // Tu sincronización perfecta entre Lista y Pila
            boolean eliminado = animal.getConsultas().eliminarPorValor(consulta);
            
            if (eliminado) {
                Pila<Consulta> original = animal.getHistorialConsultas();
                Pila<Consulta> auxiliar = new Pila<>();
                
                while (!original.isEmpty()) {
                    Consulta c = original.pop();
                    if (c != consulta) {
                        auxiliar.push(c);
                    }
                }
                
                while (!auxiliar.isEmpty()) {
                    original.push(auxiliar.pop());
                }
                return true;
            }
        }
        return false;
    }

    public void registrarVacuna(Animal animal, Vacuna vacuna) {
        if (animal == null || vacuna == null) {
            throw new IllegalArgumentException("Animal o vacuna no pueden ser nulos");
        }
        animal.getVacunas().insertarFinal(vacuna);
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

    public Consulta deshacerUltimaConsulta(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("El animal no puede ser nulo");
        }
        if (!animal.getHistorialConsultas().isEmpty()) {
            Consulta eliminada = animal.getHistorialConsultas().pop();
            animal.getConsultas().eliminarPorValor(eliminada); 
            return eliminada;
        }
        return null;
    }

    public Consulta consultarUltimaConsulta(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("El animal no puede ser nulo");
        }
        if (!animal.getHistorialConsultas().isEmpty()) {
            Consulta ultima = animal.getHistorialConsultas().pop();
            animal.getHistorialConsultas().push(ultima); 
            return ultima;
        }
        return null;
    }

    public boolean sinConsultasPorDeshacer(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("El animal no puede ser nulo");
        }
        return animal.getHistorialConsultas().isEmpty();
    }

    public int contarConsultas(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("El animal no puede ser nulo");
        }
        return animal.getConsultas().getTamano();
    }
}