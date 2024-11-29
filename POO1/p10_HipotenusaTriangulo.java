import java.util.Scanner;

/**
 * p10_HipotenusaTriangulo- Dado un triangulo devolvera la hipotenusa
 */
public class p10_HipotenusaTriangulo {
    public static void main(String[] args) {
        int longitud1, longitud2;
        double hipotenusa;
        Scanner teclado = new Scanner(System.in);

        System.out.println("\n Calculando hipotenusa de un triangulo de un triangulo\n");
        System.out.println("Dame la longitud 1:");
        longitud1 = teclado.nextInt();
        System.out.println("Dame la longitud 2:");
        longitud2 = teclado.nextInt();
        hipotenusa=Math.sqrt(longitud1*longitud1+longitud2*longitud2);
        System.out.println(" El area del triangulo con longitud 1 de : "+longitud1+" y de longitud 2 de: "+longitud2+" la hipotenusa es "+hipotenusa);

        
    }

    
}