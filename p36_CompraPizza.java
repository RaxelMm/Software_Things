/**
 * p36_CompraPizza - Determinar el precio de una pizza dada la compra
 */
import java.util.Scanner;

public class p36_CompraPizza {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char tamaño;
        float total, descuento, precio, pago;
        
        // Borra la pantalla de la consola
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 

        // Mensaje de selección de pizza
        System.out.println("Deme el tamaño de la pizza y cuantas quiere comprar");
        System.out.println("Chica [C] - 5$ ");
        System.out.println("Mediana [M] - 10$ ");
        System.out.println("Grande [G] - 20$ ");
        tamaño = Character.toUpperCase(teclado.next().charAt(0));

        // Determinar el precio basado en el tamaño de la pizza
        switch (tamaño) {
            case 'C':
                precio = 5;
                break;
            case 'M':
                precio = 10;
                break;
            case 'G':
                precio = 20;
                break;
            default:
                System.out.println("Error: Tamaño de pizza no válido.");
                teclado.close();
                return; // Salir del programa si la entrada no es válida
        }

        // Solicitar la cantidad de pizzas
        System.out.println("¿Cuántas quieres comprar?");
        pago = teclado.nextFloat();
        
        // Calcular el total
        total = precio * pago;

        // Aplicar descuento si es necesario (aquí se asume un descuento del 15% como ejemplo)
        if (total > 2000) {
            descuento = total * 0.15f; // 15% de descuento
            total = total - descuento;
            System.out.println("El total de su comprar es de "+ total + " se le aplico un 15 % de descuento");
        }else{
            System.out.println("El total de su compra es "+total+" no se aplica descuento ");
        }
        


        
       

        // Cerrar el Scanner
        teclado.close();
    }
}
