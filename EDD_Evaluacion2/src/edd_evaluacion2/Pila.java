package edd_evaluacion2;

public class Pila {
   int tamaño;
   Nodo tope;

    public Pila() {
        this.tamaño = 0;
        this.tope = null;
    }
   
   //Metodo para insertar un elemento en la pila(push)
    public void push(Libro valor){
        Nodo nodo=new Nodo(valor);
        nodo.siguiente=tope;
        tope=nodo;
        tamaño++;
    }
    
    public Libro pop(){
        if(!vacia()){
            Libro returnValue=tope.valor;
            tope=tope.siguiente;
            tamaño--;
            return returnValue;
        }else{
            return null;
        }
    }
    
    public boolean vacia(){
        if(tope==null) return true;
        return false;
    }
    
    public void show(){
        Nodo valor=tope;
        for(int i=0;i<tamaño;i++){
            System.out.println("====Libro Num."+(i+1)+"===");
            System.out.println("Titulo: "+tope.valor.Titulo);
            System.out.println("Autor: "+tope.valor.Autor);
            System.out.println("Año de Edicion: "+tope.valor.AñoEdicion);
            tope=tope.siguiente;
            System.out.println("");
        }
        tope=valor;
    }
    
    public void clear(){
        int valor=tamaño;
        for(int i=0;i<valor;i++){
            System.out.println("Libro quitado: "+pop().Titulo);
        }
    }
    
    public Libro cima(){
        if(!vacia()) return tope.valor;
        return null;
    }
}
