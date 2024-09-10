/**
 * p65_SistemaPapeleria - Una empresa fotocopiadora requiere un programa que le permita llevar el control de su venta de
fotocopias. El valor de la copia es: Carta $3, Oficio $4, Doble Oficio $6, debe mostrarse un
resumen de ventas con un mensaje de acuerdo a la venta total:
 */
import java.util.Scanner;

public class p65_SistemaPapeleria {
    public static void main(String[] args) {
        int cantidad, valor = 0, total = 0, venta = 0;
        int copiasCarta = 0, copiasOficio = 0, copiasDobleOficio = 0;
        char op ='S', copia;

        Scanner teclado = new Scanner(System.in);

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush(); // Borrar pantalla de la consola

            System.out.println("---------------------------------");
            System.out.println("Papelería la Malena, SA. de CV.");
            System.out.println("Sistema de ventas de copias");
            System.out.println("---------------------------------");
            System.out.println("Venta: " + (++venta));  // Incrementar la venta en cada iteración

            // Pedir el tipo de copia
            System.out.println("Tipo de copia (C)arta $3,(O)ficio $4,(D)oble Of $6?");
            copia = Character.toUpperCase(teclado.next().charAt(0));

            // Pedir la cantidad de copias
            System.out.println("Cantidad?");
            cantidad = teclado.nextInt();

            // Asignar el valor dependiendo del tipo de copia
            switch (copia) {
                case 'C':
                    valor = 3;
                    copiasCarta += cantidad; // Acumular copias de tipo Carta
                    break;
                case 'O':
                    valor = 4;
                    copiasOficio += cantidad; // Acumular copias de tipo Oficio
                    break;
                case 'D':
                    valor = 6;
                    copiasDobleOficio += cantidad; // Acumular copias de tipo Doble Oficio
                    break;
                default:
                    System.out.println("Tipo de copia no válido.");
                    continue; // Si el tipo no es válido, continuar con la siguiente venta
            }

            total += valor * cantidad; // Sumar el costo al total de ventas

            // Preguntar si desea realizar otra venta
            System.out.println("Otra venta (S/N)?");
            op = Character.toUpperCase(teclado.next().charAt(0));

        } while (op != 'N');

        // Mostrar el resumen diario de ventas
        System.out.println("---------------------------------------");
        System.out.println("Resumen diario de ventas");
        System.out.println("---------------------------------------");
        System.out.println("Ventas realizadas: " + venta);
        System.out.println("-------------------------");
        System.out.println("Carta : " + copiasCarta + " - $ " + (copiasCarta * 3));
        System.out.println("Oficio : " + copiasOficio + " - $ " + (copiasOficio * 4));
        System.out.println("Doble Of. : " + copiasDobleOficio + " - $ " + (copiasDobleOficio * 6));
        System.out.println("-------------------------");
        System.out.println("Tot. Ventas : " + (copiasCarta + copiasOficio + copiasDobleOficio) + " - $ " + total);

        // Mostrar el mensaje basado en la venta total
        if (total <= 50) {
            System.out.println("Esta venta es una: Venta moderada");
        } else if (total <= 100) {
            System.out.println("Esta venta es una: Venta frecuente");
        } else {
            System.out.println("Esta venta es una: Venta superada");
        }
    }
}



                  
        


        
    