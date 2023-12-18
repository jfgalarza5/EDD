package edd_pila;

import Pila.PilaArreglo;
import java.util.Scanner;

public class Menu {
    
        Scanner in=new Scanner(System.in);
        PilaArreglo pila= new PilaArreglo(2);
        int opc;
    
    public void menu(){
        do{
            System.out.println("==PILA ARREGLO==");
            System.out.println("1. Apilar elemento");
            System.out.println("2. Desapilar elemento");
            System.out.println("3. Elemento en el tope de la pila");
            System.out.println("4. Salir");
            opc=in.nextInt();
            in.nextLine();
            switch(opc){
                case 1:
                    System.out.println("Escriba el elemento");
                    Object x=in.nextLine();//almacenar la entrada del usuario directamente 
                    pila.apilar(x);// llama el metodo
                    break;
                case 2:
                    System.out.println("El elemento "+pila.desapilar()+" ha sido desapilado");
                    break;
                case 3:
                    System.out.println("El elemento tope de la pila es: ");
                    System.out.println(pila.tope());
                    break;
            }
        }while(opc!=4);
    }
}