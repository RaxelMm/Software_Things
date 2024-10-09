package p110_CuentaBancariaV1;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldo){
        this.saldo=saldo;
    }

    public void deposita(double cantidad){
        saldo = saldo + cantidad;
    }

    public double getSaldo(){
        return saldo;
    }

    public boolean retirar(double cantidad){
        if (saldo >= cantidad){
            saldo = saldo - cantidad;
            return true;
        }
        return false;
    }
}
