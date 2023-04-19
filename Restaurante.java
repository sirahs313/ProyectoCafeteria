
package com.sua.restaurante;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Restaurante {
    private static Menu menu = new Menu();
    private static Pedido pedido = new Pedido();
    private static Almacen almacen = new Almacen();
    
      private static final Map<String, String> usuarios = new HashMap<>();
    
    static {
        // Agregar usuarios y contraseñas 
        usuarios.put("admin", "password");
        usuarios.put("mesero", "mesero");
        usuarios.put("EnC", "EnC");
    }
    public static void main(String[] args) throws InterruptedException {
        int opcion = 0;
         boolean accesoPermitido = false;
                 
        Scanner scanner = new Scanner(System.in);    
        
          while (!accesoPermitido) {
         // Pedimos al usuario que ingrese sus credenciales
        System.out.print("Ingrese su usuario: ");
        String usuarioIngresado = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasenaIngresada = scanner.nextLine();

        // Verificamos si las credenciales son válidas
        if (usuarios.containsKey(usuarioIngresado) && usuarios.get(usuarioIngresado).equals(contrasenaIngresada)) {
            // Las credenciales son correctas, mostramos el menú
            System.out.println("Bienvenido, " + usuarioIngresado + "!");
        
        do {
             System.out.println("-'-'-'-'-'-'-'CAFETERIA-'-'-'-'-'-'-'");
            System.out.println("1) Administrar Ventas");
            System.out.println("2) Serivicio Mesero");
            System.out.println("3) Encargado de Cocina");
            System.out.println("4) Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    String resp;
                    do{
                        //Muestra Las ventas en el dia
                         System.out.println("Ventas del dia");
                         pedido.mostrarVendidos();
                         System.out.println("Desea regresar al menu Principal? S/N");
                         resp=scanner.next();
                    }while(resp.equals("n"));
                    break;

                case 2:
               
                    int rep3;
                    String rp,rp2;
                    
                   do{
                   System.out.println("1)Realizar Pedido a Cliente");
                   System.out.println("2)Mostrar Pedido y Cobrar");
                   System.out.println("3)Eliminar Articulo del pedido");
                   System.out.println("4)Salir");
                      rep3=scanner.nextInt();
                      
                      switch(rep3){
                          
                          case 1:  
                              
                              do{
                              menu.mostrarMenu();
                              agregarPlatillo(scanner);
                                     System.out.println("Deseas ingresar otro Platillo? S/N");
                                     rp=scanner.next();
                                  }while(rp.equals("s"));
                             
                              break;
                                    case 2:
                                        pedido.mostrarPedido();
                                        pagar();
                                        break;
                                            case 3:
                                                 eliminarPlatillo(scanner);
                                                break;
                                            case 4:
                                                System.out.println("Saliendo. . . . . .");
                                                    break;
                                                    default:
                                                System.out.println("Opción no válida");
                               
                      }
                       System.out.println("Desea regresar al Menu del Mesero? S/N");
                       rp2=scanner.next();
                   }while(rp2.equals("s"));
                        break;
                        
                        
                case 3:
                    int resp4;
                    String resp5;
                    do{
                     System.out.println("ALMACEN DE COCINA");
                     System.out.println("1)Mostrar productos ");
                     System.out.println("2)Ordenar Por Fecha de Caducidad");
                     System.out.println("3)Eliminar Productos ");
                     System.out.println("4)Salir");
                     System.out.println("Ingrese opcion: ");
                     resp4=scanner.nextInt();
                     switch(resp4){
                         case 1:
                             almacen.mostrarProductos(); // muestra los productos sin ordenar
                             break;
                         case 2:
                             String resp2;
                             do{
                              almacen.ordenarPorFechaCaducidad();
                              almacen.mostrarProductos(); // muestra los productos ordenados por fecha de caducidad
                                 System.out.println("Eliminar el Producto Hechado a Perder ->E<-");
                                 resp=scanner.next();
                             }while(resp.equals("s"));
                             almacen.eliminarProducto();
                             almacen.mostrarProductos();
                              break;    
                         case 3:
                             String resp3;                           
                                                          do{
                             almacen.mostrarProductos();
                                 System.out.println("Presione E para eliminar del sistema el producto");
                                 resp2=scanner.next();
                             }while(resp2.equals("s"));
                              almacen.eliminarProducto();
                              almacen.mostrarProductos();
                             break;
                         case 4:
                              System.out.println("Saliendo. . . . . .");
                                break;
                                default:
                              System.out.println("Opción no válida");
                                         
                     }
                        System.out.println("Desea regresar al Menu de Encargado de cocina? S/N");
                         resp5=scanner.next();
                    }while(resp5.equals("s"));    
                    break;
                    
                case 4:
                    System.out.println("Saliendo. . . . . .");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
        accesoPermitido = true;
    }else{
            System.out.println("Credenciales incorrectas, intente nuevamente .......");
           
        
         
    }
        }
          
    }
    
    public static void agregarPlatillo(Scanner scanner) {
        System.out.print("Platillo: ");
        String platillo = scanner.next();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        pedido.agregarPlatillo(platillo, cantidad);
    }
    
    public static void eliminarPlatillo(Scanner scanner) {
        pedido.mostrarPedido();
        System.out.print("Número de ítem del platillo a eliminar: ");
        int item = scanner.nextInt();
        pedido.eliminarPlatillo(item);
    }
    
    public static void pagar() {
        System.out.println("¡Gracias por su compra!");
        pedido = new Pedido();
    }
    
}
