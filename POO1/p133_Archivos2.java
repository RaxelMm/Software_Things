import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class p133_Archivos2 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola

        String[] ciudades = {"zac","fresnillo","Cd Guzman","Rio Grande","Guadalajara","Novolato","Zacatlan"};
        File arch = new File("Ciudades.txt");
        if (!arch.exists()) {
            System.out.println("No existe,por lo tanto lo crearemos");
            try {
                BufferedWriter fciudades = new BufferedWriter(new FileWriter(arch));
                for (String ciudad : ciudades) {
                    fciudades.write(ciudad + "\n");
                    
                }
                fciudades.close();
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
