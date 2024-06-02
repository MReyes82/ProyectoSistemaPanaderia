package frontend.ventanasMenuPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import backend.modelos.Producto;

public class EliminarProductoCanasta extends JFrame
{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<Producto> comboBoxProductos;
    private Principal principal;

    public EliminarProductoCanasta(Principal principal)
    {
        this.principal = principal;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ArrayList<Producto> productosSeleccionados = principal.getProductosSeleccionados();

        comboBoxProductos = new JComboBox<>(productosSeleccionados.toArray(new Producto[0]));
        comboBoxProductos.setBounds(27, 119, 290, 22);
        contentPane.add(comboBoxProductos);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnEliminar.setBounds(96, 198, 102, 30);
        btnEliminar.setBackground(new Color(254, 0, 0));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                eliminarProductoSeleccionado();
            }
        });
        contentPane.add(btnEliminar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCancelar.setBounds(221, 198, 102, 30);
        btnCancelar.setBackground(new Color(255, 255, 255));
        btnCancelar.setForeground(Color.RED);

        btnCancelar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });

        contentPane.add(btnCancelar);



        JLabel LabelAddProducto = new JLabel("Seleccione un producto para eliminar");
        LabelAddProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        LabelAddProducto.setBounds(66, 22, 302, 23);
        contentPane.add(LabelAddProducto);

        JLabel LabelSeleccionarProducto = new JLabel("Seleccionar producto:");
        LabelSeleccionarProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
        LabelSeleccionarProducto.setBounds(27, 86, 141, 22);
        contentPane.add(LabelSeleccionarProducto);
    }

    private void eliminarProductoSeleccionado()
    {
        Producto productoSeleccionado = (Producto) comboBoxProductos.getSelectedItem();
        if (productoSeleccionado != null)
        {
            principal.eliminarProductoDeTabla(productoSeleccionado);
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.");
            dispose(); // Cerrar la ventana después de eliminar el producto
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
