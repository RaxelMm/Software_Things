package p117_FiguraGeometrica;

public class App {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borra pantalla de la consola

        Circulo mCirculo= new Circulo(100);
        System.out.println("Probando circulo");
        System.out.println(mCirculo);
        mCirculo.ajustar(0.3);
        System.out.println(mCirculo);

        Rectangulo mRectangulo = new Rectangulo(50, 100);
        System.out.println("Probando rectangulo");
        System.out.println(mRectangulo);
        mRectangulo.ajustar(0.3);
        System.out.println(mRectangulo);

    }

}
