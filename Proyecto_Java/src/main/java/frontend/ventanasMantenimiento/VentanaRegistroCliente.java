package frontend.ventanasMantenimiento;

import backend.modelos.Cliente;
import backend.saves.Datos;
import backend.modelos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class VentanaRegistroCliente extends JFrame {

    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField idField;
    private JTextField telefonoField;
    private JTextField puntosField;
    private JButton registrarButton;
    private JButton cancelarButton;

    public VentanaRegistroCliente() {
    	setResizable(false);
        // Configuración de la ventana
        setTitle("Registro de Cliente");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

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

        panel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        panel.add(telefonoField);

        panel.add(new JLabel("Puntos:"));
        puntosField = new JTextField();
        panel.add(puntosField);

        registrarButton = new JButton("Registrar");
        panel.add(registrarButton);

        cancelarButton = new JButton("Cancelar");
        panel.add(cancelarButton);

        // Añadir el panel a la ventana
        getContentPane().add(panel);

        // Añadir ActionListeners a los botones
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente clienteARegistrar = registrarCliente();
                
                // revisamos que no haya un id repetido en el hashmap.
                HashMap<Integer, Cliente> lookUp = Datos.getTablaLookUpClientes();
                
                if (lookUp.containsKey(clienteARegistrar.getId()) )
                {
                	JOptionPane.showMessageDialog(null, "ERROR: EL ID PROPORCIONADO YA ESTA EN USO.", "Error", JOptionPane.ERROR_MESSAGE);
                	dispose();
                }
                
                ModelosApp callbackModelosApp = new ModelosApp();
                callbackModelosApp.registrarCliente(clienteARegistrar.getId(), 
                									clienteARegistrar.getNombre(), 
                									clienteARegistrar.getApellido(),
                									clienteARegistrar.getPuntos(),
                									clienteARegistrar.getTelefono());
                
                limpiarCampos();
                dispose();
                
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private Cliente registrarCliente() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String telefono = telefonoField.getText();
            double puntos = Double.parseDouble(puntosField.getText());

            // Validación básica
            if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || id < 0 || puntos < 0) {
                JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos y ser válidos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Crear un objeto Cliente
                Cliente cliente = new Cliente(id, nombre, apellido, telefono, puntos);
                //JOptionPane.showMessageDialog(this, "Cliente registrado con éxito:" + cliente.getNombreCompleto() + "\n", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                
                return cliente;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID y Puntos deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }

    private void limpiarCampos() {
        idField.setText("");
        nombreField.setText("");
        apellidoField.setText("");
        telefonoField.setText("");
        puntosField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaRegistroCliente().setVisible(true);
            }
        });
    }
}
