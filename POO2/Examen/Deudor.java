package Examen;
public class Deudor {
    String nombre;
    double monto;
    String direccion;
    double fecha;

    public Deudor(String nombre, double monto, String direccion, double fecha) {
        this.nombre = nombre;
        this.monto = monto;
        this.direccion = direccion;
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "Deudor [nombre=" + nombre + ", monto=" + monto + ", direccion=" + direccion + ", fecha=" + fecha + "]";
    }

    

    

    

    

    

}
