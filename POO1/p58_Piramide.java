/**
 * p58_Piramide - Crear o imprimir una piramide de n renglones del caracter deseado
*/
import java.util.Scanner;
public class p58_Piramide {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borrar pantalla de la consola
        Scanner teclado = new Scanner(System.in);
        System.out.println("De cuantos renglones "); int r = teclado.nextInt();
        System.out.println("De que caracter "); char c = teclado.next().charAt(0);

        for(int i = 1 ; i<=r ; i++){
            for(int j = 1 ; j <= i ; j++)
                System.out.print(c);
            
                
            System.out.println();

        }
        teclado.close();
            
    
        
    }

    
}