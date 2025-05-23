package Empresa;

abstract class Usuario {
    String nombre_usuario;

    public Usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public void iniciar_sesion() {
        System.out.printf("Inicio sesion de :"+ nombre_usuario);
    }
    public void cerrar_sesion(){
        System.out.printf("Cerrar sesion de :"+ nombre_usuario);
    }

    public abstract void obtenerPermisos();
}
