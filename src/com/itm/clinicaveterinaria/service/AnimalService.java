package com.itm.clinicaveterinaria.service;

import com.itm.clinicaveterinaria.models.domain.Animal;
import com.itm.clinicaveterinaria.models.domain.Consulta;
import com.itm.clinicaveterinaria.models.domain.SalaDeEspera;
import com.itm.clinicaveterinaria.models.domain.Vacuna;
import com.itm.clinicaveterinaria.structures.Cola;
import com.itm.clinicaveterinaria.structures.ListaSimple;
import com.itm.clinicaveterinaria.structures.Pila;

public class AnimalService {

    private final SalaDeEspera salaDeEspera = new SalaDeEspera("Sala de espera 1");
    private final ListaSimple<Animal> animales = new ListaSimple<>();

    public void registrarConsulta(Animal animal, Consulta consulta) {
        if (animal == null || consulta == null) {
            throw new IllegalArgumentException("Animal o consulta no pueden ser nulos");
        }
        animal.getConsultas().insertarFinal(consulta);
        animal.getHistorialConsultas().push(consulta);
    }

    public String listarConsultasDeLista(Animal animal) {
        if (animal == null) {
            return "Animal no válido.";
        }    

        ListaSimple<Consulta> consultas = animal.getConsultas(); 
        if (consultas.getTamano() == 0) {
            return "No hay consultas en la lista";
        }    

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < consultas.getTamano(); i++) {
            Consulta c = buscarConsultaPorIndice(animal, i);
            if (c != null) {
                sb.append("[").append(i).append("] Fecha: ").append(c.getFecha())
                .append(" | Motivo: ").append(c.getMotivo())
                .append(" | Diagnóstico: ").append(c.getDiagnostico()).append("\n");
            }
        }
        return sb.toString();
    }

    public String listarHistorialConsultas(Animal animal) {
        if (animal == null) {
            return "Animal no válido.";
        }

        Pila<Consulta> original = animal.getHistorialConsultas();

        if (original.isEmpty()) {
            return "No hay consultas registradas en el historial (Pila).";
        }

        Pila<Consulta> auxiliar = new Pila<>();
        StringBuilder sb = new StringBuilder();
        int orden = 1;

        while (!original.isEmpty()) {
            Consulta c = original.pop();
            sb.append("Historial ").append(orden).append(" -> Fecha: ").append(c.getFecha())
              .append(" | Motivo: ").append(c.getMotivo())
              .append(" | Diagnóstico: ").append(c.getDiagnostico()).append("\n");
            auxiliar.push(c);
            orden++; 
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

    public Consulta eliminarUltimaConsultaHistorial(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("El animal no puede ser nulo");
        }
        if (!animal.getHistorialConsultas().isEmpty()) {
            return animal.getHistorialConsultas().pop();
        }
        return null;
    }

    public boolean eliminarConsulta(Animal animal, int indice) {
        if (animal == null) return false; 
        
        Consulta consultaEncontrada = buscarConsultaPorIndice(animal, indice);
            
        if (consultaEncontrada != null) {
            return animal.getConsultas().eliminarPorValor(consultaEncontrada);
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

    public Animal buscarPorIdentificacion(String identificacion) {
    if (identificacion == null || identificacion.isBlank()) {
        return null;
    }

    for (int i = 0; i < animales.getTamano(); i++) {
        Animal animal = animales.buscarPorIndice(i);
        if (animal != null && identificacion.equals(animal.getIdentificacion())) {
            return animal;
        }
    }
    return null;
    }

    private Animal buscarAnimalOFallar(String identificacion) {
    Animal animal = buscarPorIdentificacion(identificacion);
    if (animal == null) {
        throw new IllegalArgumentException("El animal con identificación " + identificacion + " no existe");
    }
    return animal;
    }

    public void registrarLlegada(String identificacion) {
    Animal animal = buscarAnimalOFallar(identificacion);
    salaDeEspera.getFila().enqueue(animal);
    }

    public Animal atenderSiguiente() {
    return salaDeEspera.getFila().dequeue();
    }

    public Animal consultarSiguiente() {
    return salaDeEspera.getFila().front();
    }

    public boolean sinAnimalesEnEspera() {
    return salaDeEspera.getFila().isEmpty();
    }

    public int contarEnEspera() {
    return salaDeEspera.getFila().size();
    }

    public String listarEnEspera() {
    Cola<Animal> fila = salaDeEspera.getFila();

    if (fila.isEmpty()) {
        return "No hay animales en espera";
    }

    StringBuilder texto = new StringBuilder();
    int total = fila.size();

    for (int i = 1; i <= total; i++) {
        Animal animal = fila.dequeue();
        texto.append(i).append(". ").append(animal.getNombre()).append("\n");
        fila.enqueue(animal);                   
    }

    return texto.toString();
    }

    public void agregarAnimal(Animal animal) {
    if (animal == null) {
        throw new IllegalArgumentException("El animal no puede ser nulo");
    }
    animales.insertarFinal(animal);
}
}



