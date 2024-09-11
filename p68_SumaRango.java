/**
 * p68_SumaRango - Suma un rango de valores enteros defindidos por el usuario
 */
import java.util.Scanner;
public class p68_SumaRango {
    public static int SumaRango(int ini,int fin){
        int suma = 0;
        for (int i = ini ; i<=fin; i++){
            suma = suma + i;
        }
        return suma;
    } 
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        int fin,ini,suma=0;
        do{
            System.out.println("Dame el inicio"); ini = teclado.nextInt();
            System.out.println("Dame el fin");   fin = teclado.nextInt();


        }while(ini>fin);
 
        
        suma = SumaRango(ini, fin);
      
        System.out.println("\nLa suma del rango es " + suma);
        teclado.close();

        
    }

    
}