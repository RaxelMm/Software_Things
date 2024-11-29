package p109_FormaV2;

public class Rectangulo extends Forma {
    private double Largo;
    private double Ancho;
   
    public Rectangulo(String color, boolean relleno, double largo, double ancho) {
        super(color, relleno);
        Largo = largo;
        Ancho = ancho;
    }

    public double getLargo() {
        return Largo;
    }

    public void setLargo(double largo) {
        Largo = largo;
    }

    public double getAncho() {
        return Ancho;
    }

    public void setAncho(double ancho) {
        Ancho = ancho;
    }

    public double getArea(){
        return 2 * (Largo + Ancho);
        
    }

    public double getPerimetro(){
        return Largo * Ancho;
    }

    @Override
    public String toString() {
        return super.toString()+"Rectangulo [Largo=" + Largo + ", Ancho=" + Ancho;
    }

    

    

}
