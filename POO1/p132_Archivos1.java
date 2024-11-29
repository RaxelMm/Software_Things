import java.io.File;

/**
 * p132_Archivos1
 */
public class p132_Archivos1 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        
        File arch = new File("datos.txt");
        System.out.println("Nombre de archivo: "+arch.getName());
        System.out.println("Es directorio?  "+arch.isDirectory());
        System.out.println("Es archivo?  "+arch.isFile());
        System.out.println("Ruta relativa "+ arch.getAbsolutePath());
        if (arch.exists()) {
            System.out.println("El archivo existe en la ruta actual");
            System.out.println("Se puede leer?  :"+arch.canRead());
            System.out.println("se puede escribir "+arch.canWrite());
            System.out.println("longitud del archivo "+arch.length());
            System.out.println("Fecha de modificacion : "+arch.lastModified());
        

            
        } else {
            System.out.println("el archivo no existe");
    

    }

    
}
}