package ELECTRONICO;

public class Celular extends ProductoElectronico {
     private double tamañopantalla;

    public Celular(String nombre, double precio, double tamañopantalla) {
        super(nombre, precio);
        this.tamañopantalla = tamañopantalla;
    }

    @Override
    public void mostrar_info(){
        super.mostrar_info();
        System.out.println("El tamaño de pantalla es "+tamañopantalla);
    }

  




}
