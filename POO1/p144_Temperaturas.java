import java.awt.*;
import java.awt.event.*;

public class p144_Temperaturas extends Frame implements ActionListener {
    // Componentes de la GUI
    TextField txtTemperatura;
    Label lblResultado;
    Button btnConvertir;
    CheckboxGroup opciones;
    Checkbox optCelsius, optFahrenheit;

    public p144_Temperaturas() {
        // Configuración del Frame
        setLayout(new FlowLayout());
        setTitle("Conversor de Temperaturas");
        setSize(350, 250);

        // Campo de entrada
        add(new Label("Ingrese la temperatura:"));
        txtTemperatura = new TextField(10);
        add(txtTemperatura);

        // Botones de radio para seleccionar la conversión
        opciones = new CheckboxGroup();
        optCelsius = new Checkbox("Convertir a Celsius", opciones, true);
        optFahrenheit = new Checkbox("Convertir a Fahrenheit", opciones, false);
        add(optCelsius);
        add(optFahrenheit);

        // Botón de conversión
        btnConvertir = new Button("Convertir");
        btnConvertir.addActionListener(this);
        add(btnConvertir);

        // Etiqueta para mostrar el resultado
        lblResultado = new Label("Resultado: ");
        add(lblResultado);

        // Configuración de ventana
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
            // Obtener el valor de la temperatura ingresada
            double temperatura = Double.parseDouble(txtTemperatura.getText());
            double resultado;

            // Determinar la conversión según la opción seleccionada
            if (optCelsius.getState()) {
                // Convertir de Fahrenheit a Celsius
                resultado = (temperatura - 32) * 5 / 9;
                lblResultado.setText("Resultado: " + String.format("%.2f", resultado) + " °C");
            } else {
                // Convertir de Celsius a Fahrenheit
                resultado = (temperatura * 9 / 5) + 32;
                lblResultado.setText("Resultado: " + String.format("%.2f", resultado) + " °F");
            }
        } catch (NumberFormatException ex) {
            // Manejo de errores si la entrada no es válida
            lblResultado.setText("Entrada inválida. Ingrese un número.");
        }
    }

    public static void main(String[] args) {
        new p144_Temperaturas();
    }
}
