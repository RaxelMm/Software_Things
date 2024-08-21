/**
 * p24_PagaTrabajadorv2 -  Calcula paga de un trabajador , horas extras se pagan doble
 */
import java.util.Scanner;
public class p24_PagaTrabajadorv2 {
    public static void main(String[] args) {
        String nombre;
        int horas,extra;
        float paga , impuesto ,tasa,pagabruta,paganeta;
        Scanner teclado = new Scanner(System.in);

        tasa = 0.02f;
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borra pantalla de la consola
        
        System.out.println("\nCalculando la paga de un trabajador , las horas extra se pagan al doble");
        System.out.print("Dame tu nombre "); nombre = teclado.nextLine();
        System.out.print("horas trabajadas "); horas = teclado.nextInt();
        System.out.print("Paga x hora "); paga = teclado.nextFloat();

        if (horas > 40) {
           extra = horas - 40 ;
           pagabruta = 40 + paga + ( extra + paga *2);
            
        } else {
            pagabruta = horas * paga;   
    }
    impuesto = pagabruta * tasa;
    paganeta = pagabruta - impuesto;

    System.out.printf("El trabajador %s trabajo %d horas a una paga de %.2f pesos, a una tasa de  %.2f\n",nombre,horas,paga,tasa);
    System.out.println("Paga bruta = "+pagabruta);
    System.out.println("Impuesto = "+impuesto);
    System.out.println("Paga neta = "+paganeta);





    
}
}