package edd_laboratorio2;

public class Pedido {
    int numPedido;
    String nombreCliente;
    Cola productos=new Cola();

    public Pedido(int numPedido, String nombreCliente, Cola productos) {
        this.numPedido = numPedido;
        this.nombreCliente = nombreCliente;
        this.productos = productos;
    }
    
    public void agregarProducto(Producto a){
        productos.encolar(a);
    }
}
