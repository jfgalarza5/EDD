package edd_listaelementdupli;

public class Nodo {
	//Varibles instanciadas
	public Object dato;
	public Nodo siguiente;
	
	//constructor
	public Nodo(Object d) {
		dato=d;
		siguiente=null;
	}
	//Metodo que muestra el nodo
	public void mostrandoNodo() {
		System.out.println("{"+dato+"}");
	}
}
