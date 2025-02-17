package Figura;

public class Main {
    public static void main(String[] args) {
        Animal perroFirulais = new Perro();
        Animal gatoRamon = new Gato();
        perroFirulais.Sonido();
        System.out.printf("\n");
        gatoRamon.Sonido();
    }
}
