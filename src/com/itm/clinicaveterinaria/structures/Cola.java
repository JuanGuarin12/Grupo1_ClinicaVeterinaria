package com.itm.clinicaveterinaria.structures;

import java.util.NoSuchElementException; 

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamano;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    public void enqueue(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento a encolar no puede ser nulo");
        }
        
        Nodo<T> nuevo = new Nodo<>(elemento);
        
        if (isEmpty()) {
            frente = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        tamano++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("No se puede extraer: la cola está vacía");
        }
        
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        
        if (frente == null) {
            fin = null;
        }
        
        tamano--;
        return dato;
    }

    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("No hay elementos: la cola está vacía");
        }
        return frente.getDato();
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public int size() {
        return tamano;
    }
}