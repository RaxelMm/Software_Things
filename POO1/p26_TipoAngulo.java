
/**
 * p26_TipoAngulo - Determina el tipo de angulo en base a su magnitud
 */
import java.util.Scanner;

public class p26_TipoAngulo {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borra pantalla de la consola
        System.out.println("\nDame un angulo de 0 y 360 grados y te dire su tipo ");
        int angulo = new Scanner(System.in).nextInt();

        if (angulo < 0 || angulo > 360) {
            System.out.println("De cual fumaste");

        } else {
            System.out.print("el tipo de angulo es: ");
            if (angulo < 90)
                System.out.println("agudo");
            if (angulo > 90 && angulo < 180)
                System.out.println("obtuso");
            if (angulo == 90)
                System.out.println("recto");
            if (angulo == 180)
                System.out.println("Llano");
            if (angulo > 180 && angulo < 360)
                System.out.println("Concavo");
            if (angulo == 360)
                System.out.println("Completo");

        }
        System.out.println("Ya casi te estas ganando tu torta de lomo del comedor");

    }

}