package Empresa;

public class Administrador extends Usuario {
    public Administrador(String nombre_usuario) {
        super(nombre_usuario);
    }

    public void obtenerPermisos(){
        System.out.printf("El administrador especial es: %s", nombre_usuario);

    }

}
