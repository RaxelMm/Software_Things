/**
 * p42_TablaMultiplicar - Imprime tabla de multiplicar d hasta n
 */
import java.util.Scanner;
public class p42_TablaMultiplicar {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush();
        int t,c,n;
        Scanner teclado = new Scanner(System.in);
        

        System.out.println("imprime la tabla de multiplicar \n");
        System.out.println("Que tabla quieres ?");
        t = teclado.nextInt();
        System.out.println("Hasta donde la quieres");
        n = teclado.nextInt();
        
        //t = 1;
         c = 1;
        while (c<=n) {
            System.out.printf("%d x %d = %d\n",t,c,t*c);
            c++;
            
        }
        
    }

    
}