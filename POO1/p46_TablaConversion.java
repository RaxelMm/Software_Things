
/**
 * p46_TablaConversion
 */
import java.util.Scanner;

public class p46_TablaConversion {
    public static void main(String[] args) {
        int ini, fin, c;
        float tc = 18.74f;
        char resp;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Tabla de conversion de $ Peso a $$ Dollar ");
            do {
                System.out.printf("Dame inicio:   ");
                ini = teclado.nextInt();
                System.out.printf("Dame final:    ");
                fin = teclado.nextInt();

            } while (fin < ini);

            c = ini;
            while (c <= fin) {
                System.out.printf("%5d$$         -   %10.2f$\n", c, c * tc);
                c++;

            }
            System.out.println("Deseas continuar [S]i o [N]o");
            resp = Character.toUpperCase(teclado.next().charAt(0));
        } while (resp != 'N');
        System.out.println("FIN");
        teclado.close();

    }

}