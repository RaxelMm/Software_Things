package p116_Juego;

public class App {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borra pantalla de la consola

        JuegoDados miDados = new JuegoDados();
        miDados.iniciar();
        miDados.jugar();
        miDados.finalizar();

        JuegoAdivina mAdivina = new JuegoAdivina();
        mAdivina.iniciar();
        mAdivina.jugar();
        mAdivina.finalizar();

        
    }

}
