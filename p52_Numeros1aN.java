/**
 * p52_Numeros1aN
 */
import java.util.Scanner;
public class p52_Numeros1aN {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Hasta donde quiere llegar"); int n = new Scanner(System.in).nextInt();
        System.out.println("en incrementos de -?"); int p = new Scanner(System.in).nextInt();
        for(int i = 1 ; i<=n ; i+=p)
            System.out.print(i + " ");



    }


}