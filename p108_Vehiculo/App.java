package p108_Vehiculo;

public class App {
    public static void main(String[] args) {
        double precio=0;
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        Compacto c1 = new Compacto("1032", "Toyota", 2013,5000,8, 4);
        Compacto c2 = new Compacto("57474", "Chevrolet", 2018,7000,4, 4);
        Camioneta v1 = new Camioneta("321314", "Mazda", 2019,10000, 10, 5);
        Camioneta v2 = new Camioneta("98646", "Nissan", 2021,15500, 5, 2);

        System.out.println("Datos de los Vehiculos de la flota");

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(v1.toString());
        System.out.println(v2.toString());

        System.out.println("Calculando el total de precio de todos los vehículos ...");

        System.out.println(c1.getPrecio());
        System.out.println(c2.getPrecio());
        System.out.println(v1.getPrecio());
        System.out.println(v2.getPrecio());
        precio = (c1.getPrecio()+c2.getPrecio()+v1.getPrecio()+v2.getPrecio());
        System.out.println("La suma de precios es:"+precio);

        
       

        
    }
    
}
