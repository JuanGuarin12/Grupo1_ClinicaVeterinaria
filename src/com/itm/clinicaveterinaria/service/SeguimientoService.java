package com.itm.clinicaveterinaria.service;

import com.itm.clinicaveterinaria.models.domain.Evolucion;
import com.itm.clinicaveterinaria.models.domain.SeguimientoHospitalizados;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.NoSuchElementException;

public class SeguimientoService {
    
    private final SeguimientoHospitalizados seguimiento = new SeguimientoHospitalizados("Clinica Veterinaria ITM");
    final String ARCHIVO_EVOLUCIONES = "data/evoluciones.txt";
    private static final String SEPARADOR = ";";

    public SeguimientoService() {
        cargarEvoluciones();
    }

    public void registrarEvolucion(int numeroFicha, LocalDate fecha, double temperaturaC, double pesoKg, String observacion) {
        Evolucion nueva = new Evolucion(numeroFicha, fecha, temperaturaC, pesoKg, observacion);
        seguimiento.getEvoluciones().insertarAlFinal(nueva);
    }

    public String ListarEvolucionesCronologico() {
        if (seguimiento.getEvoluciones().isEmpty()) {
            return "No hay evoluciones registradas.";
        }
        return seguimiento.getEvoluciones().recorrerAdelante();
    }

    public String listarEvolucionesInverso() {
        if (seguimiento.getEvoluciones().isEmpty()) {
            return "No hay evoluciones registradas.";
        }
        return seguimiento.getEvoluciones().recorrerAtras();
    }

    public Evolucion verEvolucionAnterior() {
        return seguimiento.getEvoluciones().anterior();
    }

    public Evolucion verEvolucionSiguiente() {
        return seguimiento.getEvoluciones().siguiente();
    }

    public Evolucion retirarEvolucionActual() {
        return seguimiento.getEvoluciones().retirarActual();
    }

    public int contarEvoluciones() {
        return seguimiento.getEvoluciones().size(); 
    }

private void escribirEvoluciones() throws IOException {
        File archivo = new File(ARCHIVO_EVOLUCIONES);
        File carpeta = archivo.getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs(); 
        }
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
            escritor.write(seguimiento.getEvoluciones().recorrerAdelante()); 
        }
    }

    public String guardarEvoluciones() {
        try {
            escribirEvoluciones();
            return "Se guardaron evoluciones en " + ARCHIVO_EVOLUCIONES;
        } catch (IOException e) {
            return "No se pudo guardar: " + e.getMessage();
        }
    }

    public void cargarEvoluciones() {
        File archivo = new File(ARCHIVO_EVOLUCIONES);
        while (!seguimiento.getEvoluciones().isEmpty()) {
            try {
                seguimiento.getEvoluciones().irAlInicio();
                seguimiento.getEvoluciones().retirarActual();
            } catch (NoSuchElementException ignored) {}
        }
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(SEPARADOR);
                if (partes.length == 5) {
                    try {
                        registrarEvolucion(Integer.parseInt(partes[0].trim()), 
                                           LocalDate.parse(partes[1].trim()), 
                                           Double.parseDouble(partes[2].trim()), 
                                           Double.parseDouble(partes[3].trim()), 
                                           partes[4].trim());
                    } catch (Exception e) { continue; }
                }
            }
        } catch (IOException ignored) {}
    }    
}
