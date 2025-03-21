package VehiculoVarios;

public class Vehiculo {
    String marca;
    String modelo;
    int capacidad;

    public Vehiculo(String marca, String modelo, int capacidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", capacidad=" + capacidad + "]";
    }

    
}
