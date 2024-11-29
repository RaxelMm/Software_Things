import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class p142_LeyDeNewtonGUI extends JFrame implements ActionListener, ChangeListener {
    JPanel p1;
    JLabel lblFuerza, lblMasa, lblAceleracion;
    JTextField txtFuerza, txtMasa, txtAceleracion;
    ButtonGroup grpOpciones;
    JRadioButton rbtFuerza, rbtMasa, rbtAceleracion;
    JButton btnCalcular, btnSalir;

    public p142_LeyDeNewtonGUI() {
        super("Calcular la 2da Ley de Newton");
        setLayout(new FlowLayout());

        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 2));

        lblFuerza = new JLabel("Fuerza: ", JLabel.RIGHT);
        txtFuerza = new JTextField();
        lblMasa = new JLabel("Masa: ", JLabel.RIGHT);
        txtMasa = new JTextField();
        lblAceleracion = new JLabel("Aceleración: ", JLabel.RIGHT);
        txtAceleracion = new JTextField();

        p1.add(lblFuerza); 
        p1.add(txtFuerza);
        p1.add(lblMasa); 
        p1.add(txtMasa);
        p1.add(lblAceleracion); 
        p1.add(txtAceleracion);

        grpOpciones = new ButtonGroup();
        rbtFuerza = new JRadioButton("Fuerza");
        rbtMasa = new JRadioButton("Masa");
        rbtAceleracion = new JRadioButton("Aceleración");

        grpOpciones.add(rbtFuerza); 
        grpOpciones.add(rbtMasa); 
        grpOpciones.add(rbtAceleracion);

        p1.add(rbtFuerza); 
        p1.add(rbtMasa); 
        p1.add(rbtAceleracion);

        add(p1);

        btnCalcular = new JButton("Calcular");
        btnSalir = new JButton("Salir");
        add(btnCalcular);
        add(btnSalir);

        rbtFuerza.addChangeListener(this);
        rbtMasa.addChangeListener(this);
        rbtAceleracion.addChangeListener(this);

        btnCalcular.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        txtFuerza.setEnabled(true);
        txtMasa.setEnabled(true);
        txtAceleracion.setEnabled(true);

        if (rbtFuerza.isSelected()) {
            txtFuerza.setEnabled(false);
        } else if (rbtMasa.isSelected()) {
            txtMasa.setEnabled(false);
        } else if (rbtAceleracion.isSelected()) {
            txtAceleracion.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float f, m, a;

        if (e.getSource() == btnCalcular) {
            try {
                if (rbtFuerza.isSelected()) {
                    m = Float.parseFloat(txtMasa.getText());
                    a = Float.parseFloat(txtAceleracion.getText());
                    f = m * a;
                    txtFuerza.setText(String.format("%.2f", f));
                } else if (rbtMasa.isSelected()) {
                    f = Float.parseFloat(txtFuerza.getText());
                    a = Float.parseFloat(txtAceleracion.getText());
                    m = f / a;
                    txtMasa.setText(String.format("%.2f", m));
                } else if (rbtAceleracion.isSelected()) {
                    f = Float.parseFloat(txtFuerza.getText());
                    m = Float.parseFloat(txtMasa.getText());
                    a = f / m;
                    txtAceleracion.setText(String.format("%.2f", a));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Faltan valores", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnSalir) {
            dispose();
        }
    }

    public static void main(String[] args) {
       p142_LeyDeNewtonGUI app = new p142_LeyDeNewtonGUI();
        app.setBounds(10, 10, 300, 200);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
