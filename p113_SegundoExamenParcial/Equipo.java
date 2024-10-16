package p113_SegundoExamenParcial;

import java.util.ArrayList;

public class Equipo {
    private String Nombre;
    private String Liga;
    private ArrayList<Jugador> Jugadores;

    // Constructor vacío: inicializamos el arreglo de jugadores
    public Equipo() {
        Jugadores = new ArrayList<>();
    }

    // Constructor con los parámetros de la clase
    public Equipo(String nombre, String liga) {
        this.Nombre = nombre;
        this.Liga = liga;
        Jugadores = new ArrayList<>();
    }

    // Método para obtener el arreglo de jugadores
    public ArrayList<Jugador> getJugadores() {
        return Jugadores;
    }

    // Método para agregar un jugador al equipo
    public void agregarJugador(Jugador jugador) {
        Jugadores.add(jugador);
    }

    // Método que calcula el total del bono de todos los jugadores
    public double getTotalBono() {
        double totalBono = 0;
        for (Jugador jugador : Jugadores) {
            totalBono += jugador.getBono();
        }
        return totalBono;
    }

    // Método que calcula el total de los salarios de los jugadores, incluyendo bonos
    public double getTotal() {
        double totalSalario = 0;
        for (Jugador jugador : Jugadores) {
            totalSalario += jugador.Salario + jugador.getBono();
        }
        return totalSalario;
    }

    // Método que cuenta el total de jugadores hombres ('H')
    public int getTotalH() {
        int totalHombres = 0;
        for (Jugador jugador : Jugadores) {
            if (jugador.getSexo() == 'H') {
                totalHombres++;
            }
        }
        return totalHombres;
    }

    // Método que cuenta el total de jugadores mujeres ('M')
    public int getTotalM() {
        int totalMujeres = 0;
        for (Jugador jugador : Jugadores) {
            if (jugador.getSexo() == 'M') {
                totalMujeres++;
            }
        }
        return totalMujeres;
    }

    // Método que imprime un reporte del equipo
   // Método que imprime el reporte detallado del equipo
   public void reporte() {
    System.out.println(this);
    for (Jugador jugador : Jugadores) {
        System.out.println("- " + jugador);
    }
}

    // Método sobrecargado toString() que muestra los datos del equipo y sus totales
    @Override
    public String toString() {
        return "Equipo [Nombre=" + Nombre + ", Liga=" + Liga + ", Total Jugadores=" + Jugadores.size() 
                + ", Total Hombres=" + getTotalH() + ", Total Mujeres=" + getTotalM() 
                + ", Total Bonos=" + getTotalBono() + ", Total Salarios=" + getTotal() + "]";
    }
}
