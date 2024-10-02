package p104_PuntoCirculo;

public class Punto {
    int X,Y;

    public Punto() {
    }

    public Punto(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public double getDistancia(Punto otroPunto) {
        double dx = otroPunto.getX() - this.X;
        double dy = otroPunto.getY() - this.Y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    @Override
    public String toString() {
        return "Punto [X=" + X + ", Y=" + Y + "]";
    }

   
    


    
    
}


