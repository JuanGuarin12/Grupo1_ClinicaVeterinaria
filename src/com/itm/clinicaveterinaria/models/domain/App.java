package com.itm.clinicaveterinaria.models.domain;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        Dueño duenoMiguel = new Dueño("12345", "Miguel", "3001234567", "Calle 100 # 45-20");
        Dueño duenoDaniel = new Dueño("23456", "Daniel", "3007654321", "Carrera 50 # 30-10");

        Veterinario vetNatalia = new Veterinario("34567", "Natalia", "3009876543", "Cirugía");
        Veterinario vetJuan = new Veterinario("45678", "Juan", "3005551234", "Medicina Interna");

        Animal luna = new Animal(2, "Perro", "Luna", "F001", "Pug");
        Animal kalala = new Animal(4, "Gato", "Kalala", "F002", "Vaquita");

        duenoMiguel.agregarAnimal(luna);
        duenoDaniel.agregarAnimal(kalala);

        Vacuna vacunaLuna = new Vacuna("Rabia", LocalDate.of(2025, 3, 10), LocalDate.of(2026, 3, 10));
        Vacuna vacunaKalala = new Vacuna("Triple Felina", LocalDate.of(2025, 6, 15), LocalDate.of(2026, 6, 15));

        Consulta consultaLuna = new Consulta(
                "Revisión general",
                "Sano",
                "Ninguno, control en 6 meses",
                LocalDate.of(2025, 9, 1));

        Consulta consultaKalala = new Consulta(
                "Vómito",
                "Gastritis leve",
                "Dieta blanda y observación",
                LocalDate.of(2025, 8, 20));

        System.out.println("=== Animales ===");
        luna.MostrarInfo();
        System.out.println();
        kalala.MostrarInfo();

        System.out.println("\n=== Dueños ===");
        System.out.println(duenoMiguel.datosResumen() + " | " + duenoMiguel.rolEnClinica());
        System.out.println(duenoDaniel.datosResumen() + " | " + duenoDaniel.rolEnClinica());

        System.out.println("\n=== Veterinarios ===");
        System.out.println(vetNatalia.datosResumen() + " | " + vetNatalia.rolEnClinica());
        System.out.println(vetJuan.datosResumen() + " | " + vetJuan.rolEnClinica());

        System.out.println("\n=== Vacunas ===");
        System.out.println("Luna - " + vacunaLuna.getNombre() +
                " | Aplicada: " + vacunaLuna.getFechaAplicacion() +
                " | Próxima: " + vacunaLuna.getProximaFecha());
        System.out.println("Kalala - " + vacunaKalala.getNombre() +
                " | Aplicada: " + vacunaKalala.getFechaAplicacion() +
                " | Próxima: " + vacunaKalala.getProximaFecha());
        
        System.out.println("\n=== Consultas ===");
        System.out.println("Luna - Motivo: " + consultaLuna.getMotivo() +
                " | Diagnóstico: " + consultaLuna.getDiagnostico() +
                " | Tratamiento: " + consultaLuna.getTratamiento() +
                " | Fecha: " + consultaLuna.getFecha());
        System.out.println("Kalala - Motivo: " + consultaKalala.getMotivo() +
                " | Diagnóstico: " + consultaKalala.getDiagnostico() +
                " | Tratamiento: " + consultaKalala.getTratamiento() +
                " | Fecha: " + consultaKalala.getFecha());

        System.out.println("\n=== Roles en la clínica ===");
        Persona[] personas = { duenoMiguel, duenoDaniel, vetNatalia, vetJuan };
        for (Persona p : personas) {
                System.out.println(p.getNombre() + " - " + p.rolEnClinica());
}
    }
}