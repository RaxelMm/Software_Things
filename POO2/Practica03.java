import java.text.SimpleDateFormat;
import java.util.Date;

public class Practica03 {
    int numeroHabitacion;
    String cliente;
    Date fechaCheckin;
    Date fechaCheckOut;

    enum tipoHabitaciones {
        INDIVIDUAL, DOBLE, SUITE
    }

    public Practica03(int numeroHabitacion, String cliente, Date fechaCheckin, Date fechaCheckOut) {
        this.numeroHabitacion = numeroHabitacion;
        this.cliente = cliente;
        this.fechaCheckin = fechaCheckin;
        this.fechaCheckOut = fechaCheckOut;
    }

    public int calcularDiasEstadia() {
        long diferencia = fechaCheckOut.getTime() - fechaCheckin.getTime(); 
        return (int) (diferencia / (1000 * 60 * 60 * 24)); 
    }

    @Override
    public String toString() {
        return "Practica03 [numeroHabitacion=" + numeroHabitacion + ", cliente=" + cliente + 
               ", fechaCheckin=" + fechaCheckin + ", fechaCheckOut=" + fechaCheckOut + "]";
    }

    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Date fechaCheckin = sdf.parse("05/02/2024");
            Date fechaCheckOut = sdf.parse("10/02/2024");

            Practica03 cliente = new Practica03(5, "Luis Manuel", fechaCheckin, fechaCheckOut);

            
            System.out.println(cliente);
            System.out.println("Días de estadía: " + cliente.calcularDiasEstadia());

        } catch (Exception e) {
            System.out.println("Error al asignar la fecha.");
        }
    }
}
