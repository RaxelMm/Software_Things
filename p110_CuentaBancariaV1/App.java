package p110_CuentaBancariaV1;

public class App {
    public static void main(String[] args) {
        
        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
        CuentaBancaria c1 = new CuentaBancaria(5000);

        System.out.println("Saldo inicial: " + c1.getSaldo());
        c1.deposita(10000);
        System.out.println("Saldo despues del 1er deposito "+c1.getSaldo());
        double cr = 400;
        boolean rsn = c1.retirar(cr);
        if(rsn) System.out.println("Retiraste  "+ cr + " te quedan " + c1.getSaldo());
        else System.out.println("No tienes dinero");

        System.out.println("Clase cliente");

        Cliente cl1 = new Cliente("Juan Perez", c1);

        System.out.println("Cliente 1 "+cl1);

        Cliente cl2 = new Cliente("Carlos Castañeda", new CuentaBancaria(1000));

        System.out.println(cl2);
        cl2.getCuenta().retirar(900);

        System.out.println(cl2);

        cl1.getCuenta().retirar(9000);
        System.out.println(cl1);
        cl2.getCuenta().deposita(10000);
        System.out.println(cl2);

        Cliente mujer = new Cliente("Rocio", cl2.getCuenta());
        mujer.getCuenta().retirar(10100);
        System.out.println(cl2);

        System.out.println("Probando clase banco");
        double total = 0;

        Banco mibanco = new Banco("Bienestar", "Siglo XXI");

        mibanco.agregarCliente(cl1);
        mibanco.agregarCliente(cl2);
        mibanco.agregarCliente(mujer);
        mibanco.agregarCliente(new Cliente("Claudia ", new CuentaBancaria(1000000)));
        mibanco.getClientes().get(3).getCuenta().retirar(100000);

        mibanco.getClientes().get(0).getCuenta().deposita(30000);
        mibanco.getClientes().get(1).getCuenta().deposita(30000);
        mibanco.getClientes().get(2).getCuenta().deposita(30000);
        System.out.println("Los clientes del banco");

        for (Cliente cte : mibanco.getClientes()){
            System.out.println(cte);
            total = total + cte.getCuenta().getSaldo();
        }
        System.out.printf("Total de dinero en el banco %,.2f ",total);
        

    }

}
