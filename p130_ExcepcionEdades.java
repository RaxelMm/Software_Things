import java.util.InputMismatchException;
import java.util.Scanner;

public class p130_ExcepcionEdades {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        

        Scanner scanner = new Scanner(System.in);
        int[] edades = new int[5];

        System.out.println("Captura las edades de 5 personas:");

        for (int i = 0; i < 5; i++) {
            while (true) {
                try {
                    System.out.print("Edad persona " + (i + 1) + ": ");
                    edades[i] = scanner.nextInt();
                    break; // Salir del ciclo si la entrada es válida
                } catch (InputMismatchException e) {
                    System.out.println("Introduce un número entero");
                    scanner.next(); // Limpiar el buffer del scanner
                }
            }
        }

        System.out.print("Captura terminada, las edades son: ");
        for (int edad : edades) {
            System.out.print(edad + " ");
        }
        System.out.println(); // Nueva línea al final

        scanner.close();
    }
}
