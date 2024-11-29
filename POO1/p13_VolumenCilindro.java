// Obtener el volumen de un cilindro dado su altura y radio
import java.util.Scanner;
public class p13_VolumenCilindro {
    public static void main(String[] args) {
        double altura,radio,volumen;
        Scanner teclado = new Scanner(System.in);

        System.out.println("\nCalculando volumen de un cilindro\n");
        System.out.println("Dame la altura ? ");
        altura = teclado.nextDouble();
        System.out.println("Dame el radio :  ");
        radio = teclado.nextDouble();
        volumen = Math.PI * Math.pow(radio,2)*altura;

        System.out.println("\nEl circulo de radio "+radio+ " y altura "+altura+" tiene un volumen de "+volumen+" CM^3");
        
    }

    
}
