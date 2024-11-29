package p136_Archivo5;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int op;
        Scanner teclado = new Scanner(System.in);
        String archivo = "datos.dat";
        ArrayList<Persona> datos = new ArrayList<>();

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush(); // Borrar pantalla de la consola
            System.out.println("------Procesamiento de datos -------");
            System.out.println("Capturar datos .............[1]");
            System.out.println("Grabar datos en archivo .............[2]");
            System.out.println("Leer datos en archivo .............[3]");
            System.out.println("Mostrar datos .............[4]");
            System.out.println("S A L I R.............[5]");
            System.out.print("Selecciona una opcion: ");
            
            try {
                op = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer

                switch (op) {
                    case 1:
                        if (datos.size() == 0)
                            System.out.println("\nCapturando datos por primera vez\n");
                        else
                            System.out.println("\nLos datos se agregarán al final de los existentes");
                        Procesa.capturarDatos(datos, teclado);
                        break;

                    case 2:
                        try {
                            if (datos.size() != 0) {
                                Procesa.grabarDatos(archivo, datos);
                                System.out.println("Datos grabados correctamente");
                            } else
                                System.out.println("\nNo hay datos");
                        } catch (Exception e) {
                            System.out.println("Error al grabar los datos");
                        }
                        break;

                    case 3:
                        try {
                            if (datos.size() != 0)
                                System.out.println("\nLos datos actuales se sobrescribirán con los datos del archivo.");
                            datos = Procesa.leerDatos(archivo);
                            System.out.println("Datos cargados del archivo.");
                        } catch (Exception e) {
                            System.out.println("Error al cargar los datos");
                        }
                        break;

                    case 4:
                        if (datos.size() == 0)
                            System.out.println("\nNo hay datos para mostrar");
                        else
                            Procesa.mostrarDatos(datos);
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida, intenta de nuevo.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Ingresa un número entre 1 y 5.");
                teclado.nextLine(); // Limpiar el buffer
                op = 0; // Resetear opción para mantener el bucle
            }
        } while (op != 5);

        teclado.close();
    }
}
