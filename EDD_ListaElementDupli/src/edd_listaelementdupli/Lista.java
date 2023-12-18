package edd_listaelementdupli;

public class Lista {
	//Se instancia el atributo
	private Nodo primero;
	
	//constructor
	public  Lista() {
		primero=null;
	}
	
	//metodo booleano para saber si esta vacia la lista
	public boolean vacia() {
		return(primero==null);
	}
	
	//metodo que inserta un dato en la parte superior de la lista
	public void insertarCabezaLista(Object d) {
		Nodo nuevoNodo = new Nodo(d);
		nuevoNodo.siguiente=primero;
		
		primero=nuevoNodo;
	}
	
	//metodo que elimina toda la lista
	public Nodo eliminarCabezaLista() {
		Nodo temp = primero;
		primero=primero.siguiente;
		return temp;
	}
	
	//metodo que muestra toda la lista
	public void mostrarLista() {
		System.out.println("Lista (primero->ultimo):");
		Nodo nodoActual=primero;
		
		while(nodoActual!=null) {
			nodoActual.mostrandoNodo();
			nodoActual=nodoActual.siguiente;
		}
		
		System.out.println("");
	}
	
	//metodo que busca la ubicacion del dato
	public Nodo buscarLista(Object dato) {
		Nodo nodoActual=primero;
		while(!nodoActual.dato.equals(dato)) {
			if(nodoActual.siguiente==null) {
				return null;
			}else {
				nodoActual=nodoActual.siguiente;
			}
		}
		return nodoActual;
	}
	
	//metodo que elimina un dato
	public Nodo eliminar(Object dato) {
		Nodo nodoActual=primero;
		Nodo nodoAnterior=primero;
		
		while(!nodoActual.dato.equals(dato)) {
			if(nodoActual.siguiente==null) {
				return null;
			}else {
				nodoAnterior=nodoActual;
				nodoActual=nodoActual.siguiente;
			}
		}
		
		if(nodoActual==primero) {
			primero=primero.siguiente;
		}else {
			nodoAnterior.siguiente=nodoActual.siguiente;
		}
		
		return nodoActual;
	}
	
	//metodo que inserta un dato en el espacio delante de donde existia otro
	public Nodo insertar(Object valorExistente, Object valorNuevo) {
		Nodo nuevoNodo = new Nodo(valorNuevo);
		Nodo nodoActual=primero;
		
		while(!nodoActual.dato.equals(valorExistente)) {
			if(nodoActual.siguiente==null) {
				return null;
			}else {
				nodoActual=nodoActual.siguiente;
			}
		}
		nuevoNodo.siguiente=nodoActual.siguiente;
		nodoActual.siguiente=nuevoNodo;
		return nuevoNodo;
	}
        
        //Metodo que elimina todos los duplicados en la lista
        public void eliminarDuplos(){
            Nodo nodoActual=primero;
            
            while(nodoActual!=null){
                Object d=nodoActual.dato;
                Nodo nodo2=nodoActual.siguiente;
                boolean bandera=false;
                while(nodo2!=null){
                    Object a=nodo2.dato;
                    if(d.equals(a)){
                        if(!bandera){
                            eliminar(a);
                            bandera=true;
                        }
                    }
                    nodo2=nodo2.siguiente;
                }
                nodoActual=nodoActual.siguiente;
            }
        }
}

