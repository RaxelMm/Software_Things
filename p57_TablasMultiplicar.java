
/**
 * p57_TablasMultiplicar - imprimir las tablas del 1 al 10 hasta el 10
 */
import java.util.Scanner;

public class p57_TablasMultiplicar {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borrar pantalla de la consola
        Scanner teclado = new Scanner(System.in);
        boolean repite = true;

        while (repite) {
            System.out.println("Hasta que tabla quieres ?");
            int n = teclado.nextInt();
            System.out.println("Hasta donde la quieres ?");
            int m = teclado.nextInt();

            for (int i = 1; i <= n; i++) {
                System.out.println("Tabla del " + i);
                for (int j = 1; j <= m; j++) {
                    System.out.println(i + " x " + j + " = " + i * j);
                }
                System.out.println();

            }
            System.out.println("Deseas continua [S]i o [N]o");
            String resp = teclado.next().toUpperCase();
            repite = resp.equals("S");

        }
        System.out.println("Proceso terminado");
        teclado.close();

    }

}