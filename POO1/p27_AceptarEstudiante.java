
/**
 * p27_AceptarEstudiante - Acepta un estudiante en base a su edad y dos calificaciones
 */
import java.util.Scanner;

public class p27_AceptarEstudiante {
    public static void main(String[] args) {
        String nombre;
        int edad;
        double c1, c2;
        Scanner teclado = new Scanner(System.in);

        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borra pantalla de la consola
        System.out.println("\nUniversidad Patito SA de CV\nSistema de admision\n");
        System.out.println("Dame tu nombre ?");
        nombre = teclado.nextLine();
        System.out.println("Dame tu edad   ?");
        edad = teclado.nextInt();

        if (edad < 18) {
            System.out.println("No aceptamos menores de 18 años en esta Universidad");
        } else {
            System.out.println("Dame Calificacion 1 ?");
            c1 = teclado.nextDouble();
            System.out.println("Dame Calificacion 2 ?");
            c2 = teclado.nextDouble();
            if (c1 < 8 || c2 < 8)
                System.out.printf("Lo siento %s, No tienes el promedio para estar en esta universidad",nombre);
            else
                System.out.printf("Hola %s, Bienvenid@ a esta universidad, sientete como en tu casa", nombre);
        }

        System.out.println("\nGracias por utilizar este sistema");
    }

}