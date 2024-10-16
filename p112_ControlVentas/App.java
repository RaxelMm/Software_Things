package p112_ControlVentas;

public class App {
    public static void main(String[] args) {
        Tienda mitienda = new Tienda("Eshop", "Luis", "AV mexico");

        mitienda.agregarCliente(new Cliente(" Felipe ", "Calle San Luis", "luisa32917@gmail.com"));
        mitienda.agregarCliente(new Cliente(" Marta ", "AV quintas", "marta3129@gmail.com"));
        mitienda.agregarCliente(new Cliente(" Luis ", "Calle zepedo", "9bdsai1epiosjvs@gmail.com"));
        mitienda.agregarCliente(new Cliente(" Monica ", "Centro", "monicacv@gmail.com"));
        mitienda.getClientes().get(0).agregarVenta(new VentaContado("MARTILLO", 10, 60.312, 0.10, "Sacabocados"));
        mitienda.getClientes().get(0).agregarVenta(new VentaCredito("PALA", 2, 1170, 3, 0.10));
        System.out.print("\033[H\033[2J"); 


        mitienda.reporte();
        
    }

}
