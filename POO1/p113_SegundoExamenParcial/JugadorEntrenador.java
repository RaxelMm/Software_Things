    package p113_SegundoExamenParcial;

    public class JugadorEntrenador extends Jugador {
        private int Subordinados;
        private int Proyectos;
    
        public JugadorEntrenador(String nombre, char sexo, String descripcion, double salario, int subordinados, int proyectos) {
            super(nombre, sexo, descripcion, salario);
            Subordinados = subordinados;
            Proyectos = proyectos;
    
            // Calculamos el bono y luego el total
            double bono = getBono(); // Invocamos el método getBono()
            Total = Salario + bono;  // Calculamos el total
        }
    
        @Override
        public double getBono() {
            // Calculamos el bono según los criterios dados
            return (Salario * 0.15) + (Proyectos * 100) + (Subordinados * 10);
        }
    
        @Override
        public String toString() {
            return super.toString() + ", Subordinados=" + Subordinados + ", Proyectos=" + Proyectos;
        }
    }
    