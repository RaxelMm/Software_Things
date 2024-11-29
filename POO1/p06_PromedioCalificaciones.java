//p06_PromedioCalificaciones - Calcula la suma y el promedio de 3 calificaciones
import java.util.Scanner;
public class p06_PromedioCalificaciones {
    public static void main(String[] args) {
        float cal1,cal2,cal3;
        float suma,promedio,min,max;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Calculando el promedio de 3 calificaciones , tambien la mayor y la menor de ellas : \n");
        System.out.println("Dame la califacion 1 :"); cal1=teclado.nextFloat();
        System.out.println("Dame la califacion 2 :"); cal2=teclado.nextFloat();
        System.out.println("Dame la califacion 3 :"); cal3=teclado.nextFloat();

        suma = cal1 + cal2 + cal3;
        promedio = suma / 3;
        max= Math.max(Math.max(cal1,cal2),cal3);
        min= Math.min(Math.min(cal1,cal2),cal3);

        System.out.printf("\nLos valores de las calificaciones son %.2f,%.2f,%.2f\n",cal1,cal2,cal3);
        System.out.printf("La suma es  :%.2f \n",suma);
        System.out.printf("El promedio es  :%.2f \n",promedio);
        System.out.printf("La Mayor es  :%.2f \n",max);
        System.out.printf("La menor es :%.2f \n",min);
        
        
    }
    
}
