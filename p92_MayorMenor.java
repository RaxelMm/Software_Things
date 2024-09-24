/**
 * p92_MayorMenor
 */
import java.util.Scanner;
public class p92_MayorMenor {
    public static void Mostrar (int[] x){
        for(int i = 0; i<x.length ; i++)
            System.out.print(x[i] + " ");
        System.out.println();
    }
    public static int Mayor(int[] x) {
        int mayor = x[0]; // Inicializamos con el primer elemento del arreglo
        for (int i = 1; i < x.length; i++) {
            if (x[i] > mayor) {
                mayor = x[i]; // Actualizar el mayor si encontramos uno más grande
            }
        }
        return mayor;
    }
    public static int Menor(int[] x) {
        int menor = x[0]; // Inicializamos con el primer elemento del arreglo
        for (int i = 1; i < x.length; i++) {
            if (x[i] < menor) {
                menor = x[i]; // Actualizar el mayor si encontramos uno más grande
            }
        }
        return menor;
    }


  

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.print("¿Cuántos elementos desea ingresar?: ");
        int n = teclado.nextInt();
        
        // Crear un arreglo de tamaño n
        int[] arreglo = new int[n];

        // Bucle para ingresar los datos en el arreglo
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el elemento " + (i + 1) + ": ");
            arreglo[i] = teclado.nextInt();
    }
    System.out.println("Su arreglo es ");
    Mostrar(arreglo);
    System.out.println("El numero mayor de su arreglo es "+Mayor(arreglo));
    System.out.println("El numero menor de su arreglo es "+Menor(arreglo));
    teclado.close();
    
 
    }

    
}