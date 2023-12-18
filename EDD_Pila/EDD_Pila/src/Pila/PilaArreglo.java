package Pila;

public class PilaArreglo { //define una clase 
    //Se instancian los atributos encapsulados para que sea un TDA
    private Object[] arreglo; //Atributo que almacenara los elementos de la pila
    private int tope;         //Atributo de posicion
    private int maxElemento;  //Atributo de espacios en la pila
    
    //Constructor de la pila
    public PilaArreglo(int maxElemento){// El constructor toma un parámetro 
        this.maxElemento=maxElemento;//Asigna el valor del parámetro al atributo.
        arreglo=new Object[this.maxElemento];//Almacena los elementos de la pila.
        tope=-1; //El atributo tope inicialmente la pila esta vacía
    }

    //------Este método apila y  agrega un elemento a la pila si hay espacio disponible.------
    public void apilar(Object x){//Declara un método.
        if (tope+1<maxElemento){ //Verifica si hay espacio en la pila comparando.
            tope++; //  añade un elemento.
            arreglo[tope]=x; // Agrega el objeto x al arreglo.
        }else{ //  Si la condición  no se cumple,la pila está llena. 
            System.out.println("Pila llena"); 
        } 
    } 
    

    //-------Metodo que retira el elemento superior de la pila y lo devuelve.--------
    public Object desapilar(){
        System.out.println("1");
        if (!estaVacia()){ // Verifica si la pila no está vacía utilizando el metodo.
            Object x=arreglo[tope];//Obtiene el objeto y guarda en la variable x.
            tope--; //Decrementa para indicar que se está retirando un elemento.
            return x;//Devuelve el objeto que se retiró de la pila.
        }
        return null; //Si la pila está vacía, devuelve null para indicar que no hay elementos para retirar.
    }
    
    //Este método se utiliza para consultar el elemento en la cima de la pila sin retirarlo.
    public Object tope(){ 
        if (!estaVacia()){//Verifica si la pila no está vacía utilizando el metodo.
            Object x=arreglo[tope];//: Obtiene el objeto de la cima  y lo guarda en la variable x.
            return x;//Devuelve el objeto que está en la cima de la pila.
        }
        return null;
    }
    
    //-------Este método se utiliza para verificar si la pila está vacía.

    public boolean estaVacia(){
        if (tope==-1){ //Verifica si el índice superior (tope) es igual a -1. 
            return true; // Si el índice superior es -1, indicara que la pila está vacía.
        }else{
            return false;
        }
    }
}
