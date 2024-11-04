package p136_Archivo5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Procesa {

    public static void mostrarDatos(ArrayList<Persona> datos) {
        System.out.println("\nLos datos hasta el momento son :");
        for (Persona persona : datos) {
            System.out.println(persona);
        }
    }

    public static void capturarDatos(ArrayList<Persona> datos, Scanner teclado) {
        System.out.println("Introduce los datos de una persona (nombre vacío para terminar)");
        while (true) {
            Persona persona = new Persona();
            System.out.print("Nombre: ");
            persona.setNombre(teclado.nextLine());
            if (persona.getNombre().isEmpty())
                break;
            System.out.print("Edad: ");
            persona.setEdad(teclado.nextInt());
            System.out.print("Peso: ");
            persona.setPeso(teclado.nextFloat());
            teclado.nextLine(); // Limpiar buffer
            System.out.print("Correo: ");
            persona.setCorreo(teclado.nextLine());
            datos.add(persona);
        }
    }

    public static void grabarDatos(String archivo, ArrayList<Persona> datos) throws IOException {
        ObjectOutputStream fdatos = new ObjectOutputStream(new FileOutputStream(archivo));
        fdatos.writeObject(datos);
        fdatos.close();
    }

    public static ArrayList<Persona> leerDatos(String archivo) throws IOException, ClassNotFoundException {
        ArrayList<Persona> datos;
        ObjectInputStream fdatos = new ObjectInputStream(new FileInputStream(archivo));
        datos = (ArrayList<Persona>) fdatos.readObject();
        fdatos.close();
        return datos;
    }
}
