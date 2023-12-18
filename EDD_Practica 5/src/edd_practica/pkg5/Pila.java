package edd_practica.pkg5;

public class Pila {
   int tamaño;
   Nodo tope;

    public Pila() {
        this.tamaño = 0;
        this.tope = null;
    }
   
   //Metodo para insertar un elemento en la pila(push)
    public void push(int valor){
        Nodo nodo=new Nodo(valor);
        nodo.siguiente=tope;
        tope=nodo;
        tamaño++;
    }
    
    public int pop(){
        if(!vacia()){
            int returnValue=tope.valor;
            tope=tope.siguiente;
            tamaño--;
            return returnValue;
        }else{
            return -1;
        }
    }
    
    public boolean vacia(){
        if(tope==null) return true;
        return false;
    }
    
    public void show(){
        Nodo valor=tope;
        for(int i=0;i<tamaño;i++){
            System.out.println(tope.valor);
            tope=tope.siguiente;
        }
        tope=valor;
    }
    
    public void clear(){
        int valor=tamaño;
        for(int i=0;i<valor;i++){
            System.out.println("Valor quitado: "+pop());
        }
    }
    
    public int cima(){
        if(!vacia()) return tope.valor;
        return -1;
    }
}
