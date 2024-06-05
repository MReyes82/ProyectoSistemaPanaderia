package frontend.ventanasMantenimiento;

import javax.swing.*;
import backend.modelos.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEditarCliente extends JFrame {

    private JTextField idField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField telefonoField;
    private JTextField puntosField;
    private JButton aceptarButton;
    private JButton cancelarButton;

    private Cliente cliente;

    public VentanaEditarCliente(Cliente cliente)
    {
        this.cliente = cliente;

        // Configuración de la ventana
        setTitle("Editar Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear y añadir los componentes al panel
        panel.add(new JLabel("ID:"));
        idField = new JTextField(String.valueOf(cliente.getId()));
        idField.setEditable(false);
        panel.add(idField);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField(cliente.getNombre());
        nombreField.setEditable(false);
        panel.add(nombreField);

        panel.add(new JLabel("Apellido:"));
        apellidoField = new JTextField(cliente.getApellido());
        apellidoField.setEditable(false);
        panel.add(apellidoField);

        panel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField(cliente.getTelefono());
        panel.add(telefonoField);

        panel.add(new JLabel("Puntos:"));
        puntosField = new JTextField(String.valueOf(cliente.getPuntos()));
        panel.add(puntosField);

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

    private void aceptarCambios() {
        try {
            String telefono = telefonoField.getText();
            double puntos = Double.parseDouble(puntosField.getText());

            // Validación básica
            if (telefono.isEmpty() || puntos < 0) {
                JOptionPane.showMessageDialog(this, "El teléfono debe estar lleno y los puntos deben ser valores positivos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Actualizar los datos del cliente
                cliente.setTelefono(telefono);
                cliente.setPuntos(puntos);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Cliente actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Puntos debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
