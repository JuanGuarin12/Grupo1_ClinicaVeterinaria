package com.itm.clinicaveterinaria;

import com.itm.clinicaveterinaria.models.domain.Dueño;
import com.itm.clinicaveterinaria.models.domain.Animal;
import com.itm.clinicaveterinaria.service.AnimalService;
import com.itm.clinicaveterinaria.view.MenuListasView;
import com.itm.clinicaveterinaria.view.MenuPilaView;
import com.itm.clinicaveterinaria.view.MenuColaView; 

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("==============================================");
            System.out.println("   REGISTRO DE DUEÑO Y MASCOTA - VETERINARIA");
            System.out.println("==============================================");

            System.out.print("Ingrese la identificación del dueño: ");
            String idDueño = sc.nextLine();

            System.out.print("Ingrese el nombre del dueño: ");
            String nombreDueño = sc.nextLine();

            System.out.print("Ingrese el teléfono del dueño: ");
            String telefonoDueño = sc.nextLine();

            System.out.print("Ingrese la dirección del dueño: ");
            String direccionDueño = sc.nextLine();

            Dueño dueno = new Dueño(idDueño, nombreDueño, telefonoDueño, direccionDueño);

            System.out.println("\n--- DATOS DE LA MASCOTA ---");
            System.out.print("Ingrese el nombre del animal: ");
            String nombreAnimal = sc.nextLine();

            System.out.print("Ingrese el número de ficha: ");
            String numeroFicha = sc.nextLine();

            System.out.print("Ingrese la especie: ");
            String especie = sc.nextLine();

            System.out.print("Ingrese la raza: ");
            String raza = sc.nextLine();

            System.out.print("Ingrese la edad (en años): ");
            int edadAnios = Integer.parseInt(sc.nextLine());

            Animal miMascota = new Animal(edadAnios, especie, nombreAnimal, numeroFicha, raza);
            dueno.agregarAnimal(miMascota);

            System.out.println("\n Mascota registrada exitosamente para el dueño " + dueno.getNombre());
            miMascota.mostrarInfo();

            // ========== UNA SOLA instancia del Service (importante) ==========
            AnimalService service = new AnimalService();


            int opcion;
            do {
                System.out.println("\n========== MENÚ PRINCIPAL ==========");
                System.out.println("1. Menú de Listas (Consultas y Vacunas)");
                System.out.println("2. Menú de Pilas (Historial de Consultas)");
                System.out.println("3. Menú de Colas (Sala de Espera)");
                System.out.println("0. Salir");
                System.out.print("Elija una opción: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> {
                        MenuListasView menuListas = new MenuListasView();
                        menuListas.ejecutarMenu(miMascota);
                    }
                    case 2 -> {
                        MenuPilaView menuPila = new MenuPilaView(service, miMascota);
                        menuPila.iniciar();
                    }
                    case 3 -> {

                        MenuColaView menuCola = new MenuColaView(service);  
                        menuCola.iniciar();
                    }
                    case 0 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción inválida");
                }

            } while (opcion != 0);

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresó un número inválido.");
        }
    }
}
