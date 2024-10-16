package p111_CuentaBancariaV2;

public class CuentaDeAhorro extends CuentaBancaria {
    private double TasaInteres;

    public CuentaDeAhorro(double cantidad, double tasaintres) {
        super(cantidad);
        TasaInteres = tasaintres;
    }

    public void calcularInteres() {
        Saldo += Saldo * TasaInteres;
    }

    @Override
    public boolean retira(double cantidad) {
        if (Saldo >= cantidad) {

            Saldo -= cantidad;

            return true;
        } else

            return false;

    }

    @Override
    public String toString() {
    return "CuentaDeAhorro [ " + super.toString() + ", TasaInteres = " + TasaInteres + "]";
    }
}