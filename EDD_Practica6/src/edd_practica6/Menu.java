package edd_practica6;

import java.util.*;

public class Menu {
    
    int opc,añoEdicion;
    Scanner in = new Scanner(System.in);
    Pila miPila = new Pila();
    String autor,titulo;
    ArrayList<Libro> listaConservados=new ArrayList();
    ArrayList<Libro> listaRegalados=new ArrayList();
    
    public void menu(){
        
        do{
            System.out.println("===MENU PRINCIPAL===");
            System.out.println("1. Administrar Pila");
            System.out.println("2. Regalar libros con año de edicion inferior a 2020");
            System.out.println("3. Mostrar los libros conservados");
            System.out.println("4. Salir");
            opc=in.nextInt();

            switch(opc){
                case 1:
                    menuPila();
                    break;
                case 2:
                    regalar();
                    break;
                case 3:
                    mostrarConservados();
                    break;                
                case 4:
                    break;   
            }  
        }while(opc!=4);
                
    }
    
    public void menuPila(){
        do{
            System.out.println("==MENU PILA==");
            System.out.println("1. Apilar Libro");
            System.out.println("2. Desapilar Libro ");
            System.out.println("3. Pila vacia?");
            System.out.println("4. Mostrar toda la Pila");
            System.out.println("5. Limpiar toda la Pila");
            System.out.println("6. Ultima libro");
            System.out.println("7. Salir");
            opc=in.nextInt();
            in.nextLine();
            switch(opc){
                case 1:
                    System.out.println("Ingrese los datos del Libro: ");
                    System.out.print("Titulo: ");
                    titulo=in.nextLine();
                    System.out.print("Autor: ");
                    autor=in.nextLine();
                    System.out.print("Año de Edicion: ");
                    añoEdicion=in.nextInt();
                    in.nextLine();
                    
                    miPila.push(new Libro(titulo,autor,añoEdicion));
                    break;
                case 2:
                    System.out.println("Libro quitado: "+miPila.pop().Titulo);
                    break;
                case 3:
                    if(miPila.vacia()) System.out.println("Esta vacia");
                    else System.out.println("No esta vacia");
                    break;
                case 4:
                    if(!miPila.vacia()) miPila.show();
                    else System.out.println("Esta vacia");
                    break;
                case 5:
                    miPila.clear();
                    break;
                case 6:
                    if(!miPila.vacia()) {
                        System.out.println("El ultimo libro ingresado es: ");
                        System.out.println("Titulo: "+miPila.cima().Titulo);
                        System.out.println("Autor: "+miPila.cima().Autor);
                        System.out.println("Año de Edicion: "+miPila.cima().AñoEdicion);
                    }
                    else System.out.println("Esta vacia");
                    break;
            }    
        }while(opc!=7);
    }
    
    public void regalar(){
        Nodo valor=miPila.tope;
        
        for(int i=0;i<miPila.tamaño;i++){
            if(miPila.tope.valor.AñoEdicion>=2020){
                listaConservados.add(miPila.tope.valor);
            }else{
                listaRegalados.add(miPila.tope.valor);
            }
            miPila.tope=miPila.tope.siguiente;
        }
        miPila.tope=valor;
        System.out.println("Eliminando libros de la pila Original");
        miPila.clear();
        
        for (int i = 0; i < listaConservados.size() - 1; i++){
            for (int j = 0; j < listaConservados.size() - 1 - i; j++) {
                if (listaConservados.get(j).Titulo.compareTo(listaConservados.get(j + 1).Titulo) > 0) {
                    Libro temp = listaConservados.get(j);
                    listaConservados.set(j, listaConservados.get(j + 1));
                    listaConservados.set(j + 1, temp);
                }
            }
        }
    }
    
    public void mostrarConservados(){
        if(!listaConservados.isEmpty()){
            System.out.println("Los libros conservados son: ");
            for(Libro libro:listaConservados){
                System.out.println("=============================");
                System.out.println("Titulo: "+libro.Titulo);
                System.out.println("Autor: "+libro.Autor);
                System.out.println("Año de edicion: "+libro.AñoEdicion);
            }
        }else{
            System.out.println("No se conservo ningun libro");
        }
        System.out.println(" ");
        if(!listaRegalados.isEmpty()){
           System.out.println("Los libros regalados son: ");
            for(Libro libro:listaRegalados){
                System.out.println("=============================");
                System.out.println("Titulo: "+libro.Titulo);
                System.out.println("Autor: "+libro.Autor);
                System.out.println("Año de edicion: "+libro.AñoEdicion);
            } 
        }else{
            System.out.println("No se regalo ningun libro");
        }   
    }
}
