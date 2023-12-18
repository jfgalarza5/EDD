package edd_laboratorio2;

public class Nodo <T>{
	//Varibles instanciadas
	public T valor;
	public Nodo siguiente;
	
        
	//constructor
	public Nodo(T d) {
		valor=d;
		siguiente=null;
	
}
	//Metodo que muestra el nodo
	public void mostrandoNodo() {
		System.out.println("{"+valor+"}");
	}
}
