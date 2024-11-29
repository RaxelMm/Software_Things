package p120_Vehiculo;
public class Maquina {
    private String nombre, propietario;
    private int pasajeros;
    
    public Maquina(String nombre, String propietario, int pasajeros) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.pasajeros = pasajeros;
    }

    public Maquina(String nombre) {
        this.nombre = nombre;
        this.propietario = "No asignado";
        this.pasajeros = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void repostar() {
        System.out.println("Repostando...");
    }

    public void arrancar() {
        System.out.println("Arrancando...");
    }

    public void frenar() {
        System.out.println("Frenando...");
    }

    @Override
    public String toString() {
        return "Maquina [Nombre=" + nombre + ", Propietario=" + propietario + ", Pasajeros=" + pasajeros + "]";
    }
}