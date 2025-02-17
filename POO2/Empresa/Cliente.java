package Empresa;

public class Cliente extends Usuario {

    public Cliente(String nombre_usuario) {
        super(nombre_usuario);
    }

    @Override
    public void obtenerPermisos() {
        System.out.printf("Usted solo tiene acceso a su informacion: "+nombre_usuario+"\n");
    }
}
