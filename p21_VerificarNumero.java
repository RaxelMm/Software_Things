/**
 * p21_VerificarNumero -Verificar si un numero es positivo o negativo o cero
 */
import java.util.Scanner;
public class p21_VerificarNumero {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        
        System.out.println("Verificando si un numero es postivio o negativo o cero \n");
        System.out.println("Dame un numero entero?");
        int numero = new Scanner(System.in).nextInt();

        if (numero>0) System.out.println("El numero "+numero+" es positivo");
        if (numero<0) System.out.println("El numero "+numero+" es negativo");
        if (numero==0) System.out.println("El numero "+numero+" es cero");

        System.out.println("\nGracias por usar este sistema tan sotisficado \n");
   
    }

    
}