package edd_tarea4;

public class Validar {
    
    public int esNum(String entrada) throws NumberFormatException {
        return Integer.parseInt(entrada);
    }
    
    public boolean esPalabra(String entrada) {
        return entrada.matches("[a-zA-Z]+");
    }
    
    
}
