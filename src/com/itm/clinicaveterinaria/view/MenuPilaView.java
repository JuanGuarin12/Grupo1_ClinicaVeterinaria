package com.itm.clinicaveterinaria.view;

import com.itm.clinicaveterinaria.models.domain.Consulta;
import com.itm.clinicaveterinaria.service.AnimalService;

import java.util.Scanner;

    public class MenuPilaView {

    private final AnimalService animalService;
    private final Scanner entrada;

    public MenuPilaView(AnimalService animalService) {
        this.animalService = animalService;
        this.entrada = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
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
            } catch (IllegalStateException | IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());
                opcion = -1;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido");
                opcion = -1;
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
        System.out.print("ID del animal: ");
        String idAnimal = entrada.nextLine();
        System.out.print("Motivo de la consulta: ");
        String motivo = entrada.nextLine();
        System.out.print("Diagnóstico: ");
        String diagnostico = entrada.nextLine();
        animalService.registrarConsulta(idAnimal, motivo, diagnostico /* ... */);
        System.out.println("Consulta registrada correctamente.");
    }

    private void deshacer() {
        System.out.print("ID del animal: ");
        String idAnimal = entrada.nextLine();

        Consulta deshecha = animalService.deshacerUltimaConsulta(idAnimal);
        System.out.println("Consulta deshecha: " + deshecha);
    }

    private void consultarUltima() {
        System.out.print("ID del animal: ");
        String idAnimal = entrada.nextLine();

        Consulta ultima = animalService.consultarUltimaConsulta(idAnimal);
        System.out.println("Última consulta: " + ultima);
    }

    private void verSiHayConsultas() {
        System.out.print("ID del animal: ");
        String idAnimal = entrada.nextLine();
        boolean vacia = animalService.sinConsultasPorDeshacer(idAnimal);
        if (vacia) {
            System.out.println("No hay consultas por deshacer");
        } else {
            System.out.println("Hay consultas por deshacer");
        }
    }

    private void contar() {
        System.out.print("ID del animal: ");
        String idAnimal = entrada.nextLine();
        int cantidad = animalService.contarConsultas(idAnimal);
        System.out.println("Cantidad de consultas: " + cantidad);
    }

    private void listar() {
        System.out.print("ID del animal: ");
        String idAnimal = entrada.nextLine();

        String listado = animalService.listarConsultas(idAnimal);
        System.out.println(listado);
    }
}


