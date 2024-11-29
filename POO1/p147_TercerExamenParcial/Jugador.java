package p147_TercerExamenParcial;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nombre;
    private int edad;
    private char sexo;
    private String estadoCivil;
    private String descripcion;
    private double salario;

    // Constructor vacío
    public Jugador() {}

    // Constructor con todos los parámetros
    public Jugador(String nombre, int edad, char sexo, String estadoCivil, String descripcion, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.descripcion = descripcion;
        this.salario = salario;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public char getSexo() { return sexo; }
    public void setSexo(char sexo) { this.sexo = sexo; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}
