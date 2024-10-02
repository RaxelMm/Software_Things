
package p104_PuntoCirculo;

public class Circulo {  
    private double radio;
    private Punto punto;  // Renombramos 'Punto' a 'punto'

    // Constructor vacío
    public Circulo() {
    }

    // Constructor que recibe radio y punto
    public Circulo(Punto punto, double radio) {
        this.radio = radio;
        this.punto = punto;
    }

    // Método para calcular el área del círculo
    public double getArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    // Método para calcular la circunferencia del círculo
    public double getCircunferencia() {
        return 2 * Math.PI * radio;
    }

    // Método para obtener el centro (punto) del círculo
    public Punto getCentro() {
        return punto;
    }

    // Sobrescribir toString para mostrar información del círculo
    @Override
    public String toString() {
        return "Círculo [centro = " + punto + ", radio = " + radio + "]";
    }
}



    

