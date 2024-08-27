/**
 * p37_CalculoNotas - calcular el promedio de 5 calificaciones introducidas por el usuario, luego evaluar el resultado e imprimir
un mensaje de acuerdo con el promedio obtenido
 */
import java.util.Scanner;
public class p37_CalculoNotas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cal1,cal2,cal3,cal4,cal5;
        int promedio;
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borra pantalla de la consola
        System.out.println("Deme sus calificaciones");
        cal1 = teclado.nextInt();
        cal2= teclado.nextInt();
        cal3 = teclado.nextInt();
        cal4= teclado.nextInt();
        cal5 = teclado.nextInt();
        promedio = (cal1+cal2+cal3+cal4+cal5)/5;
        
        if (promedio>0 && promedio<=6) {
            System.out.println("Quedas reprobado");
            
        } else if (promedio>6 && promedio<=7){
            System.out.println("pasas de pansazo");
        } else if (promedio>7 && promedio<=8){
            System.out.println("Muy bien ,puedes mejorar");
        } else if (promedio>8 && promedio<=9){
            System.out.println("Excelente sigue asi");
        } else if (promedio>9 && promedio<=10){
            System.out.println("Perfecto tu esfuerzo valio la pena");
        } else {
            System.out.println("error");
        }


        

        
        teclado.close();
    }


    
}