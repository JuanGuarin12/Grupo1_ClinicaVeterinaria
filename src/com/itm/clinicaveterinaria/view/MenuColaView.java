package com.itm.clinicaveterinaria.view;   

import com.itm.clinicaveterinaria.models.domain.Animal;
import com.itm.clinicaveterinaria.service.AnimalService;

public class MenuColaView {

    private final AnimalService animalService;

    public MenuColaView(AnimalService animalService) {
        this.animalService = animalService;
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = ConsoleUtils.leerEntero("Elija una opción: ");
            switch (opcion) {
                case 1 -> registrarLlegada();
                case 2 -> atender();
                case 3 -> consultarSiguiente();
                case 4 -> verSiHayEnEspera();
                case 5 -> contar();
                case 6 -> listar();
                case 0 -> System.out.println("Saliendo del menú de sala de espera...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void mostrarOpciones() {
        System.out.println("\n===== SALA DE ESPERA =====");
        System.out.println("1. Registrar llegada (enqueue)");
        System.out.println("2. Atender al siguiente (dequeue)");
        System.out.println("3. Ver quién sigue (front)");
        System.out.println("4. ¿Hay animales en espera? (isEmpty)");
        System.out.println("5. Cantidad en espera (size)");
        System.out.println("6. Listar la fila");
        System.out.println("0. Salir");
    }

    private void registrarLlegada() {
        String identificacion = ConsoleUtils.leerTexto("Identificación del animal: ");
        animalService.registrarLlegada(identificacion);
        System.out.println("Llegada registrada exitosamente.");
    }

    private void atender() {
        if (animalService.sinAnimalesEnEspera()) {
            System.out.println("No hay animales en espera.");
            return;
        }
        Animal atendido = animalService.atenderSiguiente();
        System.out.println("Se atendió a: " + atendido.getNombre());
    }

    private void consultarSiguiente() {
        if (animalService.sinAnimalesEnEspera()) {
            System.out.println("No hay animales en espera.");
            return;
        }
        Animal siguiente = animalService.consultarSiguiente();
        System.out.println("Sigue: " + siguiente.getNombre());
    }

    private void verSiHayEnEspera() {
        if (animalService.sinAnimalesEnEspera()) {
            System.out.println("No hay animales en espera.");
        } else {
            System.out.println("Hay animales en espera.");
        }
    }

    private void contar() {
        System.out.println("Animales en espera: " + animalService.contarEnEspera());
    }

    private void listar() {
        System.out.println(animalService.listarEnEspera());
    }
}

