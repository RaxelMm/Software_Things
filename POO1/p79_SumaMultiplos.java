/**
 * p79_SumaMultiplos
 */
import java.util.Scanner;

public class p79_SumaMultiplos {

    // Función que suma los múltiplos de 3 o 4 en un rango especificado
    public static int sumaMultiplos(int ini, int fin, int constante) {
        int suma = 0;

        for (int i = ini; i <= fin; i++) {
            if (i % constante == 0) {
                suma += i;
            }
        }

        return suma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.print("\033[H\033[2J"); // Limpiar pantalla (solo en algunos sistemas)
        System.out.flush();
        
        do {
            // Mostrar el menú
            System.out.println("=== Menú de Suma de Múltiplos ===");
            System.out.println("1. Sumar múltiplos de 3 en un rango");
            System.out.println("2. Sumar múltiplos de 4 en un rango");
            System.out.println("3. Salir");
            System.out.print("Elige una opción (1-3): ");
            opcion = scanner.nextInt();

            if (opcion == 1 || opcion == 2) {
                // Solicitar el rango de números
                System.out.print("Ingresa el valor inicial del rango: ");
                int ini = scanner.nextInt();
                System.out.print("Ingresa el valor final del rango: ");
                int fin = scanner.nextInt();

                // Validar que el rango sea válido (ini < fin)
                if (ini >= fin) {
                    System.out.println("Rango no válido. El valor inicial debe ser menor que el valor final.");
                } else {
                    // Realizar la suma de múltiplos dependiendo de la opción elegida
                    int constante = (opcion == 1) ? 3 : 4;
                    int suma = sumaMultiplos(ini, fin, constante);
                    System.out.println("La suma de los múltiplos de " + constante + " entre " + ini + " y " + fin + " es: " + suma);
                }
            } else if (opcion != 3) {
                System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 3.");
            }
            
            System.out.println(); // Espacio entre iteraciones

        } while (opcion != 3);

        System.out.println("Saliendo del programa.");
        scanner.close();
    }
}
