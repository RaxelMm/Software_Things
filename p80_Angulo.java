/**
 * p80_Angulo
 */
import java.util.Scanner;

public class p80_Angulo {

    // Función que determina el tipo de ángulo según el valor dado
    public static String tipoDeAngulo(int angulo) {
        if (angulo < 90) {
            return "Agudo";
        } else if (angulo == 90) {
            return "Recto";
        } else if (angulo > 90 && angulo < 180) {
            return "Obtuso";
        } else if (angulo == 180) {
            return "Llano";
        } else if (angulo > 180 && angulo < 360) {
            return "Cóncavo";
        } else if (angulo == 360) {
            return "Completo";
        } else {
            return "Ángulo no válido";  // Esta línea no debería alcanzarse debido a la validación previa
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\033[H\033[2J"); // Limpiar pantalla (solo en algunos sistemas)
        System.out.flush();

        // Solicitar el valor del ángulo
        System.out.print("Ingresa un ángulo entre 0 y 360 grados: ");
        int angulo = scanner.nextInt();

        // Validar que el ángulo esté en el rango válido
        if (angulo >= 0 && angulo <= 360) {
            // Llamar a la función para determinar el tipo de ángulo
            String tipoAngulo = tipoDeAngulo(angulo);
            System.out.println("El ángulo es: " + tipoAngulo);
        } else {
            System.out.println("Ángulo no válido. Debes ingresar un ángulo entre 0 y 360 grados.");
        }

        scanner.close();
    }
}
