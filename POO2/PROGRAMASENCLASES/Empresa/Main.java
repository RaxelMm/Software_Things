package Empresa;

public class Main {
    public static void main(String[] args) {
        Usuario u1 = new Administrador("Juan Manuel");
        Usuario u2 = new Cliente("Joaquin Perez");

        u1.iniciar_sesion();
        System.out.println("\n");
        u2.iniciar_sesion();
        System.out.println("\n");
        u1.obtenerPermisos();
        System.out.println("\n");
        u2.obtenerPermisos();
        System.out.println("\n");
        u1.cerrar_sesion();
        System.out.println("\n");
        u2.cerrar_sesion();
        System.out.println("\n");

    }
}
