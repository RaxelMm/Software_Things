/**
 * p90_Temperaturas
 */
public class p90_Temperaturas {
    public static void Mostrar (double[] x){
        for(int i = 0; i<x.length ; i++)
            System.out.print(x[i] + " ");
        System.out.println();
    }
    public static void Cambiar (double[]x){
        for(int i = 0; i<x.length ; i++)
            if (x[i]>10){
                x[i]=0;

            }
               


    }
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        double [] temps = {2.34 ,44.56, 7.89, 0.5, 2.5, 4.67, 40.3, 22.35, 56.22};
        System.out.println("El primer elemento del arreglo es "+temps[0]);
        System.out.println("El tercer elemento del arreglo es "+temps[2]);
        System.out.println("Los elementos del arreglo son " );
        Mostrar(temps);
        System.out.println("Los numeros mayores a 10 ahora son ceros");
        Cambiar(temps);
        Mostrar(temps);
        



        
    }

    
}