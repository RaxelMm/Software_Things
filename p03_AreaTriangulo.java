//p02_AreaTriangulo - Calcular area de un Triangulo

import java.util.Scanner;

public class p03_AreaTriangulo {
    public static void main(String[] args) {
        int base, altura;
        double area;
        Scanner teclado = new Scanner(System.in);

        System.out.println("\n Calculando area de un triangulo\n");
        System.out.println("Dame la base");
        base = teclado.nextInt();
        System.out.println("Dame la altura");
        altura = teclado.nextInt();
        area=(base*altura)/2;
        System.out.println(" El area del triangulo con base "+base+" y de altura "+altura+" el area es 5"+area);

        


        
    }
    
}
