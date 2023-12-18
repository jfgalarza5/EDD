package edd_practica4_johngalarza;

import java.util.ArrayList;
import java.util.Scanner;

public class Competencia {
    Scanner in = new Scanner(System.in);
    
    public double prom(ArrayList<Atleta> lista){
        double prom=0;
        for(Atleta a:lista){
            prom=a.tiempo/lista.size()+prom;
        }
        return prom;
    }
    
    public void menorTiempo(ArrayList<Atleta> lista){
        String nombre=null,nacionalidad=null;
        double menor=lista.get(0).tiempo;   
        for(Atleta e:lista){
            if(e.tiempo<=menor){
                menor=e.tiempo;
                nombre=e.nombre;
                nacionalidad=e.nacionalidad;
            }
        }
        System.out.println("=====CAMPEON======");
        System.out.println("Nombre: "+nombre);
        System.out.println("Nacionalidad: "+nacionalidad);
        System.out.println("Tiempo: "+menor);
    }
    
    public void mostrar(ArrayList<Atleta> lista){
        System.out.println("ATLETAS");
        for(Atleta e:lista){
            System.out.println("=============");
            System.out.println("Nombre: "+e.nombre);
            System.out.println("Nacionalidad: "+e.nacionalidad);
            System.out.println("Tiempo: "+e.tiempo);
        }
    }
    
    public void atletasNacionalidad(ArrayList<Atleta> lista){
        System.out.println("Ingrese la Nacionalidad: ");
        String nacionalidad=in.nextLine();
        System.out.println("Atletas "+nacionalidad+"s");
        for(Atleta e:lista){

            if(e.nacionalidad.equals(nacionalidad)){
                System.out.println("===================");
                System.out.println("Nombre: "+e.nombre);
            }
        }
        System.out.println("===================");
    }
}
