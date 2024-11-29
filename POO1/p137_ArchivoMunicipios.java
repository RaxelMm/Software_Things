import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class p137_ArchivoMunicipios {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borrar pantalla de la consola
         String[] deportes = {"futbol","Beisbol","Ciclismox","Atletismo","Natacion","Motociclismo"};
        File arch = new File("Deportes.txt");
        if (!arch.exists()) {
            System.out.println("No existe,por lo tanto lo crearemos");
            try {
                BufferedWriter fdeportes = new BufferedWriter(new FileWriter(arch));
                for (String deporte : deportes) {
                    fdeportes.write(deporte + "\n");
                    
                }
                fdeportes.close();
                System.out.println("Archivo creado por exito");
            } catch (Exception e) {
                System.out.println("Error al manipular el archivo"+e.getMessage());
                // TODO: handle exception
            }
            
        }else{
            System.out.println("el archivo ya existe...");

        }
    }

        
    }
    

