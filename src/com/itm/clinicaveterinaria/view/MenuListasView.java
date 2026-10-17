package com.itm.clinicaveterinaria.view;

import com.itm.clinicaveterinaria.models.domain.Animal;
import com.itm.clinicaveterinaria.models.domain.Consulta;
import com.itm.clinicaveterinaria.models.domain.Vacuna;
import com.itm.clinicaveterinaria.models.domain.Veterinario;
import com.itm.clinicaveterinaria.service.AnimalService;
import com.itm.clinicaveterinaria.structures.ListaSimple;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuListasView {

    private final AnimalService service;
    private final Scanner scanner;

    public MenuListasView() {
        this.service = new AnimalService();
        this.scanner = new Scanner(System.in);
    }

    public void ejecutarMenu(Animal animal) {
        int opcion = -1;
        do {
            System.out.println("\n==============================================");
            System.out.println("  GESTOR DE CONSULTAS Y VACUNAS - " + animal.getNombre());
            System.out.println("==============================================");
            System.out.println("1. Agregar Consulta");
            System.out.println("2. Listar Consultas");
            System.out.println("3. Eliminar Consulta por Índice");
            System.out.println("4. Deshacer Última Consulta");
            System.out.println("5. Ver Historial Completo");
            System.out.println("6. Agregar Vacuna");
            System.out.println("7. Listar Vacunas");
            System.out.println("8. Eliminar Vacuna por Índice");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> agregarConsulta(animal);
                    case 2 -> listarConsultas(animal);
                    case 3 -> eliminarConsulta(animal);
                    case 4 -> deshacerConsulta(animal);
                    case 5 -> listarHistorial(animal);
                    case 6 -> agregarVacuna(animal);
                    case 7 -> listarVacunas(animal);
                    case 8 -> eliminarVacuna(animal);
                    case 0 -> System.out.println("Saliendo del menú...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error de entrada: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private void agregarConsulta(Animal animal) {
        System.out.print("Motivo: ");
        String motivo = scanner.nextLine();
        System.out.print("Diagnóstico: ");
        String diagnostico = scanner.nextLine();
        System.out.print("Tratamiento: ");
        String tratamiento = scanner.nextLine();

        Veterinario veterinarioDefault = new Veterinario("1001", "Dr. Ramirez", "12345", "General");

        Consulta consulta = new Consulta(motivo, diagnostico, tratamiento, LocalDate.now(), animal, veterinarioDefault);
        service.registrarConsulta(animal, consulta);
        System.out.println("Consulta registrada con éxito en la Lista y en la Pila.");
    }

    private void listarConsultas(Animal animal) {
        String lista = service.listarConsultasDeLista(animal);
        System.out.println("\n--- CONSULTAS ACTIVAS ---");
        System.out.println(lista);
    }

    private void eliminarConsulta(Animal animal) {
        listarConsultas(animal);
        if (service.obtenerConsultas(animal).estaVacia()) return;

        System.out.print("Índice de la consulta a eliminar: ");
        int idx = Integer.parseInt(scanner.nextLine());

        if (service.eliminarConsulta(animal, idx)) {
            System.out.println("Consulta eliminada con éxito de la lista.");
        } else {
            System.out.println("No se pudo eliminar la consulta. Verifique el índice.");
        }
    }

    private void deshacerConsulta(Animal animal) {
        Consulta deshecha = service.eliminarUltimaConsultaHistorial(animal);
        if (deshecha != null) {
            System.out.println("Se deshizo exitosamente de la Pila: " + deshecha.getMotivo() + " - " + deshecha.getDiagnostico());
        } else {
            System.out.println("No hay consultas en la pila para deshacer.");
        }
    }

    private void listarHistorial(Animal animal) {
        String historial = service.listarHistorialConsultas(animal);
        System.out.println("\n--- HISTORIAL DE CONSULTAS (PILA) ---");
        System.out.println(historial);
    }

    private void agregarVacuna(Animal animal) {
        System.out.print("Nombre de la Vacuna: ");
        String nombre = scanner.nextLine();

        Vacuna vacuna = new Vacuna(nombre, LocalDate.now(), LocalDate.now().plusYears(1), animal);
        service.registrarVacuna(animal, vacuna);
        System.out.println("Vacuna registrada con éxito.");
    }

    private void listarVacunas(Animal animal) {
        ListaSimple<Vacuna> vacunas = service.obtenerVacunas(animal);
        if (vacunas.estaVacia()) {
            System.out.println("No hay vacunas registradas.");
            return;
        }

        System.out.println("\n--- LISTA DE VACUNAS ---");
        for (int i = 0; i < vacunas.getTamano(); i++) {
            Vacuna v = service.buscarVacunaPorIndice(animal, i);
            System.out.println("[" + i + "] Vacuna: " + v.getNombre() + 
            " | Aplicada: " + v.getFechaAplicacion() + 
            " | Próxima: " + v.getProximaFecha());
        }
    }

    private void eliminarVacuna(Animal animal) {
        listarVacunas(animal);
        if (service.obtenerVacunas(animal).estaVacia()) return;

        System.out.print("Índice de la vacuna a eliminar: ");
        int idx = Integer.parseInt(scanner.nextLine());
        Vacuna vacuna = service.buscarVacunaPorIndice(animal, idx);

        if (vacuna != null && service.eliminarVacuna(animal, vacuna)) {
            System.out.println("Vacuna eliminada con éxito.");
        } else {
            System.out.println("No se pudo eliminar la vacuna.");
        }
    }
}