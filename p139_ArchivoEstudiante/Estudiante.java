package p139_ArchivoEstudiante;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private String nombre;
    private int edad;
    private double Promedio;
    private String Sexo;

    public Estudiante(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPromedio() {
        return Promedio;
    }

    public void setPromedio(double promedio) {
        Promedio = promedio;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", edad=" + edad + ", Promedio=" + Promedio + ", Sexo=" + Sexo + "]";
    }

    

}
