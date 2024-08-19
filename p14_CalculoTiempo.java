/**
 * p14_CalculoTiempo - Dada una cantidad en horas, calcular su equivalente en días, minutos y segundos.
 */
import java.util.Scanner;

public class p14_CalculoTiempo {
    public static void main(String[] args) {
        int horas,minutos,segundos,dias;

        Scanner teclado = new Scanner(System.in);

        System.out.println("\nDada una cantidad en horas, calcular su equivalente en días, minutos y segundos,\n");
        System.out.println("Dame las horas; ");
        horas = teclado.nextInt();
        minutos = horas * 60;
        segundos = horas * 3600;
        dias = horas / 24;

        System.out.println("La Cantidad de horas de : "+horas+" equivale a "+minutos+" minutos "+segundos+" segundos y "+ dias+" dias ");





    


    }

    
}