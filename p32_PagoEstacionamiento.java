/**
 * p32_PagoEstacionamiento - Administra el pago de estacionamiento de acuerdo a la zona
 */
import java.util.Scanner;
public class p32_PagoEstacionamiento {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        float pago,total,imp;
        char est;
        Scanner teclado = new Scanner(System.in);
        pago = total = imp = 0;

        System.out.println("\nElige el tipo de estacionamiento ");
        System.out.println("Estacionamiento [N]orte - 3% ");
        System.out.println("Estacionamiento [S]ur - 5% ");
        System.out.println("Estacionamiento [E]ste - 10% ");
        System.out.println("Estacionamiento [O]este - 20% ");
        System.out.println("Elige");
        est = Character.toUpperCase(teclado.next().charAt(0));

        switch (est) {
            case 'N': imp = 0.03f; break;
            case 'S': imp = 0.05f; break;
            case 'E': imp = 0.10f; break;
            case 'O': imp = 0.20f; break;
        
            default: System.out.println("Error");
                break;
        }

        System.out.println("Cuanto pagaste? :"); pago = teclado.nextFloat();
        //total = pago * (1 + imp);
        total = (pago * imp) + pago;
        System.out.printf("Pagaste %.2f y un impuesto de %.2f , en total pagaste %.2f",pago,imp,total);
        
    }

    
}