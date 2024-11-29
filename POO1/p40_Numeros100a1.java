/**
 * p40_Numeros100a1 - imprimir numeros de 100 a 1
 */
import java.util.Scanner;
public class p40_Numeros100a1 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush();

        System.out.println("Imprimiendo numeros de n a 1");
        System.out.println("desde donde descendemos");
        int c = new Scanner(System.in).nextInt();
        System.out.println("de cuanto en cuanto");
        int d = new Scanner(System.in).nextInt();
        




        while (c>=1) {
            System.out.printf( "%d ",c);
            c = c - d;
            
        }

        System.out.println("\nel ciclo ha terminado");
        
    }

    
}
