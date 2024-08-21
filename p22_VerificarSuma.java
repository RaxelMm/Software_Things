/**
 * p22_VerificarSuma - Veriificar si la suma de n1 n2 es igual a un n3
 */
import java.util.Scanner;
public class p22_VerificarSuma {
    public static void main(String[] args) {
        int n1,n2,n3;
        Scanner teclado = new Scanner(System.in);
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola

        System.out.println("\nVerificando si la suma de dos numeros es igual a un tercero");
        System.out.println("Dame un numero 1"); n1 = teclado.nextInt();
        System.out.println("Dame un numero 2"); n2 = teclado.nextInt();
        System.out.println("Dame un numero 3"); n3 = teclado.nextInt();

        if (n1+n2 == n3) {
            System.out.println("son iguales");
            System.out.println(n1+" + "+n2+" = "+n3);
        }    
        else 
        {
            System.out.println("son distintos");
            System.out.println(n1+" + "+n2+" = "+n3);

        }




        
    }

    
}