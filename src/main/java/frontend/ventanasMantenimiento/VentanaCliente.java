package frontend.ventanasMantenimiento;

import javax.swing.*;
import backend.modelos.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCliente extends JFrame 
{
    public VentanaCliente(Cliente cliente) {
        setTitle("Detalles del Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelCliente = new JPanel();
        panelCliente.setLayout(new GridLayout(6, 2, 10, 10));
        panelCliente.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelCliente.add(new JLabel("ID:"));
        panelCliente.add(new JLabel(String.valueOf(cliente.getId())));

        panelCliente.add(new JLabel("Nombre:"));
        panelCliente.add(new JLabel(cliente.getNombre()));

        panelCliente.add(new JLabel("Apellido:"));
        panelCliente.add(new JLabel(cliente.getApellido()));

        panelCliente.add(new JLabel("Teléfono:"));
        panelCliente.add(new JLabel(cliente.getTelefono()));

        panelCliente.add(new JLabel("Puntos:"));
        panelCliente.add(new JLabel(String.valueOf(cliente.getPuntos())));

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCerrar.setBackground(new Color(204, 0, 0));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEditar.setBackground(new Color(0, 153, 204));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaEditarCliente(cliente);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(btnEditar);
        panelBotones.add(btnCerrar);

        add(panelCliente, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }
}
