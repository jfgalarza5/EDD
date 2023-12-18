package edd_laboratorio2;

public class Restaurante {
    Pila<Pedido> pedidosPendiente;
    Cola<Pedido> pedidosPreparados;
    Cola<Pedido> pedidosEntregados;
    
    public Restaurante(Pila pedidosPendiente, Cola pedidosPreparados, Cola pedidosEntregados) {
        this.pedidosPendiente = pedidosPendiente;
        this.pedidosPreparados = pedidosPreparados;
        this.pedidosEntregados=pedidosEntregados;
    }
    
    public void agregarPedido(Pedido pedido){
        pedidosPendiente.push(pedido);
    }
    
    public void prepararPedidoActual(){
        pedidosPreparados.encolar(pedidosPendiente.tope.valor);
        System.out.println("Pedido numero: "+pedidosPendiente.pop().numPedido+" se mando a preparar");
    }
    
    public void entregarPedidoPreparado(){
        pedidosEntregados.encolar(pedidosPreparados.frente.valor);
        System.out.println("Pedido numero: "+pedidosPreparados.desencolar().numPedido+" ha sido entregado");
    }
}
