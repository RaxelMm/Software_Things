import java.util.Scanner;

/**
 * p128_ExcepcionRaiz
 */
public class p128_ExcepcionRaiz {
    public static void main(String[] args) {
        System.out.flush(); // Borrar pantalla de la consola

        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Introduce un número: ");
            double numero = scanner.nextDouble();
            
            if (numero < 0) {
                throw new Exception("No puedo calcular la raíz cuadrada de un número negativo.");
            }
            
            double resultado = Math.sqrt(numero);
            System.out.printf("El resultado es: %.2f\n", resultado);
            
        } catch (Exception e) {
            System.out.println("Error no puedo calcular la raíz cuadrada");
        } finally {
            scanner.close();
        }
    }

    
}