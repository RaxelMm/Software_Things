import java.util.Scanner;

/**
 * p63_SumaTerminos1 - Se desea imprimir la secuencia de términos armónicos el número de renglones que el usuario desee y su suma:
 */


public class p63_SumaTerminos1 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); // Limpiar pantalla (solo en algunos sistemas)
        System.out.flush();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos términos?");
        int n = scanner.nextInt();
        
        float suma = 0; // Almacena la suma de los términos
        System.out.print("Secuencia: ");
        
        for (int i = 1; i <= n; i++) {
            // Sumar el valor armónico
            suma += 1.0 / i;

            // Imprimir el término actual
            if (i == 1) {
                System.out.print("1");
            } else {
                System.out.print(" + 1/" + i);
            }
        }
        
        // Imprimir la suma
        System.out.printf("\nSuma: %.6f\n", suma);
    }
}
