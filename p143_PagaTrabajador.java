import java.awt.*;
import java.awt.event.*;

public class p143_PagaTrabajador extends Frame implements ActionListener {
    // Componentes de la GUI
    TextField txtHoras, txtPagaHora, txtTasaImpuesto;
    Label lblPagaBruta, lblImpuesto, lblPagaNeta;
    Button btnCalcular;

    public p143_PagaTrabajador() {
        // Configuración del Frame
        setLayout(new FlowLayout());
        setTitle("Calculadora de Paga de Trabajador");
        setSize(300, 300);

        // Componentes de entrada
        add(new Label("Horas trabajadas:"));
        txtHoras = new TextField(10);
        add(txtHoras);

        add(new Label("Paga por hora:"));
        txtPagaHora = new TextField(10);
        add(txtPagaHora);

        add(new Label("Tasa de impuestos (%):"));
        txtTasaImpuesto = new TextField(10);
        add(txtTasaImpuesto);

        // Botón para calcular
        btnCalcular = new Button("Calcular");
        btnCalcular.addActionListener(this);
        add(btnCalcular);

        // Etiquetas de salida
        lblPagaBruta = new Label("Paga Bruta: ");
        add(lblPagaBruta);

        lblImpuesto = new Label("Impuesto: ");
        add(lblImpuesto);

        lblPagaNeta = new Label("Paga Neta: ");
        add(lblPagaNeta);

        // Configuración final
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Método para manejar el evento del botón
    public void actionPerformed(ActionEvent e) {
        try {
            // Obtener valores de entrada
            double horas = Double.parseDouble(txtHoras.getText());
            double pagaHora = Double.parseDouble(txtPagaHora.getText());
            double tasaImpuesto = Double.parseDouble(txtTasaImpuesto.getText());

            // Calcular paga bruta, impuesto y paga neta
            double pagaBruta = horas * pagaHora;
            double impuesto = pagaBruta * (tasaImpuesto / 100);
            double pagaNeta = pagaBruta - impuesto;

            // Mostrar resultados
            lblPagaBruta.setText("Paga Bruta: " + String.format("%.2f", pagaBruta));
            lblImpuesto.setText("Impuesto: " + String.format("%.2f", impuesto));
            lblPagaNeta.setText("Paga Neta: " + String.format("%.2f", pagaNeta));
        } catch (NumberFormatException ex) {
            // Manejo de errores si la entrada no es válida
            lblPagaBruta.setText("Entrada inválida");
            lblImpuesto.setText("");
            lblPagaNeta.setText("");
        }
    }

    public static void main(String[] args) {
        new p143_PagaTrabajador();
    }
}
