/**
 * p34_NumeroMayor - Verificar entre 3 numeros enteros cual es mayor
 */

 import java.util.Scanner;
public class p34_NumeroMayor {
    public static void main(String[] args) {
        int n1,n2,n3;
        Scanner teclado = new Scanner(System.in);

        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        System.out.println("Dame 3 numeros y te dira cual es el mayor");
        n1 = teclado.nextInt();
        n2 = teclado.nextInt();
        n3 = teclado.nextInt();

        if (n1 > n2 && n1>n3 ) {
            System.out.println("El numero mayor es "+n1);
        } else if (n2>n1 && n2 > n3) {
            System.out.println(" el numero mayor es "+n2);
        } else if (n3>n1 && n3 > n2) {
            System.out.println(" el numero mayor es "+n3);
        } else {
            System.out.println("error");
        }

        teclado.close();





    }

    
}