package p119_Organismo;

public class App {
    public static void main(String[] args) {
        Perro miPerro = new Perro("Firulais");
        Perico mPerico = new Perico("Chip");
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        System.out.println("el perro se llama " + miPerro.getNombre());
        miPerro.respiracion();
        miPerro.movimiento();
        miPerro.crecimiento();
        miPerro.multiCelular();
        miPerro.sangreCaliente();
        miPerro.cuatroPatas();
        miPerro.correr();
        System.out.println("");


        System.out.println("Mi perico se llama "+ mPerico.getNombre());
        mPerico.respiracion();
        mPerico.movimiento();
        mPerico.crecimiento();
        mPerico.multiCelular();
        mPerico.sangreCaliente();
        mPerico.volar();
        mPerico.dosPatas();

    }

    
    
}
