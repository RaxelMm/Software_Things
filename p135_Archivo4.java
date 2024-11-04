import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * p134_Archivo4
 */
public class p135_Archivo4 {
    public static void capturarDatos(ArrayList<String> datos){
        String dato="";
        System.out.println("\nIntroduce un dato y presiona ENTER, dato vacio para terminar");
        while (true) {
            dato = new Scanner(System.in).nextLine();
            if (dato.isEmpty())break;
            datos.add(dato);
                
            }
            
        }
        public static void grabarDatos(String archivo,ArrayList<String> datos )throws IOException{
            BufferedWriter fdatos = new BufferedWriter(new FileWriter(new File(archivo)));
            for (String dato : datos) {
                fdatos.write(dato + "\n");

            fdatos.close();
                
            }

        }
    public static void mostraDatos(ArrayList<String> datos){
        System.out.println("\nLos datos hasta el momento son: ");
        for (String dato : datos) {
            System.out.println(dato);
            
        }
    }
    public static  ArrayList<String> leerDatos(String archivo)throws IOException{
        ArrayList<String> datos = new ArrayList<>();
        BufferedReader fdaatos = new BufferedReader(new FileReader(new File(archivo)));
        String dato;
        while ((dato=fdaatos.readLine())!=null)
        datos.add(dato);
        return datos;

    }

    public static void main(String[] args) {
        String archivo = "datos.txt";
        int op;
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> datos = new ArrayList<>();
        do {
             System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola

            System.out.println("------Procesamiento de datos -------");
            System.out.println("Capturar datos .............[1]");
            System.out.println("Grabar  datos en archivo .............[2]");
            System.out.println("Leer  datos en archivo .............[3]");
            System.out.println("Mostrar datos .............[4]");
            System.out.println("S A L I R.............[5]");
            System.out.println("Selecciona un opcion: "); op =teclado.nextInt();
            switch (op) {
                case 1:
                System.out.println("\nCaptura de datos ..."); 
                capturarDatos(datos);
                    
                    break;
                case 2:
                System.out.println("\nGrabando de datos en archivo ...");
                try {
                    grabarDatos(archivo, datos);
                } catch (Exception e) {
                    System.out.println("Error al grabar archivo"+e);
                }
                    
                    break;
                case 3:
                System.out.println("\nLeyendo datos en archivo ...");
                try {
                    datos = leerDatos(archivo);
                } catch (Exception e) {
                    System.out.println("Error leyendo el archivo");
                }
                    
                    break;
                case 4:
                System.out.println("\nMostrando datos...");
                mostraDatos(datos);
                    
                    break;
            
                case 5:
                System.out.println("\nSaliendo del sistema...");
                    
                    break;
            
                default:
                System.out.println("\nOpcion invalida");
                    break;
            }
            System.out.println("\nPresione cualquier tecla para continuar >>");teclado.nextLine();teclado.nextLine();
            
        } while (op!=5);
        System.out.println("Proceso terminado");
    }
}