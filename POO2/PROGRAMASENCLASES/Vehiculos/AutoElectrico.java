package Vehiculos;

public class AutoElectrico implements VehiculoElectrico, VehiculoTerrestre {
    private String modelo;

    public AutoElectrico(String modelo){
        this.modelo = modelo;
    }


    @Override
    public void cargarBateria(){
        System.out.println("Cargando la bateria del " + modelo);



    }


    @Override

    public void conducir(){
        System.out.println("Conducionedo el auto electrico "+ modelo);
    }



}
