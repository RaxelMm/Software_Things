//p04_PagaTrabajador - Calcular la paga de un trabajador
import java.util.Scanner;

public class p04_PagaTrabajador {
    public static void main(String[] args) {
        String nombre;
        int horas;
        double paga,tasa,impuesto,pagabruta,paganeta;
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n Calculando paga de un trabajador\n");
        //Entrada
        System.out.print("Dame nombre del trabajador: ");
        nombre=teclado.nextLine();
        System.out.print("Horas Trabajadas: ");
        horas=teclado.nextInt();
        System.out.println("Paga por hora:  ");
        paga=teclado.nextInt();
        tasa=0.03;
        //Proceso
        pagabruta = horas * paga;
        impuesto = pagabruta * tasa;
        paganeta = pagabruta - impuesto;
        //Salida
        System.out.println(String.format("El trabajador %s trabajo %d horas con una paga de %2.f pesos y una tasa de %2.f",nombre,horas,paga,tasa));
        System.out.println(String.format("paga bruta   : %.2f",pagabruta));
        System.out.println(String.format("Impuesto     : %.2f",impuesto));
        System.out.println(String.format("paga neta    : %.2f",paganeta));








        
    }

    
}
