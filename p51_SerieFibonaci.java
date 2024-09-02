/**
 * p51_SerieFibonaci - Se desean imprimir los primeros n números de la será de Fibonacci.
 */
import java.util.Scanner;

public class p51_SerieFibonaci {
    public static void main(String[] args) {
        char resp;
        int n, i, f, c, d;
        
        Scanner teclado = new Scanner(System.in);

        do {
            // Limpiar la pantalla
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            System.out.println("Serie Fibonacci");
            System.out.println("¿Hasta dónde quieres la Serie Fibonacci?");
            n = teclado.nextInt();
            
            // Inicializar los primeros dos términos
            f = 0;
            c = 1;
            i = 0;

            System.out.print("Los primeros " + n + " términos de la sucesión Fibonacci son: ");
            
            while (i < n) {
                System.out.print(f + " ");
                
                // Calcular el siguiente término
                d = f + c;
                f = c;
                c = d;
                
                i++;  // Incrementar el contador
            }
            
            System.out.println("\n¿Deseas continuar? [S]i o [N]o");
            resp = Character.toUpperCase(teclado.next().charAt(0));
        } while (resp != 'N');
        
        teclado.close();
    }
}


    
