package com.itm.clinicaveterinaria.view;

import com.itm.clinicaveterinaria.models.domain.Animal;
import com.itm.clinicaveterinaria.models.domain.Consulta;
import com.itm.clinicaveterinaria.models.domain.Veterinario;
import com.itm.clinicaveterinaria.service.AnimalService;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuPilaView {

    private final AnimalService animalService;
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
                    case 0 -> System.out.println("Saliendo del menú de pilas...");
                    default -> System.out.println("Opción inválida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido");
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private void mostrarOpciones() {
        System.out.println("\n=== MENÚ DE PILA DE CONSULTAS ===");
        System.out.println("1. Registrar consulta");
        System.out.println("2. Deshacer última consulta");
        System.out.println("3. Ver última consulta");
        System.out.println("4. ¿Hay consultas por deshacer?");
        System.out.println("5. Cantidad de consultas");
        System.out.println("6. Listar consultas");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
    }

    private void registrar() {
        System.out.print("Motivo: ");
        String motivo = entrada.nextLine();
        System.out.print("Diagnóstico: ");
        String diagnostico = entrada.nextLine();
        System.out.print("Tratamiento: ");
        String tratamiento = entrada.nextLine();

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
        String listado = animalService.listarHistorialConsultas(animal);
        System.out.println(listado);
    }
}