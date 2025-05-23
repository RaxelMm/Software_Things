package VehiculoVarios;


public class Main {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borra pantalla de la consola
        AutoBus a1 = new AutoBus("17", "39219831", 50, 100);
        Taxi t1 = new Taxi("Tsuru","32131",5,4,321);
        Tren tt1 = new Tren("Ferro", "32173881", 100, "De Pasajeros", "Guadalupe");

        System.out.println(t1.toString());
        System.out.println(a1.toString());
        System.out.println(tt1.toString());
        }

        

}

