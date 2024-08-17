//p07_OperacionesAsignacion - Efectua diferentes operadores de asigancion
import java.util.Scanner;

public class p07_OperacionesAsignacion {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola

        System.out.println("Dame un numero entero :");
        float num = new Scanner(System.in).nextFloat();

        System.out.printf("El numero original : %.2f\n", num);
        System.out.printf("Incrementar en 1     : %.2f\n", ++num);
        System.out.printf("sumar 80    : %.2f\n", num+=80); 
        System.out.printf("restar 35    : %.2f\n", num-=35);
        System.out.printf("Multiplicar por 15    :%.2f\n", num*=15);
        System.out.printf("Dividir entre 4    :%.2f\n", num/=4);
        System.out.printf("Decrementar en 1   :%.2f\n", --num);



        
        
    }
    
}
