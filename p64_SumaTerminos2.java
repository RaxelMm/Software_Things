/**
 * p64_SumaTerminos2 - Se desea imprimir la secuencia de términos, el número de renglones que el usuario desee y su suma:
 */
    
    
    import java.util.Scanner;

public class p64_SumaTerminos2 {
    public static void main(String[] args) {
        // Limpiar pantalla (opcional para algunos sistemas)
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos términos?");
        int n = scanner.nextInt();
        
        int suma = 0;
        int numero = 0;  // Para almacenar el número formado por repeticiones del dígito 1
        
        System.out.print("Secuencia: ");
        
        for (int i = 1; i <= n; i++) {
            // Generar el número con i repeticiones del dígito 1
            numero = numero * 10 + 1;
            
            // Sumarlo a la suma total
            suma += numero;
            
            // Imprimir el número actual
            if (i == 1) {
                System.out.print(numero);
            } else {
                System.out.print(" + " + numero);
            }
        }
        
        // Imprimir la suma total
        System.out.println("\nSuma: " + suma);
    }
}
