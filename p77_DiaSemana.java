/**
 * p77_DiaSemana
 */
import java.util.Scanner;

public class p77_DiaSemana {

    // Función que devuelve el día de la semana según el número
    public static String obtenerDiaSemana(int dia) {
        switch (dia) {
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miércoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sábado";
            case 7:
                return "Domingo";
            default:
                return "Número inválido. Debe estar entre 1 y 7.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\033[H\033[2J"); // Limpiar pantalla (solo en algunos sistemas)
        System.out.flush();

        // Solicitar un número entero entre 1 y 7
        System.out.print("Ingresa un número entero entre 1 y 7: ");
        int numero = scanner.nextInt();

        // Validar que el número esté entre 1 y 7
        if (numero >= 1 && numero <= 7) {
            // Llamar a la función y mostrar el día de la semana correspondiente
            String diaSemana = obtenerDiaSemana(numero);
            System.out.println("El día de la semana es: " + diaSemana);
        } else {
            System.out.println("Número inválido. Debes ingresar un número entre 1 y 7.");
        }

        scanner.close();
    }
}
