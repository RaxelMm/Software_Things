
/**
 * ep01_PrimerExamenParcial - Una escuela ha organizado un curso de técnicas avanzadas de programación y desea llevar el control de la
inscripción de los participantes y el dinero recaudado.
 */
import java.util.Scanner;

public class ep01_PrimerExamenParcial {
    public static void main(String[] args) {
        int edad = 0, alumnos = 0, docente = 0, trabajador = 0, suma = 0, rechazado = 0, hombre = 0, mujer = 0,
                participante = 0, totalA = 0, TotalD = 0, TotalT = 0, totalP = 0;
        char sexo, tipo, op;
        Scanner teclado = new Scanner(System.in);
        do {
            String nombre;
            System.out.print("\033[H\033[2J");
            System.out.flush(); // Borrar pantalla de la consola

            System.out.println("Deme el nombre");
            nombre = teclado.next();
            System.out.println("Bienvenido de que se quiere inscribir - [A]lumno , [D]ocente , [T]rabajador ");
            System.out.println("No hay devoluciones si usted es rechazado");
            tipo = Character.toUpperCase(teclado.next().charAt(0));

            switch (tipo) {
                case 'A':
                    ;
                    alumnos++;
                    break;
                case 'D':
                    ;
                    docente++;
                    break;
                case 'T':
                    ;
                    trabajador++;
                    break;

                default:
                    break;
            }

            System.out.println("Deme su edad");
            edad = teclado.nextInt();
            suma += edad;

            if (edad >= 23) {
                System.out.println("Continuando");

                participante++;

            } else if (edad < 23) {
                System.out.println("Usted fue rechazado");
                rechazado++;
            }
            System.out.println("Que sexo eres [H]ombre o [M]ujer");
            sexo = Character.toUpperCase(teclado.next().charAt(0));
            switch (sexo) {
                case 'H':
                    hombre++;
                    break;
                case 'M':
                    mujer++;
                    break;

                default:
                    break;
            }
            System.out.println("Se inscribira otra persona? [S]i o [N]o ");
            op = Character.toUpperCase(teclado.next().charAt(0));

        } while (op != 'N');

        System.out.println("Total de alumnos: " + alumnos);
        System.out.println("Total de Docentes: " + docente);
        System.out.println("Total de Trabajadores: " + trabajador);
        System.out.println("Total de hombre: " + hombre);
        System.out.println("Total de mujeres: " + mujer);
        if (participante == 0) {
            System.out.println("NO hay promedio de edades");
        } else {
            System.out.println("Promedio de edades: " + suma / participante);
        }
        System.out.println("Total de Participantes: " + participante);
        System.out.println("Total de rechazados: " + rechazado);
        totalA = (alumnos * 40);
        TotalD = (docente * 60);
        TotalT = (trabajador * 80);
        totalP = (totalA + TotalD + TotalT);
        System.out.println("Total, dinero recaudado de Alumnos: " + totalA);
        System.out.println("Total, dinero recaudado de Docentes: " + TotalD);
        System.out.println("Total, dinero recaudado de Trabajadores: " + TotalT);
        System.out.println("Total, dinero recaudado de Participantes: " + totalP);

        if (totalP < 50) {
            System.out.println(" El evento concluye con ganancias BAJAS");
        } else if (totalP > 50 && totalP < 100) {
            System.out.println(" El evento concluye con ganancias MODERADAS");
        } else {
            System.out.println(" El evento concluye con BUENAS ganancias.");
        }

    }

}
