package p119_Organismo;

public class Perro extends Organismo implements Canino {
    public Perro (String nombre){
        super(nombre);

    }

    @Override
    public void correr() {
        System.out.println("El perro corre");
        
    }

    @Override
    public void cuatroPatas() {
        System.out.println("tiene 4 patas");
        
    }

    @Override
    public void multiCelular() {
        System.out.println("multicelular");
        
    }

    @Override
    public void sangreCaliente() {
       System.out.println("tiene la sangre caliente");
        
    }

    

}
