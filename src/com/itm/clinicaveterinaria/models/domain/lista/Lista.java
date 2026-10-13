package com.itm.clinicaveterinaria.models.domain.lista;

import com.itm.clinicaveterinaria.models.domain.nodo.Nodo;
public class Lista<T> {

    private Nodo<T> head;
    private int tamano;

    public boolean estaVacia() {
        return head == null;
    }

    public void insertarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {
            head = nuevo;
        } else {
            nuevo.setSiguiente(head);
            head = nuevo;
        }

        tamano++;
    }
}
