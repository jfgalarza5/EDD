package edd_tarea4;

public class Pila <T>{
   int tamaño;
   Nodo<T> tope;

    public Pila(){
        this.tamaño = 0;
        this.tope = null;
    }
   
   //Metodo para insertar un elemento en la pila(push)
    public void push(T valor){
        Nodo nodo=new Nodo(valor);
        nodo.siguiente=tope;
        tope=nodo;
        tamaño++;
    }
    
    public T pop(){
        if(!vacia()){
            T returnValue=tope.valor;
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
            System.out.println(tope.valor);
            tope=tope.siguiente;
            System.out.println("");
        }
        tope=valor;
    }
    
    public void clear(){
        int valor=tamaño;
        for(int i=0;i<valor;i++){
            pop();
        }
    }
    
    public Object cima(){
        if(!vacia()) return tope.valor;
        return null;
    }
}
