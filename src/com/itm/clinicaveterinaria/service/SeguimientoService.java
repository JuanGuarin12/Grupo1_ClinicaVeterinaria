package com.itm.clinicaveterinaria.service;

import com.itm.clinicaveterinaria.models.domain.Evolucion;
import com.itm.clinicaveterinaria.models.domain.SeguimientoHospitalizados;
import com.itm.clinicaveterinaria.structures.ListaDoble;
import com.itm.clinicaveterinaria.structures.NodoDoble;
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
    private static final String ARCHIVO_EVOLUCIONES = "data/evoluciones.txt";
    private static final String SEPARADOR = ";";

    public SeguimientoService() {
        cargarEvoluciones();
    }

    public void registrarEvolucion(int numeroFicha, LocalDate fecha, double temperaturaC, double pesoKg, String observacion) {
        Evolucion nueva = new Evolucion(numeroFicha, fecha, temperaturaC, pesoKg, observacion);
        seguimiento.getEvoluciones().insertarAlFinal(nueva);
    }

    public String listarEvolucionesCronologico() {
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


    public String guardarEvoluciones() {
        try {
            File archivo = new File(ARCHIVO_EVOLUCIONES);
            File carpeta = archivo.getParentFile();
            if (carpeta != null && !carpeta.exists()) {
                carpeta.mkdirs();
            }

            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
                ListaDoble<Evolucion> lista = seguimiento.getEvoluciones();
                NodoDoble<Evolucion> actual = lista.getHead();

                while (actual != null) {
                    Evolucion e = actual.getDato();
                    escritor.write(
                        e.getNumeroFicha() + SEPARADOR +
                        e.getFecha().toString() + SEPARADOR +
                        e.getTemperaturaC() + SEPARADOR +
                        e.getPesoKg() + SEPARADOR +
                        e.getObservacion()
                    );
                    escritor.newLine();
                    actual = actual.getSiguiente();
                }
            }
            return "Se guardaron evoluciones en " + ARCHIVO_EVOLUCIONES;
        } catch (IOException e) {
            return "No se pudo guardar: " + e.getMessage();
        }
    }


    public void cargarEvoluciones() {

        while (!seguimiento.getEvoluciones().isEmpty()) {
            try {
                seguimiento.getEvoluciones().irAlInicio();
                seguimiento.getEvoluciones().retirarActual();
            } catch (NoSuchElementException ignored) {
            }
        }

        File archivo = new File(ARCHIVO_EVOLUCIONES);
        if (!archivo.exists()) {
            return; 
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] partes = linea.split(SEPARADOR, -1);

                
                if (partes.length < 5) continue;

                try {
                    int numeroFicha = Integer.parseInt(partes[0].trim());
                    LocalDate fecha = LocalDate.parse(partes[1].trim());
                    double temperaturaC = Double.parseDouble(partes[2].trim());
                    double pesoKg = Double.parseDouble(partes[3].trim());
                    String observacion = partes[4].trim();

                    registrarEvolucion(numeroFicha, fecha, temperaturaC, pesoKg, observacion);
                } catch (Exception e) {
                    
                }
            }
        } catch (IOException ignored) {
        }
    }
}