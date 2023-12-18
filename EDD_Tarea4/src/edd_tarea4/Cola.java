package edd_tarea4;

public class Cola <T> {
    public Nodo<T> frente, fin;
    
    public Cola() {
        this.frente=this.fin=null;
    }
    
    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Método para insertar un elemento en la cola
    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo(dato);

        if (estaVacia()) {
            frente = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    // Método para retirar un elemento de la cola
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null; // Valor indicativo de una cola vacía (puedes ajustar según tu necesidad)
        }

        T dato = frente.valor;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null; // La cola está vacía después de retirar el último elemento
        }

        return dato;
    }

    // Método para obtener el elemento en el frente de la cola sin retirarlo
    public T obtenerFrente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null; // Valor indicativo de una cola vacía (puedes ajustar según tu necesidad)
        }

        return frente.valor;
    }
    
    public void vaciarCola() {
        frente = fin = null;
    }
}