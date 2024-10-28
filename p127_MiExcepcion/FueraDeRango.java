package p127_MiExcepcion;

public class FueraDeRango extends Exception {
    public FueraDeRango(String error){
        super(error);
    }
}
