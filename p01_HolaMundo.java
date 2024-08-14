/**
 * p01_HolaMundo _ Manda una saliada a la pantalla
 */
public class p01_HolaMundo {
    public static void main(String[] args) {
        String amigo ="Adrian";
        String hermano = "Reynaldo";
        String mensaje = String.format("Tanto %s como %s desean aprender Java ",amigo, hermano);

        System.out.println("Hola Mundo en el Lenguaje Java");
        System.out.println("\nHola amigo "+amigo +" bienvendido a java ");
        System.out.println("\nHola amigo es "+amigo+",mi hermano es"+hermano);
        System.out.println("\n"+ mensaje);

        
    }

        
} 
