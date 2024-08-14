//p02_AreaCirculo - Calcular area de un circulo 
import java.util.Scanner;


public class p02_AreaCirculo {
    public static void main(String[] args) {
        double radio,area;
        Scanner teclado = new Scanner(System.in);

        System.out.println("\nCalculando area de un circulo\n");
        System.out.println("Dame el radio ? ");
        radio = teclado.nextFloat();

        area = Math.PI * Math.pow(radio,2);

        System.out.println("\nEl circulo de radio "+radio+" tiene un area de "+area );
    }
    
}
