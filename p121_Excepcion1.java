/**
 * p121_Excepcion1
 */
public class p121_Excepcion1 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Borrar pantalla de la consola
        int a = 100;
        int b = 0;
        
        try {
            
            int c = a/b;
    
            System.out.println("El resultado es "+c);
        } catch (Exception e) {
           System.out.println("NO se puede dividir entre cero "+ e);
        } finally {
            System.out.println("Hola");
        }
    }

    
}