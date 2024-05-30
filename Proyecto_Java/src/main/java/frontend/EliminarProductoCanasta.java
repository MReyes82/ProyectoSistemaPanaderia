package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import backend.modelos.Producto;

public class EliminarProductoCanasta extends JFrame 
{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<Producto> comboBoxProductos;
    private Principal principal;

    public EliminarProductoCanasta(Principal principal) {
        this.principal = principal;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ArrayList<Producto> productosSeleccionados = principal.getProductosSeleccionados();

        comboBoxProductos = new JComboBox<>(productosSeleccionados.toArray(new Producto[0]));
        comboBoxProductos.setBounds(27, 50, 290, 22);
        contentPane.add(comboBoxProductos);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(172, 100, 89, 23);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarProductoSeleccionado();
            }
        });
        contentPane.add(btnEliminar);
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
