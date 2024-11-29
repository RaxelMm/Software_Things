import java.util.Scanner;

public class p125_Excepcion5 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
            System.out.flush(); // Borrar pantalla de la consola
            
            int a[] = {10,20,30,40};

            System.out.println("Los elementos del arreglo son: ");
            for (int i : a) {
                System.out.print(i + " ");
                
            }
            
            try {
                System.out.println("\nQue posicion del arreglo quieres acceder ? ");
                int pos = new Scanner(System.in).nextInt();
                System.out.println("La posicion es " + pos + ", contiene el valor "+a[pos]);
                
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("No puedo ir alla");

                
            }
    }
    
}
