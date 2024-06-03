package frontend.ventanasMantenimiento;

import javax.swing.*;
import backend.modelos.Producto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEditarProducto extends JFrame {

    private JTextField idField;
    private JTextField nombreField;
    private JTextField precioField;
    private JTextField stockField;
    private JButton aceptarButton;
    private JButton cancelarButton;

    private Producto producto;

    public VentanaEditarProducto(Producto producto) {
        this.producto = producto;

        // Configuración de la ventana
        setTitle("Editar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear y añadir los componentes al panel
        panel.add(new JLabel("ID:"));
        idField = new JTextField(String.valueOf(producto.getId()));
        idField.setEditable(false);
        panel.add(idField);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField(producto.getNombre());
        nombreField.setEditable(false);
        panel.add(nombreField);

        panel.add(new JLabel("Precio:"));
        precioField = new JTextField(String.valueOf(producto.getPrecio()));
        panel.add(precioField);

        panel.add(new JLabel("Stock:"));
        stockField = new JTextField(String.valueOf(producto.getStock()));
        panel.add(stockField);

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
            double precio = Double.parseDouble(precioField.getText());
            int stock = Integer.parseInt(stockField.getText());

            // Validación básica
            if (precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(this, "Precio y Stock deben ser valores positivos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Actualizar los datos del producto
                producto.setPrecio(precio);
                producto.setStock(stock);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Producto actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio debe ser un número válido y Stock debe ser un número entero válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
