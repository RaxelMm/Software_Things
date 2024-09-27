package p100_Articulo;

public class Articulo {
    // Atributos
    private String id;
    private String desc;
    private int cant;
    private double precioUnit;

    // Constructor
    public Articulo(String id, String desc, int cant, double precioUnit) {
        this.id = id;
        this.desc = desc;
        this.cant = cant;
        this.precioUnit = precioUnit;
    }

    // Métodos Getters
    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public int getCant() {
        return cant;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    // Métodos Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    // Método para calcular el total
    public double getTotal() {
        return cant * precioUnit;
    }

    // Método toString para imprimir el artículo
    @Override
    public String toString() {
        return "Articulo [ID = " + id + ", Descripción = " + desc + ", Cantidad = " + cant + ", Precio Unitario = " + precioUnit + "]";
    }
}
