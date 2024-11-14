package p147_TercerExamenParcial;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

public class App extends JFrame implements ActionListener {
    ArrayList<Jugador> datos;
    JMenuBar menuBar;
    JMenu mnuArchivo, mnuAyuda;
    JMenuItem smnAbrir, smnSalir, smnAcercade, smnGuardar;
    JPanel pnlTabla, pnlDatos, pnlBotones;
    JDialog jdlAcercaDe;
    JLabel lblNombre, lblEdad, lblSexo, lblEstadoCivil, lblDescripcion, lblSalario;
    JTextField txtNombre, txtEdad, txtSalario;
    JComboBox<String> cbSexo, cbEstadoCivil;
    JTextArea txtDescripcion;
    JScrollPane spane;
    JTable table;
    DefaultTableModel modelo;
    JFileChooser fchArchivo;
    JButton btnAgregar, btnGrabar;

    public App() {
        super("Liga de Fútbol - Gestión de Jugadores");
        datos = Util.inicializarDatos();

    
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        mnuArchivo = new JMenu("Archivo");
        menuBar.add(mnuArchivo);
        smnAbrir = new JMenuItem("Abrir");
        smnAbrir.addActionListener(this);
        mnuArchivo.add(smnAbrir);
        smnGuardar = new JMenuItem("Guardar");
        smnGuardar.addActionListener(this);
        mnuArchivo.add(smnGuardar);
        smnSalir = new JMenuItem("Salir");
        smnSalir.addActionListener(this);
        mnuArchivo.add(smnSalir);

        mnuAyuda = new JMenu("Ayuda");
        menuBar.add(mnuAyuda);
        smnAcercade = new JMenuItem("Acerca de ..");
        smnAcercade.addActionListener(this);
        mnuAyuda.add(smnAcercade);
      pnlTabla = new JPanel(new BorderLayout());
        modelo = new DefaultTableModel(new String[]{"Nombre", "Edad", "Sexo", "Estado Civil", "Descripción", "Salario"}, 0);
        table = new JTable(modelo);
        cargarDatos();
        pnlTabla.add(new JScrollPane(table));
        add(pnlTabla, BorderLayout.NORTH);

       
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow(); 
                if (row >= 0) {
                    txtNombre.setText((String) modelo.getValueAt(row, 0));
                    txtEdad.setText(modelo.getValueAt(row, 1).toString());
                    cbSexo.setSelectedItem(modelo.getValueAt(row, 2).toString());
                    cbEstadoCivil.setSelectedItem(modelo.getValueAt(row, 3).toString());
                    txtDescripcion.setText((String) modelo.getValueAt(row, 4));
                    txtSalario.setText(modelo.getValueAt(row, 5).toString());
                }
            }
        });

        // Formulario
        pnlDatos = new JPanel(new GridLayout(6, 2));
        pnlDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        pnlDatos.add(txtNombre);

        pnlDatos.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        pnlDatos.add(txtEdad);

        pnlDatos.add(new JLabel("Sexo:"));
        cbSexo = new JComboBox<>(new String[]{"M", "F"});
        pnlDatos.add(cbSexo);

        pnlDatos.add(new JLabel("Estado Civil:"));
        cbEstadoCivil = new JComboBox<>(new String[]{"Soltero", "Casado"});
        pnlDatos.add(cbEstadoCivil);

        pnlDatos.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextArea(3, 20);
        pnlDatos.add(new JScrollPane(txtDescripcion));

        pnlDatos.add(new JLabel("Salario:"));
        txtSalario = new JTextField();
        pnlDatos.add(txtSalario);

        add(pnlDatos, BorderLayout.CENTER);

        // Botones
        pnlBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(this);
        pnlBotones.add(btnAgregar);

        btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(this);
        pnlBotones.add(btnGrabar);

        add(pnlBotones, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
    }

    private void cargarDatos() {
        modelo.setRowCount(0);
        for (Jugador j : datos) {
            modelo.addRow(new Object[]{
                j.getNombre(),
                j.getEdad(),
                j.getSexo(),
                j.getEstadoCivil(),
                j.getDescripcion(),
                j.getSalario()
            });
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == smnSalir) {
            dispose();
        } else if (e.getSource() == smnAbrir) {
            fchArchivo = new JFileChooser();
            fchArchivo.setFileFilter(new FileNameExtensionFilter("Archivos de datos (.dat)", "dat"));
            if (fchArchivo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    datos = Util.desSerializarDatos(fchArchivo.getSelectedFile().getAbsolutePath());
                    cargarDatos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al abrir el archivo.");
                }
            }
        } else if (e.getSource() == smnGuardar) {
            fchArchivo = new JFileChooser();
            fchArchivo.setFileFilter(new FileNameExtensionFilter("Archivos de datos (.dat)", "dat"));
            if (fchArchivo.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    Util.serializarDatos(fchArchivo.getSelectedFile().getAbsolutePath(), datos);
                    JOptionPane.showMessageDialog(this, "Datos guardados exitosamente.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el archivo.");
                }
            }
        } else if (e.getSource() == smnAcercade) {
            JOptionPane.showMessageDialog(this, "Aplicación para la gestión de jugadores\nDesarrollado por Axel", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnAgregar) {
            Jugador j = new Jugador(
                txtNombre.getText(),
                Integer.parseInt(txtEdad.getText()),
                cbSexo.getSelectedItem().toString().charAt(0),
                cbEstadoCivil.getSelectedItem().toString(),
                txtDescripcion.getText(),
                Double.parseDouble(txtSalario.getText())
            );
            datos.add(j);
            cargarDatos();
        }
    }

    public static void main(String[] args) {
        new App().setVisible(true);
    }
}
