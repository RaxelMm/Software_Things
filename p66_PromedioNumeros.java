/**
 * p66_PromedioNumeros . Calcular el promedio de 3 numeros usando una funcion
 */
import java.util.Scanner;
public class p66_PromedioNumeros {
    public static float Promedio(float num1 , float num2,float num3){
        float suma,prom;
        suma = num1+num2+num3;
        prom=suma/3;
        return prom;

        
    }
    public static void main(String[] args) {
            System.out.print("\033[H\033[2J");
            Scanner teclado = new Scanner(System.in);
            System.out.println("Dados 3 numeros flotantes, obtener su promedio");
            System.out.println("Dame num 1"); float num1=teclado.nextInt();
            System.out.println("Dame num 2"); float num2=teclado.nextInt();
            System.out.println("Dame num 3"); float num3=teclado.nextInt();
            float prom = Promedio(num1, num2, num3);

            //float prom = Promedio(9.5f, 9.0f, 7.2f);
            System.out.println("El promedio es " + prom);
            teclado.close();

            //System.out.println("El promedio es " + Promedio(10, 10, 10));
        
        
    }

    
}