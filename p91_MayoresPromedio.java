/**
 * p91_MayoresPromedio 
 */
import java.util.Scanner;
public class p91_MayoresPromedio {
    public static void Mostrar (int[] x){
        for(int i = 0; i<x.length ; i++)
            System.out.print(x[i] + " ");
        System.out.println();
    }
    public static int Suma (int[]x){
        int suma = 0;
        for(int i = 0; i<x.length ; i++)
            suma+=x[i];
        return suma;
    }
    

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Scanner teclado = new Scanner(System.in);
        System.out.print("¿Cuántas calificaciones desea ingresar?: ");
        int n = teclado.nextInt();

        // Crear un arreglo de tamaño n
        int[] calificaciones = new int[n];

        // Bucle para ingresar los datos en el arreglo
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el elemento " + (i + 1) + ": ");
            calificaciones[i] = teclado.nextInt();
    }
    System.out.println("los datos del arreglo son ");
    Mostrar(calificaciones);
    int promedio = Suma(calificaciones)/n;

    System.out.println("El promedio de sus calificaciones es "+promedio);
    System.out.println("Elementos mayores al promedio:");
        int contador = 0;
        for (int i = 0; i < n; i++) {
            if (calificaciones[i] > promedio) {
                System.out.print(calificaciones[i] + " ");
                contador++;
            }
        }
        System.out.println(); // Salto de línea
        System.out.println("Cantidad de elementos mayores al promedio: " + contador);
        teclado.close();

    

    
}
}