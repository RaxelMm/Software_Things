    package p120_Vehiculo;

    public class App {
        public static void main(String[] args) {
            System.out.print("\033[H\033[2J"); System.out.flush(); // Borrar pantalla de la consola
            Sedan mSedan = new Sedan("Vochito", "Maria Diaz", 4);
            Suv mSuv = new Suv("La mamalona","Carlos Castañeda" , 6);
            
            System.out.println(mSedan.toString());
            mSedan.toString();
            mSedan.sistemaElectrico();
            mSedan.combustionInterna();
            mSedan.carroceriaTres();
            mSedan.chasisMonocasco();
            mSedan.repostar();
            mSedan.arrancar();
            mSedan.frenar();
            System.out.println("");

            System.out.println(mSuv.toString());
            mSuv.sistemaElectrico();
            mSuv.combustionInterna();
            mSuv.traccion4x4();
            mSuv.chasisIndependiente();
            mSuv.repostar();
            mSuv.arrancar();
            mSuv.frenar();
           
            
        }

}
