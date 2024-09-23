/**
 * p88_Aletorios - Genera numeros aleatorios
 */
import java.util.Random;
public class p88_Aletorios {
    public static void main(String[] args) {
        Random rnd = new Random();
        int a1 = rnd.nextInt();
        int a2 = rnd.nextInt(30)+1;
        int min = 10;
        int max = 30;
        int a3 = rnd.nextInt(max - min + 1)+min;
        System.out.print("\033[H\033[2J");

        System.out.println("Numero entero aletorio postivo"+Math.abs(a1));
        System.out.println("Numero entero aletorio 1 ..30 "+Math.abs(a2));
        System.out.println("Numero entero aletorio 10..30 "+Math.abs(a3));
    }
    
}