package frontend.ventanasMantenimiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import backend.modelos.Producto;
import backend.saves.Datos;
import backend.modelos.ModelosApp;

public class ProductoIDInputFrame extends JFrame
{
    private JTextField idField;
    private JLabel messageLabel;

    public ProductoIDInputFrame()
    {
    	// cargar datos de prueba
        //Datos.inicializarDatos();
        //Datos.cargarElementosTEST();


        // Configuración del JFrame
        setTitle("Entrada de Identificador de Producto");
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
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        submitButton.setBackground(new Color(0, 153, 204));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(97, 138, 100, 30); // Posición y tamaño
        submitButton.addActionListener(new SubmitButtonListener());
        panel.add(submitButton);

        // Añadir panel al JFrame
        getContentPane().add(panel);

        JLabel lblNewLabel = new JLabel("Ingrese el identificador del producto");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(85, 48, 268, 25);
        panel.add(lblNewLabel);

        JButton BotonCancelar = new JButton("Cancelar");
        BotonCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
        BotonCancelar.setBackground(new Color(204, 0, 0));
        BotonCancelar.setForeground(Color.WHITE);
        BotonCancelar.setBounds(239, 139, 100, 30);
        BotonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(BotonCancelar);

        setVisible(true);
    }

    public class SubmitButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ModelosApp callbackModelosApp = new ModelosApp();
            String input = idField.getText();

            try {
                int id = Integer.parseInt(input);
                Producto producto = callbackModelosApp.buscarProducto(id);

                if (producto != null)
                {
                    new VentanaProducto(producto);
                    dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Entrada invalida, Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
