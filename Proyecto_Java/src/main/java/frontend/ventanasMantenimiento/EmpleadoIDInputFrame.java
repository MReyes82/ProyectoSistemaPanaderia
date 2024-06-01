package frontend.ventanasMantenimiento;

import javax.swing.*;

import backend.modelos.herenciaEmpleados.Empleado;
import backend.modelos.ModelosApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpleadoIDInputFrame extends JFrame {

    private JTextField idField;
    private JLabel messageLabel;

    public EmpleadoIDInputFrame() {
        // Configuración del JFrame
        setTitle("Entrada de Identificador de Empleado");
        setSize(454, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear panel para los componentes
        JPanel panel = new JPanel();
        panel.setLayout(null); // Uso de null layout para posicionamiento absoluto

        // Campo de texto para ingresar el ID
        idField = new JTextField();
        idField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        idField.setBounds(69, 90, 300, 25); // Posición y tamaño
        panel.add(idField);

        // Etiqueta para mostrar mensajes
        messageLabel = new JLabel("", JLabel.CENTER);
        messageLabel.setBounds(50, 70, 300, 25); // Posición y tamaño
        panel.add(messageLabel);

        // Botón para enviar el ID
        JButton submitButton = new JButton("Enviar");
        submitButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        submitButton.setBounds(169, 138, 100, 30); // Posición y tamaño
        submitButton.addActionListener(new SubmitButtonListener());
        panel.add(submitButton);

        // Añadir panel al JFrame
        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("Ingrese el identificador del empleado");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(85, 48, 268, 25);
        panel.add(lblNewLabel);

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
                	// Aquí puedes continuar con el flujo del programa usando el ID
                	Empleado empleadoBusqueda = callbackModelosApp.buscarEmpleado(id);
                	
                	if (empleadoBusqueda != null)
                	{
                		JOptionPane.showMessageDialog(null, "Resultado encontrado: " + empleadoBusqueda.toString() + "\n");
                	}
                	
                } else {
                	JOptionPane.showMessageDialog(null, "El identificador debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Entrada inválida. Por favor, ingrese un número entero.");
                messageLabel.setForeground(Color.RED);
            }
        }
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica en el hilo de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmpleadoIDInputFrame();
            }
        });
    }
}
