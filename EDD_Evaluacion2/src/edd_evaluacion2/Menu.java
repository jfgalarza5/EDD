package edd_evaluacion2;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Menu {
    
    int opc,añoEdicion;
    Scanner in = new Scanner(System.in);
    Pila miPila = new Pila();
    String autor,titulo;
    ArrayList<Libro> listaConservados=new ArrayList();
    ArrayList<Libro> listaRegalados=new ArrayList();
    ArrayList<Libro> listaModificar=new ArrayList();
    Nodo valor;
    
    public void menu(){
        
        do{
            System.out.println("===MENU PRINCIPAL===");
            System.out.println("1. Administrar Pila");
            System.out.println("2. Modificar libros");
            System.out.println("3. Regalar libros con año de edicion inferior a 2020");
            System.out.println("4. Libros en la bolsa de regalos");
            System.out.println("5. Mostrar los libros conservados");
            System.out.println("6. Guardar Pila en un txt");
            System.out.println("7. Cargar Pila de un txt");
            System.out.println("8. Salir");
            opc=in.nextInt();

            switch(opc){
                case 1:
                    menuPila();
                    break;
                case 2:
                    modificar();
                    break;
                case 3:
                    regalar();
                    break;
                case 4:
                    regalados();
                    break;
                case 5:
                    mostrarConservados();
                    break;  
                case 6:
                    guardar();
                case 7:
                    
            }  
        }while(opc!=8);
                
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
    
    public void modificar(){
        valor=miPila.tope;
        for(int i=0;i<miPila.tamaño;i++){
            listaModificar.add(miPila.tope.valor);
        }
        miPila.tope=miPila.tope.siguiente;
        int bandera=0;
        System.out.println("Escriba el titulo del libro: ");
        titulo=in.nextLine();
        for(Libro e: listaModificar){
            if(e.Titulo.equals(titulo)){
                System.out.println("===MODIFICAR===");
                System.out.print("Titulo: ");
                titulo=in.nextLine();
                System.out.print("Autor: ");
                autor=in.nextLine();
                System.out.print("Año de edicion: ");
                añoEdicion=in.nextInt();
                in.nextLine();
                listaModificar.set(bandera, new Libro(titulo,autor,añoEdicion));
            }
            bandera++;
        }
        miPila.clear();
        for(Libro e:listaModificar){
            miPila.push(e);
        }
    }
    
    public void regalar(){
        valor=miPila.tope;
        
        for(int i=0;i<miPila.tamaño;i++){
            if(miPila.tope.valor.AñoEdicion>=2020){
                listaConservados.add(miPila.tope.valor);
            }else{
                listaRegalados.add(miPila.tope.valor);
            }
            miPila.tope=miPila.tope.siguiente;
        }
        regalados();
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
    
    public void regalados(){
        System.out.println("El numero de libros en la bolsa de regalos es: "+listaRegalados.size());
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
    
    public void guardar(){
        String fileName = "Pila.txt";
        listaModificar.clear();
        valor=miPila.tope;
        for(int i=0;i<miPila.tamaño;i++){
            listaModificar.add(miPila.tope.valor);
        }
        miPila.tope=miPila.tope.siguiente;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Escribir cada elemento del ArrayList en una línea del archivo
            for (Libro element : listaModificar) {
                writer.write(element.Titulo);
                writer.newLine();
                writer.write(element.Autor);
                writer.newLine();
                writer.write(element.AñoEdicion);
                writer.newLine();
            }

            System.out.println("Pila guardado en el archivo " + fileName + " correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void cargar(){
        listaModificar.clear();
        String fileName = "Pila.txt";
         try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Leer cada línea del archivo y agregarla al ArrayList
            while ((line = reader.readLine()) != null) {
                titulo=line;
            }

            // Imprimir el ArrayList cargado
            System.out.println("ArrayList cargado desde el archivo " + fileName + ": ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
