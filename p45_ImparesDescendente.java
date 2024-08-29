/**
 * p55_ImparesDescendente - imprime numeros impares desde n hasta 1 , repite el proceso varias veces
 */
import java.util.Scanner;

public class p45_ImparesDescendente {
    public static void main(String[] args) {
        char resp;
        int c, n, s;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            n = 0;
            s = 0;
            System.out.println("Imprime ipares de forma descendente de n hasta 1\n");
            System.out.println("Hasta donde deseas los impares");
            n = teclado.nextInt();
            //if (n%2==0) n++; { }
            c = (n%2==00 ? ++n : n);

            c = n;

            while (c >= 1) {
                System.out.printf(" %d, ", c);
                s+=c;
                c -= 2;
                

            }

            System.out.printf("\nLa suma de los pares hasta %d es %d\n", n, s);

            System.out.println("Deseas continuar [S]i o [N]o");
            resp = Character.toUpperCase(teclado.next().charAt(0));

        } while (resp != 'N');
        System.out.println("\nProceso terminado");
        teclado.close();

        
    }

    
}