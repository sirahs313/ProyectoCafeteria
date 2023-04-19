
package com.sua.restaurante;

class Pedido {
    private String[] platillos;
    private int[] cantidades;
    
    public Pedido() {
        platillos = new String[5];
        cantidades = new int[5];
    }
    
    public void agregarPlatillo(String platillo, int cantidad) {
        int i = 0;
        while (platillos[i] != null) {
            if (platillos[i].equals(platillo)) {
                cantidades[i] += cantidad;
                return;
            }
            i++;
        }
        platillos[i] = platillo;
        cantidades[i] = cantidad;
    }
    
    public void mostrarPedido() {
        double total = 0.0;
        System.out.println("=== PEDIDO ===");
        for (int i = 0; i < platillos.length; i++) {
            if (platillos[i] != null) {
                double precio = Menu.getPrecio(platillos[i]);
                System.out.println((i+1) + ". " + platillos[i] + " x" + cantidades[i] + " - $" + precio*cantidades[i]);
                total += precio*cantidades[i];
            }
        }
        System.out.println("Total: $" + total);
        System.out.println("==============");
    }
    
    public void eliminarPlatillo(int item) {
        platillos[item-1] = null;
        cantidades[item-1] = 0;
    }
    public void mostrarVendidos(){
        double total = 0.0;
        for (int i = 0; i < platillos.length; i++) {
            if (platillos[i] != null) {
                
                double precio = Menu.getPrecio(platillos[i]);
                
                total += precio*cantidades[i];
            }
        }
        System.out.println("Total Vendido en el dia: $" + total);
        System.out.println("==============");
    }

        
    
    
}
