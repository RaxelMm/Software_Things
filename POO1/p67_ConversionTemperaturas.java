/**
 * p67_ConversionTemperaturas - Convierte en grados Celsius a Farenheitt y viceversa usando funciones
 */
import java.util.Scanner;

public class p67_ConversionTemperaturas {
    public static float CaF(float temp){
        return (temp*9.0f/5.0f)+32;
    }
    public static float FaC (float temp){
        return (temp-32)*5.0f/9.0f;

    }
    public static void main(String[] args) {
        int op;
        float temp;
        Scanner teclado = new Scanner(System.in);

        do{
        System.out.print("\033[H\033[2J");


        System.out.println("Conversion de temperaturas");
        System.out.println("1.C a F\n2.F a c\n3.Salir");
        System.out.println("Elige: "); op = teclado.nextInt();
        switch (op) {
            case 1:
                System.out.println("Convertir de C a F");
                System.out.print("Dame la temperatura");
                temp=teclado.nextFloat();

                System.out.println("El resultado es: "+CaF(temp));
                
                break;
            case 2:
            System.out.println("Convertir de C a F");
            System.out.print("Dame la temperatura: ");
            temp=teclado.nextFloat();
            System.out.println("El resultado es: "+FaC(temp));
                
                break;
            case 3:
            System.out.println("Gracias por usar el programa");
                
                break;
        
            default:
                break;
        }
        
            System.out.println("\n<Presiona cualquier tecla para continuar>");teclado.nextLine();teclado.nextLine();
        }while ( op!=3);
        System.out.println("Fin");
        teclado.close();;

        
    }

    
}