import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class p138_ArchivoMaterias {

    public static void capturarDatos(ArrayList<String> datos, Scanner teclado) {
        String dato;
        System.out.println("\nIntroduce un dato y presiona ENTER, dato vacío para terminar");
        while (true) {
            dato = teclado.nextLine(); // Usar el Scanner pasado desde main
            if (dato.isEmpty())
                break;
            datos.add(dato);
        }
    }

    public static void grabarDatos(String archivo, ArrayList<String> datos) throws IOException {
        BufferedWriter fdatos = new BufferedWriter(new FileWriter(new File(archivo)));
        for (String dato : datos) {
            fdatos.write(dato + "\n"); // Escribe cada dato en una nueva línea
        }
        fdatos.close(); // Cerrar el archivo después de escribir
    }

    public static ArrayList<String> leerDatos(String archivo) throws IOException {
        ArrayList<String> datos = new ArrayList<>();
        BufferedReader fdatos = new BufferedReader(new FileReader(new File(archivo)));
        String dato;
        while ((dato = fdatos.readLine()) != null) {
            datos.add(dato); // Lee cada línea y la agrega a la lista
        }
        fdatos.close(); // Cerrar el archivo después de leer
        return datos;
    }

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borrar pantalla de la consola

        String archivo = "materias.txt";
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> datos = new ArrayList<>();

        System.out.println("\nCaptura de datos ...");
        capturarDatos(datos, teclado);

        System.out.println("\nGrabando datos en archivo ...");
        try {
            grabarDatos(archivo, datos);
            System.out.println("Datos grabados correctamente.");
        } catch (Exception e) {
            System.out.println("Error al grabar archivo: " + e);
        }

        System.out.println("\nLeyendo datos del archivo ...");
        try {
            datos = leerDatos(archivo);
            System.out.println("Datos leídos del archivo:");
            for (String dato : datos) {
                System.out.println(dato);
            }
        } catch (Exception e) {
            System.out.println("Error leyendo el archivo: " + e);
        }

        teclado.close(); // Cerrar el Scanner
    }
}
