package edd_practica.pkg5;

import java.util.Scanner;

public class EDD_Practica5 {

    public static void main(String[] args) {
        Pila miPila = new Pila();
        Scanner in = new Scanner(System.in);
        int opc;
        do{
            System.out.println("==MENU==");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Vacia?");
            System.out.println("4. Show");
            System.out.println("5. Clear");
            System.out.println("6. Cima");
            System.out.println("7. Exit");
            opc=in.nextInt();
            switch(opc){
                case 1:
                    System.out.print("Ingrese el valor: ");
                    miPila.push(in.nextInt());
                    break;
                case 2:
                    System.out.println("Valor quitado: "+miPila.pop());
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
                    if(!miPila.vacia()) System.out.println("La cima: "+miPila.cima());
                    else System.out.println("Esta vacia");
                    break;
            }    
        }while(opc!=7);
        
    }
}
