package frontend.ventanasMantenimiento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import backend.modelos.ModelosApp;
import backend.saves.Datos;
import backend.modelos.Producto;

public class VentanaListaProductos extends JFrame {
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    private List<Producto> listaProductos;

    public VentanaListaProductos() {
        setTitle("Lista de Productos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() 
    {
    	
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        // carga de datos para test
        //Datos.inicializarDatos();
        //Datos.cargarElementosTEST();

        // Columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Precio", "Stock"};

        // Modelo de la tabla
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer las celdas no editables
            }
        };

        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);

        // Llenar la tabla con los datos de los productos
        llenarTabla();

        // Panel para la tabla
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setPreferredSize(new Dimension(780, 400));
        panelTabla.add(scrollPane, BorderLayout.CENTER);

        // Botones "Cerrar", "Editar" y "Eliminar"
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCerrar.setBackground(new Color(204, 0, 0));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });

        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnEditar.setBackground(new Color(0, 153, 204));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int selectedRow = tablaProductos.getSelectedRow();

                if (selectedRow == -1)
                {
                    JOptionPane.showMessageDialog(null, "Selecciona un elemento primero", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    // Acción de edición (a implementar)
                    // Aquí puedes utilizar productoSeleccionado para editarlo
                    Producto productoSeleccionado = listaProductos.get(selectedRow);
                    VentanaEditarProducto editar = new VentanaEditarProducto(productoSeleccionado);
                    editar.setVisible(true);
                }
            }
        });

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnEliminar.setBackground(new Color(204, 0, 0));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int selectedRow = tablaProductos.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Selecciona un elemento primero", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Acción de eliminación (a implementar)
                    // Aquí puedes utilizar productoSeleccionado para eliminarlo
                    Producto productoAEliminar = listaProductos.get(selectedRow);
                    new ModelosApp().eliminarProducto(productoAEliminar.getId());
                    JOptionPane.showMessageDialog(null, "Producto eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCerrar);

        // Agregar los paneles al panel principal
        panelPrincipal.add(panelTabla, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        getContentPane().add(panelPrincipal);
    }

    private void llenarTabla() {
        List<Producto> todosProductos = obtenerTodosLosProductos();
        listaProductos = new ArrayList<>();

        for (Producto producto : todosProductos) {
            Object[] fila = {
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getStock()
            };
            modeloTabla.addRow(fila);
            listaProductos.add(producto); // Agregar el producto a la lista
        }
    }

    private List<Producto> obtenerTodosLosProductos() {
        return Datos.getInventario();
    }

    public static void main(String[] args) {
        // Mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            new VentanaListaProductos().setVisible(true);
        });
    }
}
