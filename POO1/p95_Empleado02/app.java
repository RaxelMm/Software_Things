package p95_Empleado02;

public class app {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado();

        empleado1.setNombre("Carlos");
        empleado1.setEdad(25);
        System.out.println("Empleado 1 Nombre "+empleado1.getNombre());
        System.out.println("Empleado 1 edad "+empleado1.getEdad());
        System.out.println(empleado1.toString());
    
}
}