import java.util.Scanner;

/**
 * p122_Exepcion2
 */
public class p122_Excepcion2 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
            System.out.flush(); // Borrar pantalla de la consola

            
            try {
                System.out.println("Dame un numero");
                int val = new Scanner(System.in).nextInt();
                val = val + 5;
                System.out.println("El nuevo valor es " + val);
                
                
        } catch (Exception e) {
            System.out.println("Debes de introducir un numero entero !!! ");
        }
    }

    
}