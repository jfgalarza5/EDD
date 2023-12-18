package edd_practica4_johngalarza;

import java.util.*;

public class Menu {
    
    String nombre,nacionalidad;
    double tiempo;
    int opc,num;
    Scanner in = new Scanner(System.in);
    ArrayList<Atleta> lista = new ArrayList<>();
    Competencia comp=new Competencia();
    public void menu(){
        do{
            
            System.out.println("==MENU==");
            System.out.println("1. Registrar Atleta ");
            System.out.println("2. Datos del campeon");
            System.out.println("3. Atletas por pais");
            System.out.println("4. Tiempo promedio de los atletas");
            System.out.println("5. Eliminar Atleta");
            System.out.println("6. Mostrar todos los atletas");
            System.out.println("7. Salir");
            opc=in.nextInt();
            in.nextLine();
            switch(opc){
                case 1:
                    System.out.println("Ingrese el nombre: ");
                    nombre=in.nextLine();
                    System.out.println("Ingrese la nacionalidad:");
                    nacionalidad=in.nextLine();
                    System.out.println("Ingrese el tiempo:");
                    tiempo=in.nextDouble();
                    lista.add(new Atleta(nombre,nacionalidad,tiempo));
                    break;
                case 2:
                    comp.menorTiempo(lista);
                    break;
                case 3:
                    comp.atletasNacionalidad(lista);
                break;
                case 4:
                    System.out.println("El tiempo promedio de los atletas es: "+comp.prom(lista));
                    break;
                case 5:
                    System.out.println("Ingresa el numero del atleta");
                    num=in.nextInt();
                    lista.remove(num-1);
                    System.out.println("Eliminado");
                    break;
                case 6:
                    comp.mostrar(lista);
            }
            
        }while(opc!=7);
    }
}
