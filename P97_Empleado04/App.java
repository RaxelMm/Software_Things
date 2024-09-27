package p97_Empleado04;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola


        ArrayList<Empleado> empleados = new ArrayList<>();
        Empleado empleado1 = new Empleado("Juan Perez",56,'H',true);
        Empleado empleado2 = new Empleado("Maria Lopez",22,'M',false);
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(new Empleado("Dario Jimenez",33,'H',false));
        empleados.add(new Empleado("Jessica Lee",22,'M',false));
        System.out.println("Todos los empleados son");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
            
        }
        
    
        
    }
    
}
