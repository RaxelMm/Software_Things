/**
 * p53_NumerosNa1
 */
import java.util.Scanner;
public class p53_NumerosNa1 {
    public static void main(String[] args) {
        int j,n,p;
        Scanner teclado = new Scanner(System.in);
        System.out.print("\033[H\033[2J"); System.out.flush();
        System.out.println("Desde donde deseas descender");
        n=teclado.nextInt();
        System.out.println("En decrementos de ");
        p=teclado.nextInt();
        

        for(j=n;j>=1;j-=p)
            System.out.print(j + " ");



        
    }

    
}