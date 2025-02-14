import java.util.Scanner;

public class Libro {
    String titulo;
    String autor;
    int fecha;

    public Libro(String titulo, String autor, int fecha) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public boolean esAntiguo() {
        return this.fecha < 2000;
    }

    
    public static Libro capturarDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();

        System.out.print("Ingrese el año de publicación: ");
        int fecha = scanner.nextInt();

        return new Libro(titulo, autor, fecha);
    }

    public String mostrarInfo() {
        return "Libro [Título=" + titulo + ", Autor=" + autor + ", Fecha=" + fecha + ", Antiguo=" + esAntiguo() + "]";
    }

    public static void main(String[] args) {
        Libro libro = capturarDatos();
        System.out.println(libro.mostrarInfo());
    }
}
