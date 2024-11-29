/**
 * p59_FactorialNumeros - imprime el factorial de n numeros
 */
import java.util.Scanner;
public class p59_FactorialNumeros {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush();
        System.out.println("Hasta que numero deseas el factorial"); int n = new Scanner(System.in).nextInt();

        for(int i = 1 ; i <= n ; i++ ){
            float f = 1;
            System.out.printf("%d! = ", i );
            for ( int j = 1 ; j<= i; j++) {
                System.out.printf("%d %s ",j,(i==j)? "" : "*");
                f = f * j;
            }

             System.out.printf(" = %f ",f);

                System.out.println();

            
        }
        
    }

    
}