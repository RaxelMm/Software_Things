package p96_Empleado03;

public class App {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juan Perez",25);
        Empleado empleado2 = new Empleado("Nepomuseno",1);
        Empleado empleado3 = new Empleado();

        empleado3.setNombre("Jorge");
        empleado3.setEdad(2);
        System.out.println("Empleadon 1 "+empleado1.toString());
        System.out.println("Empleadon 2 "+empleado2.toString());
        
    }
    
}
