package p113_SegundoExamenParcial;

public class JugadorActivo extends Jugador {
    private int Partidos;
    private int Goles;


    public JugadorActivo(String nombre, char sexo, String descripcion, double salario, int partidos, int goles) {
        super(nombre, sexo, descripcion, salario);
        Partidos = partidos;
        Goles = goles;

         // Calculamos el bono y luego el total
         double bono = getBono(); // Invocamos el método getBono()
         
         Total = Salario + bono;  // Calculamos el total
    }


    @Override
    public double getBono() {

        return (Salario * 0.10) + (Partidos * 50) + (Goles * 5);

    }


    @Override
    public String toString() {
        return "JugadorActivo ["+super.toString()+"Partidos=" + Partidos + ", Goles=" + Goles + ", Total=" + Total + "]";
    }

    







       
    



}
