/**
 * p76_NumeroMenor - un programa con una función que pida 4 números enteros y devuelva el menor de ellos.
 */
import java.util.Scanner;

public class p76_NumeroMenor {
    
    // Función para obtener el menor de cuatro números
    public static int obtenerMenor(int a, int b, int c, int d) {
        int menor = a;  // Asumimos que el primero es el menor inicialmente
        
        if (b < menor) {
            menor = b;
        }
        if (c < menor) {
            menor = c;
        }
        if (d < menor) {
            menor = d;
        }
        
        return menor;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\033[H\033[2J"); // Limpiar pantalla (solo en algunos sistemas)
        System.out.flush();
        
        // Solicitar 4 números enteros al usuario
        System.out.println("Ingresa 4 números enteros:");
        System.out.print("Número 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Número 2: ");
        int num2 = scanner.nextInt();
        System.out.print("Número 3: ");
        int num3 = scanner.nextInt();
        System.out.print("Número 4: ");
        int num4 = scanner.nextInt();
        
        // Llamar a la función y mostrar el resultado
        int menor = obtenerMenor(num1, num2, num3, num4);
        System.out.println("El menor número es: " + menor);
        
        scanner.close();
    }
}
