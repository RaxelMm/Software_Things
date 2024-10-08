package p109_FormaV2;

public class App {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        Circulo c1 = new Circulo("Azul", false, 5.8);
        Circulo c2 = new Circulo("Verde", true, 10.4);
        Rectangulo r1 = new Rectangulo("Amarillo", false, 25, 18);
        Rectangulo r2 = new Rectangulo("Naranja", true, 37.3, 50.2);


        System.out.println("Todas las formas :");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(r1.toString());
        System.out.println(r2.toString());

        System.out.println("Calculando áreas y perimetros de las figuras:");
        System.out.println("La forma es un circulo");
        System.out.println("El area es "+c1.getArea());
        System.out.println("El perimetro es "+c1.getPerimetro());
        System.out.println("La forma es un Circulo");
        System.out.println("El area es "+c2.getArea());
        System.out.println("El perimetro es "+c2.getPerimetro());
        System.out.println("La forma es un rectangulo");
        System.out.println("El area es "+r1.getArea());
        System.out.println("El perimetro es "+r1.getPerimetro());
        System.out.println("La forma es un rectangulo");
        System.out.println("El area es "+r2.getArea());
        System.out.println("El perimetro es "+r2.getPerimetro());



    

        
    }

}
