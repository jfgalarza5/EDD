package edd_tarea4;

public class Pedido {
    int numPedido;
    String nombreCliente;
    Cola productos=new Cola();
    double tiempo;
    
    public Pedido(int numPedido, String nombreCliente, Cola productos, double tiempo) {
        this.numPedido = numPedido;
        this.nombreCliente = nombreCliente;
        this.productos = productos;
        this.tiempo=tiempo;
    }
    
    public void agregarProducto(Plato a){
        productos.encolar(a);
    }
}
