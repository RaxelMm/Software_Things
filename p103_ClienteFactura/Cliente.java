package p103_ClienteFactura;

public class Cliente {
    private int Id;
    private String Nombre;
    private int Descuento;

    public Cliente(int id, String nombre, int descuento) {
        Id = id;
        Nombre = nombre;
        Descuento = descuento;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int descuento) {
        Descuento = descuento;
    }

    @Override
    public String toString() {
        return "Cliente [Id=" + Id + ", Nombre=" + Nombre + ", Descuento=" +
                Descuento + "]";
    }
}