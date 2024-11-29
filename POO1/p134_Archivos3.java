import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class p134_Archivos3 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borrar pantalla de la consola
        File arch = new File("Materias.txt");
        
        if (arch.exists()) {
            try {
                BufferedReader fciudades = new BufferedReader(new FileReader(arch));
                int nolineas = (int) fciudades.lines().count();
                System.out.println(nolineas);
                fciudades.close();
                String[] ciudades = new String[nolineas];
                fciudades = new BufferedReader(new FileReader(arch));

                for(int i=0;i<nolineas;i++){
                    ciudades[i] = fciudades.readLine();

                }
                fciudades.close();
                for (String ciudad : ciudades) {
                    System.out.println(ciudad);
                    
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            
        }else{
            System.out.println("no existe");
        }
    }
    
}
