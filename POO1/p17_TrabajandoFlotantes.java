/**
 * p17_TrabajandoFlotantes - Trabajando con numeros y literales de tipo flotante
 */
public class p17_TrabajandoFlotantes {
    public static void main(String[] args) {
        float num1 = 423.45f;
        float num2 = 123f;
        float num3 = 1.94e-8f;

        double num4 = 1232312321.424242d;
        double num5 = .3456;

        System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola

        System.out.println("\nUso de string.format para formateo de numeros flotantes:");
        System.out.println(String.format("num 1 y num 2 en formato flotante                          :%f       -      %f",num1, num2));
        System.out.println(String.format("num 1 y num 2 en formato flotante con decimales            :%.2f     -      %.3f",num1, num2));
        System.out.println(String.format("num 1 en formato flotante alineado                         :%10.2f",num1));
        System.out.println(String.format("num 2 en formato flotante alineado                         :%10.2f",num2));
        System.out.println(String.format("num 2 en formato flotante alineado                         :%10.2f",num2));
        System.out.println(String.format("num 3 en formato exponencial                               :%e",num3));
        System.out.println(String.format("num 3 en formato exponencial cifras                        :%.3e",num3));
        System.out.println(String.format("num 4 con separacion de miles y de decimales               :%,.2f",num4));

        System.out.println("\nUso de string.out.printf para formateo de numeros flotantes:");
        System.out.printf("num 1 y num 2 en formato flotante                          :%f        -      %f\n",num1, num2);
        System.out.printf("num 3 y num 4 en formato flotante con decimales            :%.10f     -      %.2f\n",num3, num4);
        System.out.printf("num 4 y num 5 en formato exponencial                       :%e        -      %e\n",num4, num5);
        System.out.printf("num 4 y num 5 en formato exponencial con decimales         :%.2e      -      %.2e\n",num4, num5);


        System.out.println("\nUso MIN_VALUE y MAX_VALUE conocer los rangos de los números enteros: ");
        System.out.println(String.format("\nTipo: float Min: %.1e Max: %.1e",Float.MIN_VALUE, Float.MAX_VALUE));
        System.out.println(String.format("\nTipo: double Min: %e Max: %e",Double.MIN_VALUE, Double.MAX_VALUE));



        


    }

    
}
