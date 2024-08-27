
/**
 * p35_ContinentesMundo - Mostrara los continentes asignados a numeros del 1 y 6
 */
import java.util.Scanner;

public class p35_ContinentesMundo {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borrar pantalla de la consola
        Scanner teclado = new Scanner(System.in);
        int ops;

        System.out.println("Dame un numero entre 1 y 6 y te dire el continente");

        ops = teclado.nextInt();

        switch (ops) {
            case 1:
                System.out.println("Asia");
                break;
            case 2:
                System.out.println("Africa");
                break;
            case 3:
                System.out.println("America del Norte");
                break;
            case 4:
                System.out.println("America del Sur");
                break;
            case 5:
                System.out.println("Antartida");
                break;
            case 6:
                System.out.println("Europa");
                break;

            default:
                System.out.println("ERROR");

                break;
        }
        teclado.close();

    }

}