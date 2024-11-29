package p99_Rectangulo;

public class Rectangulo {
    // Atributos
    private float largo;
    private float ancho;

    // Constructor con parámetros
    public Rectangulo(float largo, float ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    // Constructor sin parámetros (inicializa en 0 por defecto)
    public Rectangulo() {
        this.largo = 0;
        this.ancho = 0;
    }

    // Métodos Getters
    public float getLargo() {
        return largo;
    }

    public float getAncho() {
        return ancho;
    }

    // Métodos Setters
    public void setLargo(float largo) {
        this.largo = largo;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    // Método para calcular el área
    public float getArea() {
        return largo * ancho;
    }

    // Método para calcular el perímetro
    public float getPerimetro() {
        return 2 * (largo + ancho);
    }

    // Método toString para imprimir el rectángulo
    @Override
    public String toString() {
        return "Rectángulo [Largo = " + largo + ", Ancho = " + ancho + "]";
    }
}
