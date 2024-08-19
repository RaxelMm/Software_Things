// Dado una cantidad en pesos convertir a dolares

import java.util.Scanner;

public class p15_ConvertirADolares {
    public static void main(String[] args) {
        int pesos;
        double dolares;
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nDada una cantidad de pesos se convertira a dolares\n");
        System.out.println("Cuantos pesos debe convertir: ");
        pesos = teclado.nextInt();
        dolares = pesos * 0.053;

        System.out.println("La cantidad de "+pesos+" pesos equivale a "+dolares+" $ ");


    
    }
    
}
