package edd_practica.pkg7;

import java.util.*;

public class EDD_Practica7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc=0;
        Colas cola = new Colas(5);
        Object e;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("==MENU==");
            System.out.println("1. Ingresar 5 Elementos");
            System.out.println("2. Desencolar los elementos");
            System.out.println("3. Elemento en la cabeza de la cola");
            opc=in.nextInt();
            in.nextLine();
            switch(opc){
                case 1:
                    for(int i=0;i<5;i++){
                        System.out.print("Ingresa elemento: ");
                        e=in.next();
                        cola.insertar(e);
                    }
                    break;
                case 2:
                    while(!cola.colaVacia()) {
                        Object n = cola.quitar();
                        System.out.print(n);
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    System.out.print("ELEMENTO EN LA CABEZA DE LA COLA: ");
                    System.out.println(cola.frenteCola());
                    break;
            }
            
        }while(opc!=4);
    }
}

