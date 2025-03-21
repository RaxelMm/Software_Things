package VehiculoVarios;

public class Tren extends Vehiculo {
    String tipoTren;
    String ciudad;
    
  
    public Tren(String marca, String modelo, int capacidad, String tipoTren, String ciudad) {
        super(marca, modelo, capacidad);
        this.tipoTren = tipoTren;
        this.ciudad = ciudad;
    }


    @Override
public String toString() {
    return super.toString() + ", Tren [tipoTren=" + tipoTren + ", ciudad=" + ciudad + "]";
}

    
    

    
        

    }

