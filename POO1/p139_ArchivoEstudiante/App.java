package p139_ArchivoEstudiante;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int op;
        Scanner teclado = new Scanner(System.in);
        String archivo = "estudiantes.dat3";
        ArrayList<Estudiante> datos = new ArrayList<>();

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush(); // Borrar pantalla de la consola
            System.out.println("------Procesamiento de datos -------");
            System.out.println("Capturar datos .............[1]");
            System.out.println("Grabar datos en archivo .............[2]");
            System.out.println("Leer datos en archivo .............[3]");
            System.out.println("Mostrar datos .............[4]");
            System.out.println("Mostrar estadísticas .............[5]");
            System.out.println("S A L I R .............[6]");
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
                        esperarEnter(teclado);
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
                        esperarEnter(teclado);
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
                        esperarEnter(teclado);
                        break;

                    case 4:
                        if (datos.size() == 0)
                            System.out.println("\nNo hay datos para mostrar");
                        else
                            Procesa.mostrarDatos(datos);
                        esperarEnter(teclado);
                        break;

                    case 5:
                        if (datos.size() == 0) {
                            System.out.println("\nNo hay datos para mostrar estadísticas.");
                        } else {
                            System.out.println("\nEstadísticas:");
                            System.out.println("Promedio de promedios: " + Procesa.promedioPromedios(datos));
                            System.out.println("Promedio de edades: " + Procesa.promedioEdades(datos));
                            System.out.println("Cantidad de hombres: " + Procesa.contarHombres(datos));
                            System.out.println("Cantidad de mujeres: " + Procesa.contarMujeres(datos));
                        }
                        esperarEnter(teclado);
                        break;

                    case 6:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida, intenta de nuevo.");
                        esperarEnter(teclado);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Ingresa un número entre 1 y 6.");
                teclado.nextLine(); // Limpiar el buffer
                op = 0; // Resetear opción para mantener el bucle
                esperarEnter(teclado);
            }
        } while (op != 6);

        teclado.close();
    }

    // Método para esperar hasta que el usuario presione Enter
    public static void esperarEnter(Scanner teclado) {
        System.out.println("\nPresiona Enter para continuar...");
        teclado.nextLine();
    }
}
