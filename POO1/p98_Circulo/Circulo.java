package p98_Circulo;

public class Circulo {
    double Area, Circunferencia, Radio;

    // Constructor que solo toma el radio
    public Circulo(double radio) {
        this.Radio = radio;
        this.Area = Math.PI * Math.pow(radio, 2);
        this.Circunferencia = 2 * Math.PI * radio;
    }

    // Constructor vacío
    public Circulo() {}

    // Métodos getters y setters
    public double getArea() {
        return Area;
    }

    public void setArea(double area) {
        this.Area = area;
    }

    public double getCircunferencia() {
        return Circunferencia;
    }

    public void setCircunferencia(double circunferencia) {
        this.Circunferencia = circunferencia;
    }

    public double getRadio() {
        return Radio;
    }

    public void setRadio(double radio) {
        this.Radio = radio;
        this.Area = Math.PI * Math.pow(radio, 2);
        this.Circunferencia = 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        return "Radio: " + Radio + ", Area: " + Area + ", Circunferencia: " + Circunferencia;
    }
}


