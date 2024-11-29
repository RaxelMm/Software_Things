package p106_Persona;

public class App {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        Persona p1 = new Persona("Juan Perez","Sierra de Cardos", 41);
        Persona p2 = new Persona("Maria Ines", "Calle San Luis", 32);

        Estudiante e1 = new Estudiante("Carlos Castañeda", "Cierra Nevada", 25, "Ing Software", 2023, 700);
        Estudiante e2 = new Estudiante("Miguel Perez", "Av Hidalgo", 19, "Robotica",2002 , 300);

        Apoyo a1 = new Apoyo("Luis","Av Mexico",25,"Jardinero","Preparatoria",1500);
        Apoyo a2 = new Apoyo("Maclovia","Lomas",30,"Secretaria","Lic Contabilidad",2500);
       

        System.out.println("Personas");
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        System.out.println("Estudiantes");
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e1 instanceof Persona);

        System.out.println("Apoyo");
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a1 instanceof Persona);

    }
    
}
