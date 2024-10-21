package p116_Juego;
import java.util.Scanner;

public class JuegoDados implements Juego {
    private int dado1,dado2;
    private String jugador1,jugador2;
    private Scanner teclado = new Scanner(System.in);

    @Override
    public void finalizar() {
        if (dado1>dado2)
            System.out.println("gano "+jugador1+" con "+dado1);
        else if (dado2 > dado1)
            System.out.println("Gano "+jugador2+" con "+dado2);
        else 
            System.out.println("Empate con "+dado1); 
        
        
        }
        @Override
        public void iniciar() {
            System.out.println("Jugador 1 "); jugador1 = teclado.nextLine();
            System.out.println("Jugador 2 "); jugador2 = teclado.nextLine();
            
        }
        @Override
        public void jugar() {
            dado1 = 1 + (int)(Math.random()*6);
            dado2 = 1 + (int)(Math.random()*6);
            System.out.println(jugador1+ " le salio "+dado1);
            System.out.println(jugador2+ " le salio "+dado2);
        }
    



}
