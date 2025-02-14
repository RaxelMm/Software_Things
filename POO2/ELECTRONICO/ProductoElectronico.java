package ELECTRONICO;

public class ProductoElectronico {
    protected String nombre;
    protected double precio;
    public ProductoElectronico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }


    public void mostrar_info(){
        System.out.println("Producto "+nombre);
        System.out.println("Precio "+precio);
    }


   
    
    

    
    
    

}
