import java.util.InputMismatchException;
import java.util.Scanner;

public class p123_Excepcion3 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borrar pantalla de la consola
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.print("Valor del numerador: "); int a = teclado.nextInt();
            System.out.print("Valor del denominador: "); int b = teclado.nextInt();
            int c = a/b;
    
            System.out.print("El resultado es: "+c);
            
        } catch (InputMismatchException e) {
            System.out.println("Tanto el numerador como el denominador deben ser numeros");
        } catch (ArithmeticException e ){
            System.out.println("No se puede dividir entre cero");

        }finally{
            System.out.println("\nNo importa");
        }

        teclado.close();
        }
    }
    

