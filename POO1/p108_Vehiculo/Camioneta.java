package p108_Vehiculo;

public class Camioneta extends Vehiculo {
    private double Capacidad;
    private int Ejes;
    public Camioneta(){
    }
    public Camioneta(String serie, String marca, int año, double precio, double capacidad, int ejes) {
        super(serie, marca, año, precio);
        Capacidad = capacidad;
        Ejes = ejes;
    }
    public double getCapacidad() {
        return Capacidad;
    }
    public void setCapacidad(double capacidad) {
        Capacidad = capacidad;
    }
    public int getEjes() {
        return Ejes;
    }
    public void setEjes(int ejes) {
        Ejes = ejes;
    }

    @Override
    public String toString() {
        return "Camioneta ["+super.toString()+"Camioneta [Capacidad=" + Capacidad + ", Ejes=" + Ejes + "]";
    }

    

    


    

}
