package p108_Vehiculo;

public class Vehiculo {
    private String Serie;
    private String Marca;
    private int Año;
    private double precio;

    public Vehiculo() {
    }

    public Vehiculo(String serie, String marca, int año, double precio) {
        Serie = serie;
        Marca = marca;
        Año = año;
        this.precio = precio;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String serie) {
        Serie = serie;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int año) {
        Año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Serie=" + Serie + ", Marca=" + Marca + ", Año=" + Año + ", precio=" + precio + "]";
    }

    

    

    

    

    
}
