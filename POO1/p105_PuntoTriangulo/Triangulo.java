package p105_PuntoTriangulo;

public class Triangulo {
    Punto V1,V2,V3;

    public Triangulo() {
    }

    public Triangulo(Punto v1, Punto v2, Punto v3) {
        V1 = v1;
        V2 = v2;
        V3 = v3;
    }

    public Punto getV1() {
        return V1;
    }

    public void setV1(Punto v1) {
        V1 = v1;
    }

    public Punto getV2() {
        return V2;
    }

    public void setV2(Punto v2) {
        V2 = v2;
    }

    public Punto getV3() {
        return V3;
    }

    public void setV3(Punto v3) {
        V3 = v3;
    }


    public double getPerimetro() {
        double lado1 = V1.getDistancia(V2);  // Distancia entre V1 y V2
        double lado2 = V2.getDistancia(V3);  // Distancia entre V2 y V3
        double lado3 = V3.getDistancia(V1);  // Distancia entre V3 y V1
        return lado1 + lado2 + lado3;        // Sumar los tres lados para obtener el perímetro
    }

    public String getTipo() {
        double lado1 = V1.getDistancia(V2);  // Distancia entre V1 y V2
        double lado2 = V2.getDistancia(V3);  // Distancia entre V2 y V3
        double lado3 = V3.getDistancia(V1);  // Distancia entre V3 y V1

        // Comprobar si es un triángulo equilátero
        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        }
        // Comprobar si es un triángulo isósceles
        else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            return "Isósceles";
        }
        // Si no es equilátero ni isósceles, es escaleno
        else {
            return "Escaleno";
        }
    }

    @Override
    public String toString() {
        return "Triangulo [V1=" + V1 + ", V2=" + V2 + ", V3=" + V3 + "]";
    }

    

    
}
