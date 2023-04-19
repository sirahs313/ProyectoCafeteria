
package com.sua.restaurante;

import java.time.LocalDate;

class Producto {
    private String nombre;
    private LocalDate fechaCaducidad;
    private int cantidad;

    public Producto(String nombre, LocalDate fechaCaducidad, int cantidad) {
        this.nombre = nombre;
        this.fechaCaducidad = fechaCaducidad;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public int getCantidad() {
        return cantidad;
    }
}

