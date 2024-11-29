//Dado grados Farenheit convertira a Celsius
import java.util.Scanner;
public class p12_ConvertirTemperatura {
    public static void main(String[] args) {
        double gradosf,gradosc;
        Scanner teclado = new Scanner(System.in);

        System.out.println("\nConvirtiendo grados Farenheit a Celsius\n");
        System.out.println("Dame los grados Farenheit: ");
        gradosf = teclado.nextFloat();

        gradosc = (gradosf-32)/1.8;

        System.out.println("\nLos grados farenheit de : "+gradosf+"F equivalen a  "+gradosc+"C");
    }


    
}
