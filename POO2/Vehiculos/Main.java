package Vehiculos;

public class Main {
    public static void main(String[] args) {
        VehiculoElectrico v1 = new AutoElectrico("Mazda") {
            
        };

        VehiculoTerrestre v2 = new AutoElectrico("Tsuru") {
            
        };

        v1.cargarBateria();
        v2.conducir();
    }

}
