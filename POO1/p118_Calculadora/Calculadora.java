package p118_Calculadora;

public class Calculadora implements Calcular {

    @Override
    public void mostrarResultado(double resultado) {
        System.out.println(String.format("%.2f", resultado));
        
    }

    @Override
    public void restar(double x, double y) {
        double res = x-y;
        mostrarResultado(res);
        
    }

    @Override
    public void sumar(double x, double y) {
       double res = x + y;
       mostrarResultado(res);
        
    }

    @Override
    public void Dividir(double x, double y) {
        double res = x / y ;
        mostrarResultado(res);
        
    }

    @Override
    public void Multiplicar(double x, double y) {
        double res = x * y ;
        mostrarResultado(res);
        
    }
    

}
