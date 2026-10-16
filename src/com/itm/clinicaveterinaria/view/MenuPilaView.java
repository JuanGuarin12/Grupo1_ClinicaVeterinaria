package com.itm.clinicaveterinaria.view;

import com.itm.clinicaveterinaria.models.domain.Animal;
import com.itm.clinicaveterinaria.models.domain.Consulta;
import com.itm.clinicaveterinaria.models.domain.Veterinario;
import com.itm.clinicaveterinaria.service.AnimalService;
<<<<<<< HEAD

=======
>>>>>>> 10f7d3a5e7217f65841bc34e70125ab0e8cf39a9
import java.time.LocalDate;
import java.util.Scanner;

public class MenuPilaView {

    private final AnimalService animalService;
<<<<<<< HEAD
    private final Scanner entrada;

    public MenuPilaView() {
        this.animalService = new AnimalService();
        this.entrada = new Scanner(System.in);
    }

    public void iniciar(Animal animal) {
        int opcion;
        do {
            mostrarOpciones(animal);
    try {
                opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1 -> registrar(animal);
                    case 2 -> deshacer(animal);
                    case 3 -> consultarUltima(animal);
                    case 4 -> verSiHayConsultas(animal);
                    case 5 -> contar(animal);
                    case 6 -> listar(animal);
=======
    private final Animal animal;
    private final Scanner entrada;

    public MenuPilaView(AnimalService animalService, Animal animal) {
        this.animalService = animalService;
        this.animal = animal;
        this.entrada = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion = -1;
        do {
            mostrarOpciones();
            try {
                opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1 -> registrar();
                    case 2 -> deshacer();
                    case 3 -> consultarUltima();
                    case 4 -> verSiHayConsultas();
                    case 5 -> contar();
                    case 6 -> listar();
>>>>>>> 10f7d3a5e7217f65841bc34e70125ab0e8cf39a9
                    case 0 -> System.out.println("Saliendo del menú de pilas...");
                    default -> System.out.println("Opción inválida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido");
<<<<<<< HEAD
                opcion = -1;
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                opcion = -1;
=======
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
>>>>>>> 10f7d3a5e7217f65841bc34e70125ab0e8cf39a9
            }
        } while (opcion != 0);
    }

<<<<<<< HEAD
    private void mostrarOpciones(Animal animal) {
        System.out.println("\n=== MENÚ DE PILA DE CONSULTAS - " + animal.getNombre() + " ===");
        System.out.println("1. Registrar consulta");
        System.out.println("2. Deshacer última consulta (Pop)");
        System.out.println("3. Ver última consulta (Top)");
        System.out.println("4. ¿Hay consultas por deshacer?");
        System.out.println("5. Cantidad de consultas");
        System.out.println("6. Listar consultas (Historial completo)");
=======
    private void mostrarOpciones() {
        System.out.println("\n=== MENÚ DE PILA DE CONSULTAS ===");
        System.out.println("1. Registrar consulta");
        System.out.println("2. Deshacer última consulta");
        System.out.println("3. Ver última consulta");
        System.out.println("4. ¿Hay consultas por deshacer?");
        System.out.println("5. Cantidad de consultas");
        System.out.println("6. Listar consultas");
>>>>>>> 10f7d3a5e7217f65841bc34e70125ab0e8cf39a9
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
    }

<<<<<<< HEAD
    private void registrar(Animal animal) {
        System.out.print("Motivo de la consulta: ");
=======
    private void registrar() {
        System.out.print("Motivo: ");
>>>>>>> 10f7d3a5e7217f65841bc34e70125ab0e8cf39a9
        String motivo = entrada.nextLine();
        System.out.print("Diagnóstico: ");
        String diagnostico = entrada.nextLine();
        System.out.print("Tratamiento: ");
        String tratamiento = entrada.nextLine();

<<<<<<< HEAD
        Veterinario veterinarioDefault = new Veterinario("1001", "Dr. Ramirez", "12345", "General");
        Consulta consulta = new Consulta(motivo, diagnostico, tratamiento, LocalDate.now(), animal, veterinarioDefault);

        animalService.registrarConsulta(animal, consulta);
        System.out.println("Consulta registrada correctamente en la pila.");
    }

    private void deshacer(Animal animal) {
        Consulta deshecha = animalService.deshacerUltimaConsulta(animal);
        if (deshecha != null) {
            System.out.println("Consulta deshecha exitosamente: " + deshecha.getMotivo() + " - " + deshecha.getDiagnostico());
        } else {
            System.out.println("No hay consultas en la pila para deshacer.");
        }
    }

    private void consultarUltima(Animal animal) {
        Consulta ultima = animalService.consultarUltimaConsulta(animal);
        if (ultima != null) {
            System.out.println("Última consulta registrada: " + ultima.getMotivo() + " - " + ultima.getDiagnostico());
        } else {
            System.out.println("La pila de consultas está vacía.");
        }
    }

    private void verSiHayConsultas(Animal animal) {
        boolean vacia = animalService.sinConsultasPorDeshacer(animal);
        if (vacia) {
            System.out.println("La pila está vacía. No hay consultas por deshacer.");
        } else {
            System.out.println("Sí hay consultas en la pila listas para deshacer.");
        }
    }

    private void contar(Animal animal) {
        int cantidad = animalService.contarConsultas(animal);
        System.out.println("Cantidad de consultas en el historial: " + cantidad);
    }

    private void listar(Animal animal) {
=======
        Veterinario vet = new Veterinario("1001", "Dr. Ramirez", "12345", "General");
        Consulta consulta = new Consulta(motivo, diagnostico, tratamiento, LocalDate.now(), animal, vet);

        animalService.registrarConsulta(animal, consulta);
        System.out.println("Consulta registrada correctamente.");
    }

    private void deshacer() {
        Consulta deshecha = animalService.deshacerUltimaConsulta(animal);
        System.out.println("Consulta deshecha: " + deshecha);
    }

    private void consultarUltima() {
        Consulta ultima = animalService.consultarUltimaConsulta(animal);
        System.out.println("Última consulta: " + ultima);
    }

    private void verSiHayConsultas() {
        boolean vacia = animalService.sinConsultasPorDeshacer(animal);
        if (vacia) {
            System.out.println("No hay consultas por deshacer");
        } else {
            System.out.println("Hay consultas por deshacer");
        }
    }

    private void contar() {
        int cantidad = animalService.contarConsultas(animal);
        System.out.println("Cantidad de consultas: " + cantidad);
    }

    private void listar() {
>>>>>>> 10f7d3a5e7217f65841bc34e70125ab0e8cf39a9
        String listado = animalService.listarHistorialConsultas(animal);
        System.out.println(listado);
    }
}