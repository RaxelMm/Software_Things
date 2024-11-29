package p107_Forma;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        //Forma f1 = new Forma("Rojo");No se 
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        
        Circulo c1 = new Circulo("Rojo", 10.22);
        Triangulo t1 = new Triangulo("Azul", 10, 20);
        ArrayList<Forma> forms = new ArrayList<>();


        System.out.println("Circulo");
        System.out.println(c1.toString());

        System.out.println("Triangulo");
        System.out.println(t1.toString());
        forms.add(c1);
        forms.add(t1);
        forms.add(new Circulo("Cafe", 45.50));
        forms.add(new Triangulo("Purpura", 100,300));

        System.out.println("\nFormas del array");
        for (Forma forma : forms){
            System.out.println(forma);
        }
    }

}
