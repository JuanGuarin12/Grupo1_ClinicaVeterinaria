package com.itm.clinicaveterinaria.models.domain;

import com.itm.clinicaveterinaria.view.MenuListasView;

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

            MenuListasView menu = new MenuListasView();
            menu.ejecutarMenu(miMascota);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}