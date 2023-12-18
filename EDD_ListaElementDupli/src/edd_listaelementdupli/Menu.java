package edd_listaelementdupli;

import java.util.*;

public class Menu {
	//Se instanci los atributos lista, scanner y object
	Lista lista = new Lista();
	Scanner in = new Scanner(System.in);
	Object d,a;
	int opc;
	
	//metodo menu para la mnipulacion de los datos
	public void menu() {
            do {
                System.out.println("===MENU===");
                System.out.println("1. Ingresar dato a la lista");
                System.out.println("2. Insertar dato en la lista");
                System.out.println("3. Eliminar toda la lista");
                System.out.println("4. Eliminar un dato de la lista");
                System.out.println("5. Mostrar lista");
                System.out.println("6. Eliminar duplicados de la lista");
                System.out.println("7. Salir");
                opc=in.nextInt();
                in.nextLine();
                switch(opc) {
                //Ingresa un nuevo dato a la lista
                    case 1:
                        System.out.println("Cuantos datos ingresaras?");
                        double num=in.nextDouble();
                        in.nextLine();
                        for(int i=0;i<num;i++){
                            System.out.println("Ingresa el dato "+(i+1));
                            d=in.nextLine();
                            lista.insertarCabezaLista(d);
                        }
                        
                        break;
                // Inserta un dato en un espacio delante de un dato especificado
                    case 2:
                        System.out.println("Viejo dato: ");
                        d=in.nextLine();
                        System.out.println("Nuevo dato: ");
                        a=in.nextLine();
                        Nodo nodo=lista.insertar(d, a);
                        break;
                //Elimina todo los datos de la lista
                    case 3:
                        while(!lista.vacia()) {
                            nodo=lista.eliminarCabezaLista();
                            System.out.println("Nodo Eliminado");
                            nodo.mostrandoNodo();
                            System.out.println("");
                        }
                        break;
                //Elimina un dato especifico de la lista
                    case 4:
                        d=in.nextLine();
                        lista.eliminar(d);
                        break;
                //Muestra toda la lista
                    case 5:
                        lista.mostrarLista();
                        break;
                    case 6:
                        lista.eliminarDuplos();
                        break;

                }
            }while(opc!=7);
	}
}

