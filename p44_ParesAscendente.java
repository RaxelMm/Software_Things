
/**
 * p44_ParesAscendenteb- Imprime numeros pares desde 2 hasta n , repite el proceso varias veces
 */
import java.util.Scanner;

public class p44_ParesAscendente {
    public static void main(String[] args) {
        char resp;
        int c, n, s;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            c = 2;
            n = 0;
            s = 0;
            System.out.println("Imprime pares de forma ascendente de 2 hasta n\n");
            System.out.println("Hasta donde deseas los pares");
            n = teclado.nextInt();
            while (c <= n) {
                System.out.printf(" %d, ", c);
                s+=c;
                c += 2;
                

            }

            System.out.printf("\nLa suma de los pares hasta %d es %d\n", n, s);

            System.out.println("Deseas continuar [S]i o [N]o");
            resp = Character.toUpperCase(teclado.next().charAt(0));

        } while (resp != 'N');
        System.out.println("\nProceso terminado");
        teclado.close();

    }

}