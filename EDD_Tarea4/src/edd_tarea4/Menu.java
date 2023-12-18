package edd_tarea4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Menu {
     //Se iniciacializa todos los atributos
        int opc,numPedido=0,numProducto,numPlato=0;
        String a;
        boolean bandera;
        double precio,tiempo;
        String nombreCli,nombrePro,tipo;
        Scanner in = new Scanner(System.in);
        Cola<Plato> producto = new Cola();
        Restaurante rest = new Restaurante(new Pila(),new Cola(),new Cola());
        Validar validar = new Validar();
        ArrayList<Plato> listaPlato = new ArrayList();
        
        public void menu() throws IOException{
                do{
                   System.out.println("===MENU DEL RESTAURANTE===");
                   System.out.println("1. Agregar un nuevo plato");
                   System.out.println("2. Agregar pedido de la cocina");
                   System.out.println("3. Mostrar detalles de los pedidos");
                   System.out.println("4. Eliminar pedido de la cocina");
                   System.out.println("5. Preparar el pedido actual");
                   System.out.println("6. Mostrar pedidos preparados");
                   System.out.println("7. Servir el pedido en el comedor");
                   System.out.println("8. Mostrar pedidos entregados");
                   System.out.println("9. Guardar En fichero los pedidos");
                   System.out.println("10. Leer en fichero los pedidos");
                   System.out.println("11. Salir");
                   opc=in.nextInt();
                   in.nextLine();
                   //Casos
                   switch(opc){
                       case 1:
                            numPlato++;
                            if(numPlato<=10){
                                System.out.println("===PLATO "+(numPlato)+"===");
                                System.out.print("Nombre: ");
                                nombrePro=in.nextLine();
                                if(validar.esPalabra(nombrePro)){
                                    System.out.print("Precio: ");
                                    precio=in.nextDouble();
                                    in.nextLine();
                                    if(precio>0){
                                        System.out.print("Tipo: ");
                                        tipo=in.nextLine();
                                        if(validar.esPalabra(tipo)){
                                            listaPlato.add(new Plato(nombrePro,precio,tipo));
                                        }else{
                                            System.out.println("No es palabra");
                                            numPlato--;
                                        }
                                    }else{
                                        System.out.println("El precio es negativo");
                                        numPlato--;
                                    }
                                }else{
                                    System.out.println("No es una palabra");
                                    numPlato--;
                                }
                                
                            }
                           break;
                       //Se agrega un pedido
                       case 2:
                           numPedido++;
                           if(numPedido<=10){
                                System.out.println("===PEDIDO NUM. "+numPedido+"===");
                                System.out.print("Nombre del cliente: ");
                                nombreCli=in.nextLine();
                                if(validar.esPalabra(nombreCli)){
                                    System.out.print("Cantidad de productos: ");
                                    numProducto=in.nextInt();
                                    in.nextLine();
                                    if(numProducto>0){
                                        for(int i=0;i<numProducto;i++){
                                            System.out.println("===PLATO "+(i+1)+"===");
                                            System.out.println("Escriba el nombre del plato: ");
                                            nombrePro=in.nextLine();
                                            int index=0;
                                            bandera=false;
                                            for(Plato e:listaPlato){
                                                if(e.nombre.equals(nombrePro)){
                                                    producto.encolar(new Plato(nombrePro,precio ,tipo));
                                                    System.out.println("Plato agregado");
                                                    bandera=true;
                                                }
                                                index++;
                                            }
                                        }
                                        if(bandera){
                                            System.out.println("Ingresa el tiempo de demora del pedido: ");
                                            tiempo=in.nextDouble();
                                            rest.agregarPedido(new Pedido(numPedido,nombreCli,producto,tiempo));
                                            producto=new Cola();
                                            ordenar();
                                        }else{
                                            System.out.println("Plato no encontrado");
                                            numPedido--;
                                        }
                                    }else{
                                        System.out.println("No es un numero positivo");
                                        numPedido--;
                                    }
                                }else{
                                    System.out.println("No es una palabra");
                                    numPedido--;
                                }
                           }else{
                               System.out.println("Solo se pueden realizar 10 pedidos maximos");
                           }
                           

                           break;
                       //Se muestra los pedidos pendientes
                       case 3:
                           Nodo<Pedido> pedidoP=rest.pedidosPendiente.tope;
                           for(int i=0;i<rest.pedidosPendiente.tamaño;i++){
                               System.out.println("Num pedido: "+pedidoP.valor.numPedido);
                               System.out.println("Nombre Cliente: "+pedidoP.valor.nombreCliente);
                               System.out.println("Tiempo: "+pedidoP.valor.tiempo);
                                Nodo<Plato> nodoProducto = pedidoP.valor.productos.frente;
                               while (nodoProducto != null) {
                                   System.out.println("===PLATO===");
                                   System.out.println("Nombre: "+nodoProducto.valor.nombre);
                                   System.out.println("Precio: "+nodoProducto.valor.precio);
                                   System.out.println("Tipo: "+nodoProducto.valor.tipo);
                                   nodoProducto = nodoProducto.siguiente;
                               }
                               pedidoP=pedidoP.siguiente;
                               System.out.println("");
                           }
                           break;
                       case 4:
                           System.out.println("Eliminando el ultimo pedido de la cocina");
                           rest.pedidosPendiente.pop();
                           numPedido--;
                           break;
                       //Se prepara el pedido actual
                       case 5:
                           System.out.println("Preparando el pedido actual...");
                           rest.prepararPedidoActual();
                           break;
                       case 6:
                           Nodo<Pedido> pedidoPre=rest.pedidosPreparados.frente;
                           while (pedidoPre != null) {
                               System.out.println("Num pedido: "+pedidoPre.valor.numPedido);
                               System.out.println("Nombre Cliente: "+pedidoPre.valor.nombreCliente);
                               System.out.println("Tiempo: "+pedidoPre.valor.tiempo);
                               Nodo<Plato> nodoProducto = pedidoPre.valor.productos.frente;
                               while (nodoProducto != null) {
                                   System.out.println("===PLATO===");
                                   System.out.println("Nombre: "+nodoProducto.valor.nombre);
                                   System.out.println("Precio: "+nodoProducto.valor.precio);
                                   System.out.println("Tipo: "+nodoProducto.valor.tipo);
                                   nodoProducto = nodoProducto.siguiente;
                               }
                               pedidoPre=pedidoPre.siguiente;
                               System.out.println("");
                           }
                           break;
                       //Se netrega el pedido preparado
                       case 7:
                           System.out.println("Entregando el pedido al cliente....");
                           rest.entregarPedidoPreparado();
                           break;
                       case 8:
                           Nodo<Pedido> pedidoEnt=rest.pedidosEntregados.frente;
                           while (pedidoEnt != null) {
                               System.out.println("Num pedido: "+pedidoEnt.valor.numPedido);
                               System.out.println("Nombre Cliente: "+pedidoEnt.valor.nombreCliente);
                               System.out.println("Tiempo: "+pedidoEnt.valor.tiempo);
                               Nodo<Plato> nodoProducto = pedidoEnt.valor.productos.frente;
                               while (nodoProducto != null) {
                                   System.out.println("===Plato===");
                                   System.out.println("Nombre: "+nodoProducto.valor.nombre);
                                   System.out.println("Precio: "+nodoProducto.valor.precio);
                                   System.out.println("Tipo: "+nodoProducto.valor.tipo);
                                   nodoProducto = nodoProducto.siguiente;
                               }
                               pedidoEnt=pedidoEnt.siguiente;
                               System.out.println("");
                           }
                           break;
                       case 9:
                           escribirArchivo();
                           break;
                       case 10:
                           leerArchivo();
                       break;
                       default:
                              System.out.println("Opcion no especificada");
                   }
               }while(opc!=11);
           }
        
        public void ordenar(){
            ArrayList<Pedido> temp = new ArrayList();
            Nodo valor=rest.pedidosPendiente.tope;
            int n=rest.pedidosPendiente.tamaño;
            
            for(int i=0;i<n;i++){
                temp.add(rest.pedidosPendiente.tope.valor);
                rest.pedidosPendiente.tope=rest.pedidosPendiente.tope.siguiente;
            }
            rest.pedidosPendiente.tope=valor;
            rest.pedidosPendiente.clear();
            
            
            
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (temp.get(j).tiempo < temp.get(j+1).tiempo) {
                        // Intercambiar elementos si están en el orden incorrecto
                        Pedido pedidoTemp = temp.get(j);
                        temp.set(j, temp.get(j + 1));
                        temp.set(j + 1,pedidoTemp);
                    }
                }
            }
            for(Pedido e:temp){
                rest.pedidosPendiente.push(e);
            }
        }
        
        public void escribirArchivo(){
            File Archivo = new File("Pedido.txt");

            try{
                PrintWriter salida = new PrintWriter(Archivo);
                salida.println("===LISTA DE PEDIDOS===");
                salida.println();
                Nodo<Pedido> pedidoP=rest.pedidosPendiente.tope;
                for(int i=0;i<rest.pedidosPendiente.tamaño;i++){
                    salida.println("Num pedido: "+pedidoP.valor.numPedido);
                    salida.println("Nombre Cliente: "+pedidoP.valor.nombreCliente);
                    Nodo<Plato> nodoProducto = pedidoP.valor.productos.frente;
                    while (nodoProducto != null) {
                        salida.println("===PLATO===");
                        salida.println("Nombre: "+nodoProducto.valor.nombre);
                        salida.println("Precio: "+nodoProducto.valor.precio);
                        salida.println("Tipo: "+nodoProducto.valor.tipo);
                        nodoProducto = nodoProducto.siguiente;
                    }
                    pedidoP=pedidoP.siguiente;
                    salida.println("");
                }
                salida.close();
            }catch(FileNotFoundException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        public void leerArchivo() throws IOException{
            File Archivo = new File("Pedido.txt");

            try{
                BufferedReader entrada = new BufferedReader(new FileReader( "Pedido.txt"));
                String lectura = entrada.readLine();

                while(lectura != null){
                    System.out.println(lectura);
                    lectura = entrada.readLine();
                }
                entrada.close();
            }catch(FileNotFoundException ex){
                ex.printStackTrace(System.out);
            }catch(IOException e){
                e.printStackTrace(System.out);
            }
        }
    }
