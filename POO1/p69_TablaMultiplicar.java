/**
 * p69_TablaMultiplicar - imprime la tabla de multiplicar que el usuario decida
 */
import java.util.Scanner;

public class p69_TablaMultiplicar {
    public static void Tabla(int tabla,int limite){
        for( int i = 1; i<=limite;i++){
            System.out.printf("%d x %d = %d\n",tabla,i,tabla*i);
            System.out.println();
        }
    }
    public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    System.out.print("\033[H\033[2J");
    System.out.println("Que tabla quieres"); int tabla = teclado.nextInt();
    System.out.println("Hasta donde"); int lim = teclado.nextInt();
    //Tabla(1,10);
    Tabla(tabla, lim);
    teclado.close();
    
        
    }

    
}