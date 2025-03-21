package VehiculoVarios;

public class Taxi extends Vehiculo{
    int pasajeros;
    int numeroTaxi;
    public Taxi(String marca, String modelo, int capacidad, int pasajeros,int numeroTaxi) {
        super(marca, modelo, capacidad);
        this.pasajeros = pasajeros;
        this.numeroTaxi = numeroTaxi;
    }
    @Override
public String toString() {
    return super.toString() + ", Taxi [pasajeros=" + pasajeros + ", numeroTaxi=" + numeroTaxi + "]";
}

    


}
