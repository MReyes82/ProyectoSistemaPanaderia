package frontend.ventanasMantenimiento;

import javax.swing.*;
import backend.modelos.Producto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaProducto extends JFrame 
{
    public VentanaProducto(Producto producto) {
        setTitle("Detalles del Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelProducto = new JPanel();
        panelProducto.setLayout(new GridLayout(5, 2, 10, 10));
        panelProducto.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelProducto.add(new JLabel("ID:"));
        panelProducto.add(new JLabel(String.valueOf(producto.getId())));

        panelProducto.add(new JLabel("Nombre:"));
        panelProducto.add(new JLabel(producto.getNombre()));

        panelProducto.add(new JLabel("Precio:"));
        panelProducto.add(new JLabel(String.valueOf(producto.getPrecio())));

        panelProducto.add(new JLabel("Stock:"));
        panelProducto.add(new JLabel(String.valueOf(producto.getStock())));

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
                new VentanaEditarProducto(producto);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(btnEditar);
        panelBotones.add(btnCerrar);

        add(panelProducto, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }
}
