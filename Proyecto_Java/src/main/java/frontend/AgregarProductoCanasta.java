package frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import backend.modelos.Producto;
import backend.saves.*;

public class AgregarProductoCanasta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<Producto> comboBoxProductos;
    private JSpinner spinnerCantidad;
    private ArrayList<Producto> productosDisponibles;
    private Principal principal;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AgregarProductoCanasta frame = new AgregarProductoCanasta(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AgregarProductoCanasta(Principal principal) {
        this.principal = principal;
        productosDisponibles = Datos.getInventario();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        comboBoxProductos = new JComboBox<>(productosDisponibles.toArray(new Producto[0]));
        comboBoxProductos.setBounds(27, 109, 290, 22);
        contentPane.add(comboBoxProductos);

        spinnerCantidad = new JSpinner();
        spinnerCantidad.setBounds(327, 110, 50, 20);
        contentPane.add(spinnerCantidad);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(172, 174, 89, 23);
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                procesarCompra();
            }
        });
        contentPane.add(btnAceptar);
    }

    private void procesarCompra() {
        Producto productoSeleccionado = (Producto) comboBoxProductos.getSelectedItem();
        if (productoSeleccionado != null) {
            int cantidad = (Integer) spinnerCantidad.getValue();
            if (cantidad > 0 && cantidad <= productoSeleccionado.getStock()) {
                double total = cantidad * productoSeleccionado.getPrecio();
                productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);
                
                //Datos.setProducto(productoSeleccionado);
                HashMap<Integer, Producto> tablaActualizada = Datos.getTablaLookUpProductos();
                tablaActualizada.put(productoSeleccionado.getId(), productoSeleccionado);
                Datos.setTablaLookUpProductos(tablaActualizada);
                

                if (principal != null) {
                    principal.agregarProductoATabla(productoSeleccionado, cantidad, total);
                    dispose();
                }

                JOptionPane.showMessageDialog(this, "Producto agregado correctamente.");
            } else if (cantidad > productoSeleccionado.getStock()) {
                JOptionPane.showMessageDialog(this, "Stock insuficiente. Stock disponible: " + productoSeleccionado.getStock(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
