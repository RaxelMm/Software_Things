
/**
 * p47_ConjeturaCollatz - Imprime numeros de conjetura de collatz
*/
import java.util.Scanner;

public class p47_ConjeturaCollatz {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Imprime numeros de conjetura de collatz \n");
        System.out.println("Dame un entero ?");
        n = new Scanner(System.in).nextInt();

        do {
            System.out.printf("%d ", n);
            if (n % 2 == 0) {
                n /= 2;

            } else {
                n = n * 3 + 1;
            }

        } while (n != 1);
        System.out.printf("%d", n);

    }
}