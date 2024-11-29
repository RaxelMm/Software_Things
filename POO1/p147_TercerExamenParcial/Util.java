package p147_TercerExamenParcial;

import java.io.*;
import java.util.ArrayList;

public class Util {
    
    // Inicializa con datos de ejemplo
    public static ArrayList<Jugador> inicializarDatos() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Juan Perez", 25, 'M', "Soltero", "Delantero", 5000));
        jugadores.add(new Jugador("Ana Martinez", 22, 'F', "Casada", "Portera", 4500));
        return jugadores;
    }

    // Serializar datos
    public static void serializarDatos(String archivo, ArrayList<Jugador> datos) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
        oos.writeObject(datos);
        oos.close();
    }

    // Deserializar datos
    public static ArrayList<Jugador> desSerializarDatos(String archivo) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
        ArrayList<Jugador> datos = (ArrayList<Jugador>) ois.readObject();
        ois.close();
        return datos;
    }
}
