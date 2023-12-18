package edd_practica6;

public class Nodo {
	//Varibles instanciadas
	public Libro valor;
	public Nodo siguiente;
	
	//constructor
	public Nodo(Libro d) {
		valor=d;
		siguiente=null;
	}
	//Metodo que muestra el nodo
	public void mostrandoNodo() {
		System.out.println("{"+valor+"}");
	}
}
