package p146_EstudianteGUI_V2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class App extends JFrame implements ActionListener {
    ArrayList<Estudiante> datos;
    JMenuBar menuBar;
    JMenu mnuArchivo, mnuAyuda;
    JMenuItem smnAbrir, smnSalir, smnAcercade, smnGuardar;
    JPanel pnlTabla, pnlDatos, pnlBotones;
    JDialog jdlAcercaDe;
    JLabel lblDatos, lblNombre, lblEdad, lblPeso, lblCorreo;
    JTextField txtNombre, txtEdad, txtPeso, txtCorreo;
    JScrollPane spane;
    JTable table;
    DefaultTableModel modelo;
    JFileChooser fchArchivo;
    JButton btnAgregar, btnGrabar;

    public App() {
        super("Datos de Estudiantes");
        datos = new ArrayList<>();
        
        // Configuración del menú
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        mnuArchivo = new JMenu("Archivo");
        menuBar.add(mnuArchivo);
        smnAbrir = new JMenuItem("Abrir");
        smnAbrir.addActionListener(this);
        mnuArchivo.add(smnAbrir);
        smnSalir = new JMenuItem("Salir");
        smnSalir.addActionListener(this);
        smnGuardar = new JMenuItem("Guardar");
        mnuArchivo.add(smnGuardar);
        smnGuardar.addActionListener(this);
        mnuArchivo.add(new JSeparator());
        mnuArchivo.add(smnSalir);

        mnuAyuda = new JMenu("Ayuda");
        menuBar.add(mnuAyuda);
        smnAcercade = new JMenuItem("Acerca de ..");
        mnuAyuda.add(smnAcercade);
        smnAcercade.addActionListener(this);

        // Configuración del diálogo "Acerca de"
        jdlAcercaDe = new JDialog(this, "Acerca de ..");
        jdlAcercaDe.setSize(300, 250);
        jdlAcercaDe.setLocationRelativeTo(null);
        lblDatos = new JLabel("<html>Programación Orientada a Objetos I<br>CAxel Marquez</html>", JLabel.CENTER);
        lblDatos.setFont(new Font("Times New Roman", Font.BOLD, 18));
        jdlAcercaDe.add(lblDatos);

        setLayout(new GridLayout(3, 1));

        // Panel de la tabla
        pnlTabla = new JPanel();
        pnlTabla.setLayout(new BoxLayout(pnlTabla, BoxLayout.X_AXIS));
        add(pnlTabla);

        spane = new JScrollPane();
        spane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        pnlTabla.add(spane);

        table = new JTable();
        table.getTableHeader().setBackground(Color.yellow);
        table.getTableHeader().setForeground(Color.black);
        spane.setViewportView(table);
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Nombre", "Edad", "Peso", "Correo"});
        table.setModel(modelo);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int ren = table.rowAtPoint(e.getPoint());
                mostrarDatos(ren);
            }
        });

        // Panel de datos
        pnlDatos = new JPanel();
        add(pnlDatos);
        pnlDatos.setLayout(new GridLayout(4, 2, 0, 0));

        lblNombre = new JLabel("Nombre", SwingConstants.RIGHT);
        txtNombre = new JTextField();
        pnlDatos.add(lblNombre);
        pnlDatos.add(txtNombre);

        lblEdad = new JLabel("Edad", SwingConstants.RIGHT);
        txtEdad = new JTextField();
        pnlDatos.add(lblEdad);
        pnlDatos.add(txtEdad);

        lblPeso = new JLabel("Peso", SwingConstants.RIGHT);
        txtPeso = new JTextField();
        pnlDatos.add(lblPeso);
        pnlDatos.add(txtPeso);

        lblCorreo = new JLabel("Correo:", SwingConstants.RIGHT);
        txtCorreo = new JTextField();
        pnlDatos.add(lblCorreo);
        pnlDatos.add(txtCorreo);

        // Panel de botones
        pnlBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(this);
        pnlBotones.add(btnAgregar);

        btnGrabar = new JButton("Grabar");
        btnGrabar.setEnabled(false);
        btnGrabar.addActionListener(this);
        pnlBotones.add(btnGrabar);
        add(pnlBotones);
    }

    public void cargarDatos() {
        modelo.setRowCount(0);
        Object[] obj = new Object[4];
        for (Estudiante est : datos) {
            obj[0] = est.getNombre();
            obj[1] = est.getEdad();
            obj[2] = est.getPeso();
            obj[3] = est.getCorreo();
            modelo.addRow(obj);
        }
    }

    public void mostrarDatos(int ren) {
        txtNombre.setText(datos.get(ren).getNombre());
        txtEdad.setText(Integer.toString(datos.get(ren).getEdad()));
        txtPeso.setText(Double.toString(datos.get(ren).getPeso()));
        txtCorreo.setText(datos.get(ren).getCorreo());
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtCorreo.setText("");
    }

    public void guardarCampos() {
        Estudiante est = new Estudiante();
        est.setNombre(txtNombre.getText());
        est.setEdad(Integer.parseInt(txtEdad.getText()));
        est.setPeso(Double.parseDouble(txtPeso.getText()));
        est.setCorreo(txtCorreo.getText());
        datos.add(est);
        cargarDatos();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == smnSalir) {
            dispose();
        } else if (e.getSource() == smnAcercade) {
            jdlAcercaDe.setVisible(true);
        } else if (e.getSource() == btnAgregar) {
            limpiarCampos();
            btnAgregar.setEnabled(false);
            btnGrabar.setEnabled(true);
        } else if (e.getSource() == btnGrabar) {
            guardarCampos();
            limpiarCampos();
            btnAgregar.setEnabled(true);
            btnGrabar.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.setBounds(10, 10, 550, 400);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
