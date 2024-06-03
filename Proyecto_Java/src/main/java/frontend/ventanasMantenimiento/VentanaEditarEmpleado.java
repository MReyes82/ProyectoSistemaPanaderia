package frontend.ventanasMantenimiento;

import javax.swing.*;
import backend.modelos.herenciaEmpleados.Empleado;
import backend.modelos.herenciaEmpleados.Turno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEditarEmpleado extends JFrame {

    private JTextField idField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField edadField;
    private JTextField salarioField;
    private JComboBox<Turno> turnoComboBox;
    private JButton aceptarButton;
    private JButton cancelarButton;

    private Empleado empleado;

    public VentanaEditarEmpleado(Empleado empleado) {
        this.empleado = empleado;

        // Configuración de la ventana
        setTitle("Editar Empleado");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear y añadir los componentes al panel
        panel.add(new JLabel("ID:"));
        idField = new JTextField(String.valueOf(empleado.getId()));
        idField.setEditable(false);
        panel.add(idField);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField(empleado.getNombre());
        nombreField.setEditable(false);
        panel.add(nombreField);

        panel.add(new JLabel("Apellido:"));
        apellidoField = new JTextField(empleado.getApellido());
        apellidoField.setEditable(false);
        panel.add(apellidoField);

        panel.add(new JLabel("Edad:"));
        edadField = new JTextField(String.valueOf(empleado.getEdad()));
        edadField.setEditable(false);
        panel.add(edadField);

        panel.add(new JLabel("Salario (por hora):"));
        salarioField = new JTextField(String.valueOf(empleado.getSalario()));
        panel.add(salarioField);

        panel.add(new JLabel("Turno:"));
        turnoComboBox = new JComboBox<>(Turno.values());
        turnoComboBox.setSelectedItem(empleado.getTurno());
        panel.add(turnoComboBox);

        aceptarButton = new JButton("Aceptar");
        aceptarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        aceptarButton.setBackground(new Color(0, 153, 0));
        aceptarButton.setForeground(Color.WHITE);
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aceptarCambios();
            }
        });
        panel.add(aceptarButton);

        cancelarButton = new JButton("Cancelar");
        cancelarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        cancelarButton.setBackground(new Color(204, 0, 0));
        cancelarButton.setForeground(Color.WHITE);
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(cancelarButton);

        // Añadir el panel a la ventana
        getContentPane().add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    private void aceptarCambios() 
    {
    	/*
    	 * Solo se pueden editar los campos de salario y turno del empleado.
    	 * Los demas campos como ID, nombre o Edad o tipo de empleado no se pueden cambiar
    	 * Porque no tienen mucho sentido y complicaria innecesariamente la implementacion.
    	 */
        try {
            double salario = Double.parseDouble(salarioField.getText());
            Turno turno = (Turno) turnoComboBox.getSelectedItem();

            // Validación básica
            if (salario < 0) {
                JOptionPane.showMessageDialog(this, "El salario debe ser un valor positivo", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Actualizar los datos del empleado
                empleado.setSalario(salario);
                empleado.setTurno(turno);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Empleado actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El salario debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
