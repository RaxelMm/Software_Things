/**
 * p50_ConversionTemperaturas - calcular la temperatura convertida de grados centígrados a grados farenheit de un rango de valores
introducidos por el usuario
 */
import java.util.Scanner;
public class p50_ConversionTemperaturas {
    public static void main(String[] args) {
        int ini, fin, c;
        float tc = 1.8f;
        char resp;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Tabla de conversion de Centigrados a Farenheit ");
            do {
                System.out.printf("Dame inicio:   ");
                ini = teclado.nextInt();
                System.out.printf("Dame final:    ");
                fin = teclado.nextInt();

            } while (fin < ini);

            c = ini;
            while (c <= fin) {
                System.out.printf("%5dC°         -   %10.2fF°\n", c, (c * tc)+32);
                c++;

            }
            System.out.println("Deseas continuar [S]i o [N]o");
            resp = Character.toUpperCase(teclado.next().charAt(0));
        } while (resp != 'N');
        System.out.println("FIN");
        teclado.close();

        
    }
    

    
}