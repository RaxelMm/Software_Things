package VehiculoVarios;

public class AutoBus extends Vehiculo {
    int numRutas;

    public AutoBus(String marca, String modelo, int capacidad, int numRutas) {
        super(marca, modelo, capacidad);
        this.numRutas = numRutas;
    }

    @Override
    public String toString() {
        return super.toString() + ", AutoBus [numRutas=" + numRutas + "]";
    }
    

    



    



}
