/**
 * p89_ArregloAletorios - Genera 2 arreglos de numeros aletorios y los suma
 */
import java.util.Random;

public class p89_ArregloAletorios {
    public static void Mostrar(float[] x) {
        for (int i = 0; i < x.length; i++)
            System.out.print(x[i] + " ");
        System.out.println();
    }

    public static void GeneraAletorios(float[] x) {
        float min = 1.5f, max = 10.5f;
        Random rand = new Random();
        for (int i = 0; i < x.length; i++)
            x[i] = rand.nextFloat() * (max - min) + min;
    }
    public static void SumaArreglos(float[]x,float[]y,float[]z){
        for (int i = 0; i < x.length; i++)
            z[i]=x[i]+y[i];


    }

    public static void main(String[] args) {
        int MAX = 15;
        float[] f1 = new float[MAX];
        float[] f2 = new float[MAX];
        float[] f3 = new float[MAX];
        System.out.print("\033[H\033[2J");
        GeneraAletorios(f1);
        GeneraAletorios(f2);
        System.out.println("Arreglos de numeros aletorios");
        Mostrar(f1);
        Mostrar(f2);
        SumaArreglos(f1, f2, f3);
        System.out.println("la suma es");
        Mostrar(f3);
    }
}
