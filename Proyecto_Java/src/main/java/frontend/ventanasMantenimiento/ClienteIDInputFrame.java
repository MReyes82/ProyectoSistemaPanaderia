package frontend.ventanasMantenimiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import backend.modelos.Cliente;
import backend.saves.Datos;
import backend.modelos.ModelosApp;



public class ClienteIDInputFrame extends JFrame
{
    private JTextField idField;
    private JLabel messageLabel;

    public ClienteIDInputFrame()
    {
        setTitle("Entrada de Identificador de Cliente");
        setSize(454, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        idField = new JTextField();
        idField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        idField.setBounds(69, 90, 300, 25);
        panel.add(idField);

        messageLabel = new JLabel("", JLabel.CENTER);
        messageLabel.setBounds(50, 70, 300, 25);
        panel.add(messageLabel);

        JButton submitButton = new JButton("Enviar");
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        submitButton.setBackground(new Color(0, 153, 204));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(97, 138, 100, 30);
        submitButton.addActionListener(new SubmitButtonListener());
        panel.add(submitButton);

        getContentPane().add(panel);

        JLabel lblNewLabel = new JLabel("Ingrese el identificador del cliente");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(85, 48, 268, 25);
        panel.add(lblNewLabel);

        JButton BotonCancelar = new JButton("Cancelar");
        BotonCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
        BotonCancelar.setBackground(new Color(204, 0, 0));
        BotonCancelar.setForeground(Color.WHITE);
        BotonCancelar.setBounds(207, 138, 100, 30);
        BotonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(BotonCancelar);

        setVisible(true);
    }

    private class SubmitButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ModelosApp callbackModelosApp = new ModelosApp();
            String input = idField.getText();

            try {
                int id = Integer.parseInt(input);

                if (id >= 0) {
                    Cliente clienteBusqueda = callbackModelosApp.buscarCliente(id);

                    if (clienteBusqueda != null) {
                        new VentanaCliente(clienteBusqueda);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese identificador", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El identificador debe ser un valor positivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El identificador debe ser un número entero válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
