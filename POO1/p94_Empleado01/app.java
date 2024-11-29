package p94_Empleado01;
//Programa principal
public class app {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();
        empleado1.Nombre="Juan Perez";
        empleado2.Nombre="Maria Perez";
        empleado1.edad=45;
        empleado2.edad=25;

        System.out.println("Empleado 1 : " + empleado1.Nombre);
        System.out.println("Empleado 1 edad : " + empleado1.edad);
        System.out.println("Empleado 2 : " + empleado2.Nombre);
        System.out.println("Empleado 2 edad : " + empleado2.edad);


    
    }
    
    
}
