package frontend;

import backend.modelos.Cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import backend.modelos.Producto;
import backend.saves.Datos;
import backend.servicios.Inventario;

public class VentanaRegistroProducto extends JFrame
{
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField idField;
    private JTextField telefonoField;
    private JTextField puntosField;
    private JButton registrarButton;
    private JButton cancelarButton;

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JList<String> listProductos;
    private DefaultListModel<String> modeloLista;
    private ArrayList<Producto> productosRegistrados;
    private ArrayList<Producto> inventario;

    public VentanaRegistroProducto(ArrayList<Producto> productosParametro) {
        this.inventario = productosParametro;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Registro de Producto");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblTitulo.setBounds(0, 20, 400, 30);
        contentPane.add(lblTitulo);

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblId.setBounds(50, 100, 100, 20);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(150, 100, 200, 25);
        contentPane.add(txtId);
        txtId.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNombre.setBounds(50, 140, 100, 20);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 140, 200, 25);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblPrecio.setBounds(50, 180, 100, 20);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(150, 180, 200, 25);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblStock.setBounds(50, 220, 100, 20);
        contentPane.add(lblStock);

        txtStock = new JTextField();
        txtStock.setBounds(150, 220, 200, 25);
        contentPane.add(txtStock);
        txtStock.setColumns(10);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnRegistrar.setBackground(new Color(0, 153, 0));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBounds(150, 270, 120, 35);
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarProducto();
            }
        });
        contentPane.add(btnRegistrar);

        JPanel panelLista = new JPanel();
        panelLista.setBorder(BorderFactory.createTitledBorder("Productos Registrados"));
        panelLista.setBounds(400, 80, 350, 300);
        contentPane.add(panelLista);
        panelLista.setLayout(null);

        modeloLista = new DefaultListModel<>();
        listProductos = new JList<>(modeloLista);
        listProductos.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(listProductos);
        scrollPane.setBounds(10, 20, 330, 270);
        panelLista.add(scrollPane);

        productosRegistrados = new ArrayList<>();

        // Guardar los productos registrados al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //guardarProductosRegistrados();
            }
        });
    }

    private void registrarProducto() {
        // Validar los datos ingresados
        if (validarDatos()) {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());

            // Crear un nuevo producto con los datos ingresados
            Producto nuevoProducto = new Producto(id, nombre, precio, stock);

            // Agregar el producto al inventario
            //inventario.add(nuevoProducto);
            ArrayList<Producto> nuevoInventario = Datos.getInventario();
            nuevoInventario.add(nuevoProducto);
            // Actualizamos los datos de la clase central
            Datos.setInventario(nuevoInventario);
            HashMap<Integer, Producto> tablaActualizada = Datos.getTablaLookUpProductos();
            tablaActualizada.put(id, nuevoProducto);

            // Agregar el producto a la lista de productos registrados
            productosRegistrados.add(nuevoProducto);

            // Actualizar la lista de productos en la ventana
            actualizarListaProductos();

            // Mostrar un mensaje de éxito en una ventana emergente
            JOptionPane.showMessageDialog(this, "Producto registrado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar los campos de texto
            limpiarCampos();
        }
    }

    private boolean validarDatos() {
        // Validar que todos los campos estén completos
        if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                txtPrecio.getText().isEmpty() || txtStock.getText().isEmpty()) {
            mostrarMensajeError("Por favor, complete todos los campos");
            return false;
        }

        // Validar que el ID sea un número entero válido
        try {
            Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e) {
            mostrarMensajeError("El ID debe ser un número entero válido");
            return false;
        }

        // Validar que el precio sea un número decimal válido
        try {
            Double.parseDouble(txtPrecio.getText());
        } catch (NumberFormatException e) {
            mostrarMensajeError("El precio debe ser un número decimal válido");
            return false;
        }

        // Validar que el stock sea un número entero válido
        try {
            Integer.parseInt(txtStock.getText());
        } catch (NumberFormatException e) {
            mostrarMensajeError("El stock debe ser un número entero válido");
            return false;
        }

        return true;
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }

    private void actualizarListaProductos() {
        modeloLista.clear();
        for (Producto producto : productosRegistrados) {
            String itemProducto = "ID: " + producto.getId() +
                    " | Nombre: " + producto.getNombre() +
                    " | Precio: " + producto.getPrecio() +
                    " | Stock: " + producto.getStock();
            modeloLista.addElement(itemProducto);
        }
    }

    /*private void guardarProductosRegistrados() {
        // Guardar los productos registrados en el inventario
        for (Producto producto : productosRegistrados) {
            inventario.agregarProducto(producto);
        }
    }*/
}
