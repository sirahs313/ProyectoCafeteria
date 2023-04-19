
package com.sua.restaurante;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

class Almacen {
    private Producto[] productos;

    public Almacen() {
        productos = new Producto[]{
            new Producto("Leche", LocalDate.of(2023, 1, 30), 10),
            new Producto("Queso", LocalDate.of(2023, 3, 15), 5),
            new Producto("Pan", LocalDate.of(2023, 2, 20), 20),
            new Producto("CafeGr", LocalDate.of(2023, 9, 1), 15),
            new Producto("Aderezo", LocalDate.of(2023, 6, 25), 8),
            new Producto("Harina", LocalDate.of(2023, 1, 25), 15),
            new Producto("Huevo", LocalDate.of(2023, 8, 23), 20),    
        };
    }

    public void ordenarPorFechaCaducidad() {
        Arrays.sort(productos, Comparator.comparing(Producto::getFechaCaducidad));
    }

    public void mostarProductos() {
        System.out.println("=== PRODUCTOS ===");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - " + "Caducidad: "+producto.getFechaCaducidad() + " - " + "Cantidad: "+producto.getCantidad());
        }
        System.out.println("=================");
    }
     public void eliminarProducto() {
        if (productos.length > 0) {
        Producto[] nuevosProductos = new Producto[productos.length - 1];
        System.arraycopy(productos, 1, nuevosProductos, 0, productos.length - 1);
        productos = nuevosProductos;
        }
    }
     
}
