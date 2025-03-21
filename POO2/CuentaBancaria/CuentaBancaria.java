package CuentaBancaria;

public abstract class CuentaBancaria {
    String noCuenta;
    String titular;
    double saldo;

    public CuentaBancaria(String noCuenta, String titular, double saldo) {
        this.noCuenta = noCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }
    public void Depositar(double cantidad){
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Deposito realizado ; Saldo actual = " + saldo);
        }else{
            System.out.println("Usted no ha aumentado el saldo ");
        }
            
        }
    



        public abstract void Retirar (double cantidad);
}
