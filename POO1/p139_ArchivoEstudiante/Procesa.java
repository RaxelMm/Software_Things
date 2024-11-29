package p139_ArchivoEstudiante;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Procesa {

    public static void mostrarDatos(ArrayList<Estudiante> datos) {
        System.out.println("\nLos datos hasta el momento son :");
        for (Estudiante estudiante : datos) {
            System.out.println(estudiante);
        }
    }

    public static void capturarDatos(ArrayList<Estudiante> datos, Scanner teclado) {
        System.out.println("Introduce los datos de una estudiante(nombre vacío para terminar)");
        while (true) {
            Estudiante estudiante = new Estudiante();
            System.out.print("Nombre: ");
            estudiante
                    .setNombre(teclado.nextLine());
            if (estudiante
                    .getNombre().isEmpty())
                break;
            System.out.print("Edad: ");
            estudiante.setEdad(teclado.nextInt());
            System.out.print("Promedio: ");
            estudiante.setPromedio(teclado.nextDouble());teclado.nextLine(); // Limpiar buffer
            System.out.print("Sexo: ");
            estudiante.setSexo(teclado.nextLine());
            datos.add(estudiante);
        }
    }

    public static void grabarDatos(String archivo, ArrayList<Estudiante> datos) throws IOException {
        ObjectOutputStream fdatos = new ObjectOutputStream(new FileOutputStream(archivo));
        fdatos.writeObject(datos);
        fdatos.close();
    }

    public static ArrayList<Estudiante> leerDatos(String archivo) throws IOException, ClassNotFoundException {
        ArrayList<Estudiante> datos;
        ObjectInputStream fdatos = new ObjectInputStream(new FileInputStream(archivo));
        datos = (ArrayList<Estudiante>) fdatos.readObject();
        fdatos.close();
        return datos;
    }

    public static double promedioPromedios(ArrayList<Estudiante> datos) {
        if (datos.isEmpty()) return 0;
        double sumaPromedios = 0;
        for (Estudiante estudiante : datos) {
            sumaPromedios += estudiante.getPromedio();
        }
        return sumaPromedios / datos.size();
    }

    // Función para calcular el promedio de las edades
    public static double promedioEdades(ArrayList<Estudiante> datos) {
        if (datos.isEmpty()) return 0;
        int sumaEdades = 0;
        for (Estudiante estudiante : datos) {
            sumaEdades += estudiante.getEdad();
        }
        return (double) sumaEdades / datos.size();
    }

    // Función para contar la cantidad de hombres
    public static int contarHombres(ArrayList<Estudiante> datos) {
        int hombres = 0;
        for (Estudiante estudiante : datos) {
            if (estudiante.getSexo().equalsIgnoreCase("Hombre")) {
                hombres++;
            }
        }
        return hombres;
    }

    // Función para contar la cantidad de mujeres
    public static int contarMujeres(ArrayList<Estudiante> datos) {
        int mujeres = 0;
        for (Estudiante estudiante : datos) {
            if (estudiante.getSexo().equalsIgnoreCase("Mujer")) {
                mujeres++;
            }
        }
        return mujeres;
    }


}
