
package com.sua.restaurante;

class Menu {
    private String[] platillos;
    private double[] precios;
    
    public Menu() {
        platillos = new String[]{"Hamburguesa", "Pizza", "Ensalada", "Sopa", "Pasta","Hotcakes","Refresco","Malteada","Cafe","Torta","Pizza","Frappe"};
        precios = new double[]{30.0, 60.0, 15.00, 16.0, 23.0,25.0,15.0,17.0,10.0,50.0,20.0,45.0};
    }
    
    public String[] getPlatillos() {
        return platillos;
    }
    
    public double[] getPrecios() {
        return precios;
    }
    
    public void mostrarMenu() {
        System.out.println("=== MENÚ ===");
        for (int i = 0; i < platillos.length; i++) {
            System.out.println(platillos[i] + " - $" + precios[i]);
        }
        System.out.println("============");
    }
    
    public static double getPrecio(String platillo) {
        Menu menu = new Menu();
        String[] platillos = menu.getPlatillos();
        double[] precios = menu.getPrecios();
        for (int i = 0; i < platillos.length; i++) {
            if (platillos[i].equals(platillo)) {
                return precios[i];
            }
        }
        return 0.0;
    }
}
