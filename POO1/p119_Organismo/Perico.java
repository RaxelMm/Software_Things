package p119_Organismo;

public class Perico extends Organismo implements Ave{

    public  Perico(String nombre){
        super(nombre);
    }

    @Override
    public void dosPatas() {
       System.out.println("Tiene dos patas");
        
    }

    @Override
    public void volar() {
        System.out.println("Vuelaaa");
        
    }

    @Override
    public void multiCelular() {
        System.out.println("Es multicelular");
        
    }

    @Override
    public void sangreCaliente() {
        System.out.println("Es de sangre caliente");
        
    }

    


}
