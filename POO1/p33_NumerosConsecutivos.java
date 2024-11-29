
/**
 * p33_NumerosConsecutivos - Verificar si 3 numeros son consecutivos
 */

import java.util.Scanner;

public class p33_NumerosConsecutivos {
    public static void main(String[] args) {
        int n1, n2, n3;
        Scanner teclado = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borrar pantalla de la consola

        System.out.println("Ingrese 3 numeros y te dire si son consecutivos");
        n1 = teclado.nextInt();
        n2 = teclado.nextInt();
        n3 = teclado.nextInt();

        if (n2 == n1 + 1 && n3 == n2 + 1) {
            System.out.println("Los números son consecutivos.");
        } else if (n3 == n1 + 1 && n2 == n3 + 1) {
            System.out.println("Los números son consecutivos.");
        } else if (n1 == n2 + 1 && n3 == n1 + 1) {
            System.out.println("Los números son consecutivos.");
        } else if (n3 == n2 + 1 && n1 == n3 + 1) {
            System.out.println("Los números son consecutivos.");
        } else if (n1 == n3 + 1 && n2 == n1 + 1) {
            System.out.println("Los números son consecutivos.");
        } else if (n2 == n3 + 1 && n1 == n2 + 1) {
            System.out.println("Los números son consecutivos.");
        } else {
            System.out.println("Error: los números no son consecutivos.");
        }
        teclado.close();


}

}