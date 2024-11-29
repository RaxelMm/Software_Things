import java.util.InputMismatchException;
import java.util.Scanner;

// Excepción personalizada
class TemperaturaExcesiva extends Exception {
    public TemperaturaExcesiva(String mensaje) {
        super(mensaje);
    }
}

public class p131_ExcepcionTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperaturaC = 0;

        while (true) {
            try {
                System.out.print("Dame una temperatura en centígrados: ");
                temperaturaC = scanner.nextDouble();
                
                // Verificar si la temperatura excede los 100 grados
                if (temperaturaC > 100) {
                    throw new TemperaturaExcesiva("Temperatura demasiado alta, no se puede convertir");
                }

                // Convertir a Fahrenheit y mostrar el resultado
                double temperaturaF = convertirACelsiusAFahrenheit(temperaturaC);
                System.out.printf("%.2f grados centígrados, equivale a %.2f grados Fahrenheit\n", 
                                  temperaturaC, temperaturaF);
                break; // Salir del bucle si la conversión fue exitosa
                
            } catch (InputMismatchException e) {
                System.out.println("La temperatura a convertir, debe ser un valor numérico");
                scanner.next(); // Limpiar el buffer del scanner
            } catch (TemperaturaExcesiva e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Método para convertir Celsius a Fahrenheit
    public static double convertirACelsiusAFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
}
