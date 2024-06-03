package frontend.ventanasMantenimiento;

import javax.swing.*;

import backend.modelos.herenciaEmpleados.Empleado;
import backend.saves.Datos;
import backend.modelos.ModelosApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpleadoIDInputFrame extends JFrame {

    private JTextField idField;
    private JLabel messageLabel;

    public EmpleadoIDInputFrame() 
    {
        // Configuración del JFrame
        setTitle("Entrada de Identificador de Empleado");
        setSize(454, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Crear panel para los componentes
        JPanel panel = new JPanel();
        panel.setLayout(null); // Uso de null layout para posicionamiento absoluto

        // Campo de texto para ingresar el ID
        idField = new JTextField();
        idField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        idField.setBounds(72, 90, 300, 25); // Posición y tamaño
        panel.add(idField);

        // Etiqueta para mostrar mensajes
        messageLabel = new JLabel("", JLabel.CENTER);
        messageLabel.setBounds(50, 70, 300, 25); // Posición y tamaño
        panel.add(messageLabel);

        // Botón para enviar el ID
        JButton submitButton = new JButton("Enviar");
        submitButton.setFont(new Font("Dialog", Font.BOLD, 13));
        submitButton.setBackground(new Color(0, 153, 204));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(97, 138, 100, 30); // Posición y tamaño
        submitButton.addActionListener(new SubmitButtonListener());
        panel.add(submitButton);

        // Añadir panel al JFrame
        getContentPane().add(panel);

        JLabel lblNewLabel = new JLabel("Ingrese el identificador del empleado");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        lblNewLabel.setBounds(72, 48, 300, 25);
        panel.add(lblNewLabel);

        JButton BotonCancelar = new JButton("Cancelar");
        BotonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        BotonCancelar.setFont(new Font("Dialog", Font.BOLD, 13));
        BotonCancelar.setBackground(new Color(204, 0, 0));
        BotonCancelar.setForeground(Color.WHITE);
        BotonCancelar.setBounds(239, 139, 100, 30);
        panel.add(BotonCancelar);

        // Hacer visible el JFrame
        setVisible(true);
    }

    // Listener para el botón de enviar
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ModelosApp callbackModelosApp = new ModelosApp();
            String input = idField.getText();
            try {
                int id = Integer.parseInt(input);
                if (id >= 0) {
                    Empleado empleadoBusqueda = callbackModelosApp.buscarEmpleado(id);

                    if (empleadoBusqueda != null) {
                        new VentanaEmpleado(empleadoBusqueda);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El identificador debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Entrada invalida, Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
