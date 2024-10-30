import java.util.InputMismatchException;
import java.util.Scanner;

public class p129_ExcepcionDu {
    public static void main(String[] args) {
        System.out.flush(); // Borrar pantalla de la consola

        Scanner scanner = new Scanner(System.in);
        int numeroNinos = 0;
        int cantidadDulces = 0;

        while (true) {
            try {
                System.out.print("Número de niños en el barrio: ");
                numeroNinos = scanner.nextInt();

                if (numeroNinos < 0) {
                    System.out.println("El número de niños debe ser positivo.");
                    continue; // Repetir el ciclo si es negativo
                }

                break; // Salir del ciclo si la entrada es válida

            } catch (InputMismatchException e) {
                System.out.println("Los niños y los dulces, deben ser cantidades numéricas");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }

        while (true) {
            try {
                System.out.print("Cantidad de dulces existentes: ");
                cantidadDulces = scanner.nextInt();

                if (cantidadDulces < 0) {
                    System.out.println("La cantidad de dulces debe ser positiva.");
                    continue; // Repetir el ciclo si es negativo
                }

                break; // Salir del ciclo si la entrada es válida

            } catch (InputMismatchException e) {
                System.out.println("Los niños y los dulces, deben ser cantidades numéricas");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }

        try {
            if (cantidadDulces == 0) {
                throw new ArithmeticException(); // Lanzar excepción si no hay dulces
            }

            int dulcesPorNino = cantidadDulces / numeroNinos;

            System.out.printf("A cada niño le tocan %d dulces.\n", dulcesPorNino);
        } catch (ArithmeticException e) {
            System.out.println("Si no hay dulces, no puedo repartir dulces.");
        } finally {
            scanner.close();
        }
    }
}
