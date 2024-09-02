
/**
 * p44_ParesAscendenteb- Imprime numeros pares desde n hasta 2 , repite el proceso varias veces
 */
import java.util.Scanner;

public class p49_ParesDescendente {
    public static void main(String[] args) {
        char resp;
        int c, n, s,p,count;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            c = 0;
            n = 0;
            s = 0;
            p = 0;
            count = 0;
            System.out.println("Imprime pares de forma descendente de n hasta 2\n");
            System.out.println("Desde donde deseas los pares");
            c = teclado.nextInt();
            while (c >= 2) {
                System.out.printf(" %d, ", c);
                s+=c;
                c -= 2;
                count++;
                p = s/count;
        
            }

            System.out.printf("\nLa suma de los pares desde %d es %d\n", n, s);
            System.out.println("\n El promedio de los pares es\n"+p);

            System.out.println("Deseas continuar [S]i o [N]o");
            resp = Character.toUpperCase(teclado.next().charAt(0));

        } while (resp != 'N');
        System.out.println("\nProceso terminado");
        teclado.close();

    }

}