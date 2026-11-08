package com.itm.clinicaveterinaria.view;

import com.itm.clinicaveterinaria.service.SeguimientoService;
import com.itm.clinicaveterinaria.models.domain.Evolucion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuSeguimientoView {
    private final SeguimientoService service;
    private final Scanner scanner;

    public MenuSeguimientoView() {
        this.service = new SeguimientoService();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n=== MENÚ DE SEGUIMIENTO HOSPITALIZADOS ===");
            System.out.println("1. Registrar nueva evolución");
            System.out.println("2. Listar evoluciones (Cronológico / Adelante)");
            System.out.println("3. Listar evoluciones (Inverso / Atrás)");
            System.out.println("4. Ver evolución anterior");
            System.out.println("5. Ver evolución siguiente");
            System.out.println("6. Retirar evolución actual");
            System.out.println("7. Guardar y Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                ejecutarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
            }
         } while (opcion != 7);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarNuevaEvolucion();
                break;
            case 2: 
                System.out.println("\n--- Evoluciones (Cronológico) ---");
                System.out.println(service.ListarEvolucionesCronologico());
                break;
            case 3:
                System.out.println("\n--- Evoluciones (Inverso) ---");
                System.out.println(service.listarEvolucionesInverso());
                break;
            case 4:
                try {
                    Evolucion anterior = service.verEvolucionAnterior();
                    System.out.println("\nEvolución anterior: \n" + anterior);
                } catch (Exception e) {
                    System.out.println("\nLímite alcanzado: " + e.getMessage());
                }
                break;
            case 5:
                try {
                    Evolucion siguiente = service.verEvolucionSiguiente();
                    System.out.println("\nEvolución siguiente: \n" + siguiente);
                } catch (Exception e) {
                    System.out.println("\nLímite alcanzado: " + e.getMessage());
                }
                break;
            case 6:
                try {
                    Evolucion retirada = service.retirarEvolucionActual();
                    System.out.println("\nSe ha retirado la evolución: \n" + retirada);
                } catch (Exception e) {
                    System.out.println("\nError al retirar: " + e.getMessage());
                }
                break;
            case 7:
                System.out.println("\nGuardando datos en el archivo de texto...");
                // Aquí es donde se dispara el BufferedWriter que programamos ayer
                System.out.println(service.guardarEvoluciones()); 
                System.out.println("Saliendo del módulo. ¡Hasta pronto!");
                break;
            default:
                System.out.println("\nOpción no válida. Intente de nuevo.");
        }
    }        
        
    private void registrarNuevaEvolucion() {
        System.out.println("\n--- Registrar Evolución ---");
        try {
            System.out.print("Número de ficha:  ");
            int ficha = Integer.parseInt(scanner.nextLine());

            System.out.print("Fecha (DD/MM/AAAA) o presione Enter para la de hoy: ");
            String fechaInput = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = fechaInput.trim().isEmpty() ? LocalDate.now() : LocalDate.parse(fechaInput, formatter);

            System.out.print("Temperatura (°C): ");
            double temp = Double.parseDouble(scanner.nextLine());

            System.out.print("Peso (Kg): ");
            double peso = Double.parseDouble(scanner.nextLine());

            System.out.print("Observación clínica: ");
            String obs = scanner.nextLine();

            service.registrarEvolucion(ficha, fecha, temp, peso, obs);
            System.out.println("¡Evolución registrada con éxito!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Formato numérico inválido. Registro cancelado.");
        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha inválido. Use YYYY-MM-DD. Registro cancelado.");
        } 
    }      
}

