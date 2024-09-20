/**
 * p78_MedidasLongitud - un programa con dos funciones una que convierta pulgadas a centímetros y otra que convierta de metros a
pies. Deberá́ mostrar un menú́ con las opciones correspondientes.
 */
import java.util.Scanner;

public class p78_MedidasLongitud {

    // Función para convertir pulgadas a centímetros
    public static double pulgadasACentimetros(double pulgadas) {
        return pulgadas * 2.54;
    }

    // Función para convertir metros a pies
    public static double metrosAPies(double metros) {
        return metros * 3.281;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.print("\033[H\033[2J"); // Limpiar pantalla (solo en algunos sistemas)
        System.out.flush();

        do {
            // Mostrar el menú
            System.out.println("=== Menú de Conversión ===");
            System.out.println("1. Convertir pulgadas a centímetros");
            System.out.println("2. Convertir metros a pies");
            System.out.println("3. Salir");
            System.out.print("Elige una opción (1-3): ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Conversión de pulgadas a centímetros
                    System.out.print("Ingresa el valor en pulgadas: ");
                    double pulgadas = scanner.nextDouble();
                    double centimetros = pulgadasACentimetros(pulgadas);
                    System.out.println(pulgadas + " pulgadas equivalen a " + centimetros + " centímetros.");
                    break;

                case 2:
                    // Conversión de metros a pies
                    System.out.print("Ingresa el valor en metros: ");
                    double metros = scanner.nextDouble();
                    double pies = metrosAPies(metros);
                    System.out.println(metros + " metros equivalen a " + pies + " pies.");
                    break;

                case 3:
                    // Salir del programa
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 3.");
                    break;
            }
            System.out.println(); // Espacio entre iteraciones

        } while (opcion != 3);

        scanner.close();
    }
}
