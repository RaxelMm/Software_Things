/**
 * p39_Numeros1a100 -imprimir numeros de i a c con while- 
 */
import java.util.Scanner;
public class p39_Numeros1a100 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush();
        int c = 0;
         

        System.out.println("Imprimiendo los numeros de 0 a n");
        System.out.println("Hasta donde ?"); int n = new Scanner(System.in).nextInt();
        System.out.println("En incrementos de  ?"); int h = new Scanner(System.in).nextInt();
        



        while (c<=n) {
            System.out.printf("chilaquil %d\n ",c);
            c = c + h;
        }
        
    }

    
}