/**
 * p11_CalcularAngulo - Calculara el tercer angulo de un triangulo dados los primeros 2 
 *
 */
import java.util.Scanner;
public class p11_CalcularAngulo {
    public static void main(String[] args) {
            int angulo1, angulo2;
            double angulo3;
            Scanner teclado = new Scanner(System.in);
    
            System.out.println("\n Calculando tercer angulo de un triangulo dados 2 angulos\n");
            System.out.println("Dame el angulo 1 :");
            angulo1 = teclado.nextInt();
            System.out.println("Dame el angulo 2 :");
            angulo2 = teclado.nextInt();
            angulo3=180-(angulo1+angulo2);
            System.out.println(" El angulo 1 de : "+angulo1+" y con otro de: "+angulo2+" el angulo 3 vale : "+angulo3);
    }

    
}   