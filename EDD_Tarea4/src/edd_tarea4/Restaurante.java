package edd_tarea4;

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
        System.out.println("Se demorara "+pedidosPreparados.frente.valor.tiempo+" segundos");
        esperar(pedidosPreparados.frente.valor.tiempo);
        pedidosEntregados.encolar(pedidosPreparados.frente.valor);
        System.out.println("Pedido numero: "+pedidosPreparados.desencolar().numPedido+" ha sido entregado");
    }
    
    public void esperar(double n){
            try {
                // Intenta detener el programa actual durante 3 segundos (3000 milisegundos)
                Thread.sleep((long) (n*1000));
                } catch (InterruptedException e) {
                // Maneja la excepción si ocurre algún problema durante la pausa del hilo
                e.printStackTrace();
            }
        }
}
