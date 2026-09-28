package com.itm.clinicaveterinaria.models.domain;

import com.itm.clinicaveterinaria.view.MenuListasView;

public class App {
    public static void main(String[] args) {
        Dueño dueno = new Dueño("123456789", "Carlos Pérez", "3001234567", "Calle 10 # 20-30");
        
        Animal miMascota = new Animal(3, "Perro", "Max", "F001", "Labrador");

        dueno.agregarAnimal(miMascota);

        System.out.println("Dueño registrado: " + dueno.getNombre());
        System.out.println("Rol: " + dueno.rolEnClinica());
        miMascota.mostrarInfo();

        MenuListasView menu = new MenuListasView();
        menu.ejecutarMenu(miMascota);
    }
}