/**
 * p48_ImparesAscendente - imprimir los números impares de forma ascendente desde 1 hasta el número que el usuario decida (n)
 */
import java.util.Scanner;

public class p48_ImparesAscendente {
    public static void main(String[] args) {
        char resp;
        int c, n, s,count,p;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            n = 0;
            s = 0;
            count = 0;
            p=0;
            System.out.println("Imprime impares de forma ascendente de 1 hasta n\n");
            System.out.println("Hasta dónde deseas los impares:");
            n = teclado.nextInt();

            // Comenzamos en 1, ya que es el primer número impar
            c = 1;

            while (c <= n) {
                System.out.printf(" %d, ", c);
                s += c;
                c += 2; // Incrementa en 2 para obtener el siguiente número impar
                count++;
                p=s/count;
            }

            System.out.printf("\nLa suma de los impares hasta %d es %d\n", n, s);
            System.out.println("\nEl promedio de los impares es\n"+p);

            System.out.println("¿Deseas continuar [S]í o [N]o?");
            resp = Character.toUpperCase(teclado.next().charAt(0));

        } while (resp != 'N');
        System.out.println("\nProceso terminado");
        teclado.close();
    }
}
