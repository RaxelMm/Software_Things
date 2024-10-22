package p118_Calculadora;

public class App {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        Calculadora maizoro = new Calculadora();

        maizoro.sumar(10, 20);
        maizoro.restar(100, 50);
        maizoro.Multiplicar(5, 5);
        maizoro.Dividir(5000, 20);
    }

}
