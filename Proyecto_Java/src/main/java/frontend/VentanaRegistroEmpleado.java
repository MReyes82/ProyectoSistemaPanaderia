package frontend;

import backend.modelos.herenciaEmpleados.Empleado;
import backend.modelos.herenciaEmpleados.Turno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistroEmpleado extends JFrame {

    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField idField;
    private JTextField edadField;
    private JTextField salarioField;
    private JComboBox<Turno> turnoComboBox;
    private JButton registrarButton;
    private JButton cancelarButton;

    public VentanaRegistroEmpleado() {
        // Configuración de la ventana
        setTitle("Registro de Empleado");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        // Crear y añadir los componentes al panel
        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        panel.add(apellidoField);

        panel.add(new JLabel("Edad:"));
        edadField = new JTextField();
        panel.add(edadField);

        panel.add(new JLabel("Salario (por hora):"));
        salarioField = new JTextField();
        panel.add(salarioField);

        panel.add(new JLabel("Turno:"));
        turnoComboBox = new JComboBox<>(Turno.values());
        panel.add(turnoComboBox);

        registrarButton = new JButton("Registrar");
        panel.add(registrarButton);

        cancelarButton = new JButton("Cancelar");
        panel.add(cancelarButton);

        // Añadir el panel a la ventana
        add(panel);

        // Añadir ActionListeners a los botones
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEmpleado();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void registrarEmpleado() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            int edad = Integer.parseInt(edadField.getText());
            double salario = Double.parseDouble(salarioField.getText());
            Turno turno = (Turno) turnoComboBox.getSelectedItem();

            // Validación básica
            if (nombre.isEmpty() || apellido.isEmpty() || id < 0 || edad < 0 || salario < 0) {
                JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos y ser válidos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Crear un objeto Empleado
                Empleado empleado = new Empleado(id, nombre, apellido, edad, salario, turno);
                JOptionPane.showMessageDialog(this, "Empleado registrado con éxito:\n" + empleado, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID, Edad y Salario deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        idField.setText("");
        nombreField.setText("");
        apellidoField.setText("");
        edadField.setText("");
        salarioField.setText("");
        turnoComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaRegistroEmpleado().setVisible(true);
            }
        });
    }
}