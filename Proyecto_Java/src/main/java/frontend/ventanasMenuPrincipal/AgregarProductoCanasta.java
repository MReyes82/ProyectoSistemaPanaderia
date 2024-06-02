package frontend.ventanasMenuPrincipal;

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

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class AgregarProductoCanasta extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<Producto> comboBoxProductos;
    private JSpinner spinnerCantidad;
    private ArrayList<Producto> productosDisponibles;
    private Principal principal;
    private JLabel LabelAddProducto;
    private JLabel LabelSeleccionarProducto;
    private JLabel LabelCantidad;

    /**
     * Create the frame.
     */
    public AgregarProductoCanasta(Principal principal) 
    {
        setResizable(false);
        this.principal = principal;
        productosDisponibles = new ArrayList<>(principal.getCopiaInventario().values());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        comboBoxProductos = new JComboBox<>(productosDisponibles.toArray(new Producto[0]));
        comboBoxProductos.setBounds(27, 119, 290, 22);
        contentPane.add(comboBoxProductos);

        spinnerCantidad = new JSpinner();
        spinnerCantidad.setBounds(337, 120, 50, 20);
        contentPane.add(spinnerCantidad);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAceptar.setBounds(96, 198, 102, 30);
        btnAceptar.setBackground(new Color(0, 153, 0));
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                procesarCompra();
            }
        });
        contentPane.add(btnAceptar);

        LabelAddProducto = new JLabel("Seleccione un producto y su cantidad");
        LabelAddProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        LabelAddProducto.setBounds(66, 22, 302, 23);
        contentPane.add(LabelAddProducto);

        LabelSeleccionarProducto = new JLabel("Seleccionar producto:");
        LabelSeleccionarProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
        LabelSeleccionarProducto.setBounds(27, 86, 141, 22);
        contentPane.add(LabelSeleccionarProducto);

        LabelCantidad = new JLabel("Cantidad:");
        LabelCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
        LabelCantidad.setBounds(337, 95, 70, 14);
        contentPane.add(LabelCantidad);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cancelar.setBackground(new Color(204, 0,0));
        cancelar.setForeground(Color.WHITE);
        cancelar.setBounds(221, 198, 102, 30);
        contentPane.add(cancelar);
        
        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
    }

    private void procesarCompra() 
    {
        Producto productoSeleccionado = (Producto) comboBoxProductos.getSelectedItem();
        if (productoSeleccionado != null) 
        {
            int cantidad = (Integer) spinnerCantidad.getValue();
            
            if (cantidad > 0 && cantidad <= productoSeleccionado.getStock()) 
            {
                double total = cantidad * productoSeleccionado.getPrecio();
                productoSeleccionado.setStock(productoSeleccionado.getStock() - cantidad);

                if (principal != null) 
                {
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
