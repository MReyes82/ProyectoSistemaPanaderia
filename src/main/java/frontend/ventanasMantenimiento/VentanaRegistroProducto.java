package frontend.ventanasMantenimiento;

import backend.modelos.ModelosApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import backend.modelos.Producto;
import backend.saves.Datos;

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
    
    // productos que se han agregados, que se muestran en pantalla
    private ArrayList<Producto> productosRegistrados;
    
    // arraylist de todos los productos en el inventario
    private ArrayList<Producto> inventario;

    public VentanaRegistroProducto(ArrayList<Producto> productosParametro) 
    {	
    	setResizable(false);
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
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitulo.setBounds(0, 20, 400, 30);
        contentPane.add(lblTitulo);

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblId.setBounds(50, 100, 100, 20);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(150, 100, 200, 25);
        contentPane.add(txtId);
        txtId.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNombre.setBounds(50, 140, 100, 20);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 140, 200, 25);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrecio.setBounds(50, 180, 100, 20);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(150, 180, 200, 25);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblStock.setBounds(50, 220, 100, 20);
        contentPane.add(lblStock);

        txtStock = new JTextField();
        txtStock.setBounds(150, 220, 200, 25);
        contentPane.add(txtStock);
        txtStock.setColumns(10);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnRegistrar.setBackground(new Color(0, 153, 0));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBounds(79, 382, 120, 35);
        btnRegistrar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
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
        
        JButton BotonCancelar = new JButton("Cancelar");
        BotonCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
        BotonCancelar.setBackground(new Color(204, 0, 0));
        BotonCancelar.setForeground(Color.WHITE);
        BotonCancelar.setBounds(239, 381, 120, 35);

        BotonCancelar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (txtId.getText().isEmpty() && txtNombre.getText().isEmpty() && txtPrecio.getText().isEmpty() && txtStock.getText().isEmpty())
                {
                    dispose();

                } else if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty()
                        || txtPrecio.getText().isEmpty() || txtStock.getText().isEmpty()) {
                    limpiarCampos();
                }


            }
        });

        contentPane.add(BotonCancelar);
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
            ModelosApp callbackRegistrarProducto = new ModelosApp();

            // Agregar el producto al inventario
            callbackRegistrarProducto.registrarProducto(id, nombre, precio, stock);
            
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

    // actualizar la lista de productos que aparecen en la ventana
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
}
