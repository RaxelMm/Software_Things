import java.util.Random;

public class p93_ParesImpares {

    // Mostrar elementos del arreglo
    public static void Mostrar(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    // Generar números aleatorios entre 0 y 20 y rellenar el arreglo
    public static void GeneraAletorios(int[] x) {
        int min = 0, max = 20;
        Random rand = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = rand.nextInt(max - min + 1) + min; // Generar aleatorios entre 0 y 20
        }
    }

    // Mostrar los elementos pares y contarlos
    public static int MostrarPares(int[] x) {
        int countPares = 0;
        System.out.println("Elementos pares:");
        for (int i = 0; i < x.length; i++) {
            if (x[i] % 2 == 0) { // Verificar si es par
                System.out.print(x[i] + " ");
                countPares++;
            }
        }
        System.out.println();
        return countPares; // Retornar la cantidad de pares
    }

    // Mostrar los elementos impares y contarlos
    public static int MostrarImpares(int[] x) {
        int countImpares = 0;
        System.out.println("Elementos impares:");
        for (int i = 0; i < x.length; i++) {
            if (x[i] % 2 != 0) { // Verificar si es impar
                System.out.print(x[i] + " ");
                countImpares++;
            }
        }
        System.out.println();
        return countImpares; // Retornar la cantidad de impares
    }

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); // Limpiar consola (opcional)

        int MAX = 100;
        int[] a = new int[MAX];
        int[] b = new int[MAX]; // No se usa el arreglo b, pero lo declaramos según la especificación

        // Generar números aleatorios y rellenar el arreglo a[]
        GeneraAletorios(a);

        // Mostrar todos los elementos del arreglo a[]
        System.out.println("Elementos del arreglo a[]:");
        Mostrar(a);

        // Mostrar y contar los elementos pares
        int countPares = MostrarPares(a);
        System.out.println("Cantidad de elementos pares: " + countPares);

        // Mostrar y contar los elementos impares
        int countImpares = MostrarImpares(a);
        System.out.println("Cantidad de elementos impares: " + countImpares);
    }
}
