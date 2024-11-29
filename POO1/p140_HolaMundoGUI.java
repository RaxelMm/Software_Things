import javax.swing.*;
import java.awt.*;

public class p140_HolaMundoGUI extends JFrame {
    private JLabel lbSaludo;

    public p140_HolaMundoGUI(){
        setLayout(null);
        lbSaludo = new JLabel("Hola Mundo");
        lbSaludo.setFont(new Font("Times New Roman",Font.BOLD+Font.ITALIC,60));
        lbSaludo.setBounds(10,20,400,60);
        add(lbSaludo);
        setTitle("Mi primer programa de interfaz grafica en java");
    }
    


    public static void main(String[] args) {
        p140_HolaMundoGUI app = new p140_HolaMundoGUI();

        app.setBounds(0,0,700,300);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

}