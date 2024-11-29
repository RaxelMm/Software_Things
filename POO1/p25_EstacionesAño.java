/**
 * p25_EstacionesAño - Manda un mensaje en base al numero de estacion del año
 */
import java.util.Scanner;
public class p25_EstacionesAño {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borra pantalla de la consola

        System.out.print("\nDame un numero entre 1 y 4 y te dire que estacion del año es: \n");
        int n = new Scanner(System.in).nextInt();


        if (n>=1 && n<=4) {
            System.out.println("chido");
            if(n==1) System.out.println("\nPrimavera");
            if(n==2) System.out.println("\nVerano");
            if(n==3) System.out.println("\nOtoño");
            if(n==4) System.out.println("\nInvierno");
            
        } else 
            System.out.println("Esa estacion  del año no existe !!!");


        
    }

    
}