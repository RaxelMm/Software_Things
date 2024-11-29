
/**
 * p28_LeyDeNewton - Calcula la segunda ley de Newton
 */
import java.util.Scanner;

public class p28_LeyDeNewton {
    public static void main(String[] args) {
        float f, m, a;
        char op;
        Scanner teclado = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borra pantalla de la consola
        System.out.println("Elige lo que deseas calcular");
        System.out.println("[F] = Fuerza (f = m x a)");
        System.out.println("[M] = Masa (m = f / a)");
        System.out.println("[A] = Aceleracion (a = m / f)");
        System.out.println("[S] = Salir del sistema ......");
        System.out.print("Elige una opcion ? ");
        op = teclado.next().charAt(0);
        op = Character.toUpperCase(op);
        f = m = a = 0;

        if (op == 'F') {
            System.out.println("Calculando Fuerza");
            System.out.println("Dame la masa");
            m = teclado.nextFloat();
            System.out.println("Dame la aceleracion");
            a = teclado.nextFloat();
            f = m * a;
            System.out.printf("La fuerza es %.2f\n ", f);
        } else if (op == 'M') {
            System.out.println("Calculando Masa");
            System.out.println("Dame la fuerza");
            f = teclado.nextFloat();
            System.out.println("Dame la aceleracion");
            a = teclado.nextFloat();
            m = f / a;
            System.out.printf("La masa es %.2f\n ", m);
        } else if (op == 'A') {
            System.out.println("Calculando la aceleracion");
            System.out.println("Dame la fuerza");
            f = teclado.nextFloat();
            System.out.println("Dame la masa");
            m = teclado.nextFloat();
            a = f / m;
            System.out.printf("La aceleracion es %.2f\n ", a);
        } else if (op == 'S') {
            System.out.println("Adios");
        } else
            System.out.println("Opcion invalida");

        System.out.println("Bien");

    }

}