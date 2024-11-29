package p114_Animal;

public class App {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        Gato miGato = new Gato();

        miGato.dormir();
        miGato.sonido();
    }

}
