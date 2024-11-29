/**
 * p38_AceptarEstudiante -Dado el nombre del estudiante, sexo (h/m), su edad y tres calificaciones, decidir si el estudiante es aceptado. La
Universidad Kitty Kat SA es solo para mujeres mayores de 21 años con un promedio de entre 8 y 9.5.
 */
import java.util.Scanner;
public class p38_AceptarEstudiante {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char sexo;
        String nombre;
        int edad,cal1,cal2,cal3,promedio;
         // Borra la pantalla de la consola
         System.out.print("\033[H\033[2J"); 
         System.out.flush(); 
        System.out.println("Bienvenido a la Universidad Kitty Kat SA");
        System.out.println("Cual es su nombre ? ");
        nombre = teclado.nextLine();
        System.out.println("Deme su edad");
        edad = teclado.nextInt();
        System.out.println("Deme su sexo [H] o [M] :");
        sexo = Character.toUpperCase(teclado.next().charAt(0));
        System.out.println("Deme sus 3 calificaciones");
        cal1=teclado.nextInt();
        cal2=teclado.nextInt();
        cal3=teclado.nextInt();
        promedio=(cal1+cal2+cal3)/3;

        if (sexo == 'M' && promedio >= 8 && promedio <= 10 && edad >18) {
            System.out.println("Bienvenida " + nombre + " a la universidad usted ha sido admitida correctamente");
            
        }else if (edad<18 && sexo == 'M'){
            System.out.println("Bienvenida "+ nombre + " usted no puede entrar a esta universidad por su edad ");
        }else if (promedio<8 && sexo == 'M'){
            System.out.println("Bienvenida "+ nombre + " usted no puede entrar a esta universidad por su promedio ");
            
        }else {
            System.out.println("Bienvenido "+ nombre + " usted no puede entrar a esta universidad por su sexo ");
        
    
        }
        teclado.close();






    }

    
}