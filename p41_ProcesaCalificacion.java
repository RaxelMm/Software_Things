/**
 * p41_ProcesaCalificacion 
 */
import java.util.Scanner;
public class p41_ProcesaCalificacion {
    public static void main(String[] args) {
        int n,c;
        float cal, suma = 0 , prom = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.print("\033[H\033[2J"); System.out.flush();


        System.out.println("Calcula la suma  y el promedio de n calificaciones");
        System.out.print("cuantas calificaciones "); n = teclado.nextInt();
        c = 1;
        
        while (c<=n) {
            System.out.printf("Calificacion %d = \n",c);
            cal = teclado.nextFloat();
            suma = suma + cal;
            c++;
            
        }
        prom = suma / n;
        System.out.printf(" La suma es   :  %.2f\n", suma);
        System.out.printf("el promedio es:  %.2f\n",prom);
        
    }

    
}