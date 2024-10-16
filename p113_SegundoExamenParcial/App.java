package p113_SegundoExamenParcial;

public class App {
        public static void main(String[] args) {
            Equipo equipo = new Equipo("Limones", "Torneo la Bombonera");
    
            // Antes de agregar jugadores
            System.out.println(equipo);
    
            // Agregar jugadores
            equipo.agregarJugador(new JugadorEntrenador("Francisco Zapeda", 'H', "Entrenador Principal", 1000.0, 8, 1));
            equipo.agregarJugador(new JugadorEntrenador("Alexis Estrada", 'H', "Entrenador de Apoyo", 900.0, 10, 2));
            equipo.agregarJugador(new JugadorActivo("Alexander Lopez", 'H', "Principal No 11", 100.0, 2, 2));
            equipo.agregarJugador(new JugadorActivo("Uriel Puga", 'H', "Principal No 16", 100.0, 3, 1));
            equipo.agregarJugador(new JugadorActivo("Alejandra Escalona", 'M', "Principal No 21", 100.0, 3, 3));
            equipo.agregarJugador(new JugadorActivo("Armando Santana", 'H', "Banca No 10", 120.0, 4, 1));
            equipo.agregarJugador(new JugadorActivo("Daniel Mijares", 'H', "Banca No 15", 150.0, 4, 4));
            equipo.agregarJugador(new JugadorActivo("Antonio Hernandez", 'M', "Banca No 20", 350.0, 5, 3));
            equipo.agregarJugador(new JugadorActivo("Andrea Solis", 'M', "Principal No 12", 550.0, 5, 5));
            equipo.agregarJugador(new JugadorActivo("Marissa Hernandez", 'M', "Principal No 12", 600.0, 4, 2));
            equipo.agregarJugador(new JugadorActivo("Diana Soto", 'M', "Principal No 12", 700.0, 5, 3));
    
            // Después de agregar jugadores
            System.out.println(equipo);
    
            // Mostrar reporte detallado
            equipo.reporte();
        }
    }
    