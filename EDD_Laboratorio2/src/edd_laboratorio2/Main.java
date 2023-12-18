package edd_laboratorio2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Se iniciacializa todos los atributos
        int opc,numPedido=0,numProducto,cantidad;
        String a;
        double precio;
        String nombreCli,nombrePro;
        Scanner in = new Scanner(System.in);
        Cola<Producto> producto = new Cola();
        Restaurante rest = new Restaurante(new Pila(),new Cola(),new Cola());
        Validar validar = new Validar();
        
        //Se muestra el menu
        do{
            System.out.println("===MENU===");
            System.out.println("1. Agregar un nuevo pedido");
            System.out.println("2. Mostrar pedidos pendientes");
            System.out.println("3. Preparar el pedido actual");
            System.out.println("4. Mostrar pedidos preparados");
            System.out.println("5. Entregar el pedido preparado actual al cliente");
            System.out.println("6. Mostrar pedidos entregados");
            System.out.println("7. Salir");
            opc=in.nextInt();
            in.nextLine();
            //Casos
            switch(opc){
                //Se agrega un pedido
                case 1:
                    numPedido++;
                    System.out.println("===PEDIDO NUM. "+numPedido+"===");
                    System.out.print("Nombre del cliente: ");
                    nombreCli=in.nextLine();
                    if(validar.esPalabra(nombreCli)){
                        System.out.print("Cantidad de productos: ");
                        a=in.nextLine();
                        if(validar.esNum(Integer.parseInt(a))){
                            numProducto=Integer.parseInt(a);
                            for(int i=0;i<numProducto;i++){
                                System.out.println("===PRODUCTO "+(i+1)+"===");
                                System.out.print("Nombre: ");
                                
                                nombrePro=in.nextLine();
                                System.out.print("Precio: ");
                                precio=in.nextDouble();
                                System.out.print("Cantidad: ");
                                cantidad=in.nextInt();
                                in.nextLine();
                                producto.encolar(new Producto(nombrePro,precio ,cantidad));
                            }                    
                            rest.agregarPedido(new Pedido(numPedido,nombreCli,producto));
                            producto=new Cola();
                        }
                        
                    }
                    
                    break;
                //Se muestra los pedidos pendientes
                case 2:
                    Nodo<Pedido> pedidoP=rest.pedidosPendiente.tope;
                    for(int i=0;i<rest.pedidosPendiente.tamaño;i++){
                        System.out.println("Num pedido: "+pedidoP.valor.numPedido);
                        System.out.println("Nombre Cliente: "+pedidoP.valor.nombreCliente);
                        Nodo<Producto> nodoProducto = pedidoP.valor.productos.frente;
                        while (nodoProducto != null) {
                            System.out.println("===PRODUCTO===");
                            System.out.println("Nombre: "+nodoProducto.valor.nombre);
                            System.out.println("Precio: "+nodoProducto.valor.precio);
                            System.out.println("Cantidad: "+nodoProducto.valor.cantidad);
                            nodoProducto = nodoProducto.siguiente;
                        }
                        pedidoP=pedidoP.siguiente;
                        System.out.println("");
                    }
                    break;
                //Se prepara el pedido actual
                case 3:
                    System.out.println("Preparando el pedido actual...");
                    rest.prepararPedidoActual();
                    break;
                case 4:
                    Nodo<Pedido> pedidoPre=rest.pedidosPreparados.frente;
                    while (pedidoPre != null) {
                        System.out.println("Num pedido: "+pedidoPre.valor.numPedido);
                        System.out.println("Nombre Cliente: "+pedidoPre.valor.nombreCliente);
                        Nodo<Producto> nodoProducto = pedidoPre.valor.productos.frente;
                        while (nodoProducto != null) {
                            System.out.println("===PRODUCTO===");
                            System.out.println("Nombre: "+nodoProducto.valor.nombre);
                            System.out.println("Precio: "+nodoProducto.valor.precio);
                            System.out.println("Cantidad: "+nodoProducto.valor.cantidad);
                            nodoProducto = nodoProducto.siguiente;
                        }
                        pedidoPre=pedidoPre.siguiente;
                        System.out.println("");
                    }
                    break;
                //Se netrega el pedido preparado
                case 5:
                    System.out.println("Entregando el pedido al cliente....");
                    rest.entregarPedidoPreparado();
                    break;
                case 6:
                    Nodo<Pedido> pedidoEnt=rest.pedidosEntregados.frente;
                    while (pedidoEnt != null) {
                        System.out.println("Num pedido: "+pedidoEnt.valor.numPedido);
                        System.out.println("Nombre Cliente: "+pedidoEnt.valor.nombreCliente);
                        Nodo<Producto> nodoProducto = pedidoEnt.valor.productos.frente;
                        while (nodoProducto != null) {
                            System.out.println("===PRODUCTO===");
                            System.out.println("Nombre: "+nodoProducto.valor.nombre);
                            System.out.println("Precio: "+nodoProducto.valor.precio);
                            System.out.println("Cantidad: "+nodoProducto.valor.cantidad);
                            nodoProducto = nodoProducto.siguiente;
                        }
                        pedidoEnt=pedidoEnt.siguiente;
                        System.out.println("");
                    }
                    break;
            }
        }while(opc!=7);
    }
    
}
