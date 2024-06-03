package frontend.ventanasMantenimiento;

import backend.modelos.Cliente;
import backend.modelos.ModelosApp;
import backend.saves.Datos;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class VentanaRegistroCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtPuntos;
    private JList<String> listClientes;
    private DefaultListModel<String> modeloLista;

    // Clientes que se han agregado, que se muestran en pantalla
    private ArrayList<Cliente> clientesRegistrados;

    // ArrayList de todos los clientes en el sistema
    private ArrayList<Cliente> clientes;

    public VentanaRegistroCliente() 
    {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Registro de Cliente");
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

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblApellido.setBounds(50, 180, 100, 20);
        contentPane.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(150, 180, 200, 25);
        contentPane.add(txtApellido);
        txtApellido.setColumns(10);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTelefono.setBounds(50, 220, 100, 20);
        contentPane.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 220, 200, 25);
        contentPane.add(txtTelefono);
        txtTelefono.setColumns(10);

        JLabel lblPuntos = new JLabel("Puntos:");
        lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPuntos.setBounds(50, 260, 100, 20);
        contentPane.add(lblPuntos);

        txtPuntos = new JTextField();
        txtPuntos.setBounds(150, 260, 200, 25);
        contentPane.add(txtPuntos);
        txtPuntos.setColumns(10);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnRegistrar.setBackground(new Color(0, 153, 0));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBounds(79, 382, 120, 35);
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarCliente();
            }
        });
        contentPane.add(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCancelar.setBackground(new Color(204, 0, 0));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBounds(239, 381, 120, 35);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtId.getText().isEmpty() && txtNombre.getText().isEmpty() &&
                        txtApellido.getText().isEmpty() && txtTelefono.getText().isEmpty() &&
                        txtPuntos.getText().isEmpty()) {
                    // Si TODOS los campos están vacíos, el botón de cancelar actúa como botón de dispose.
                    dispose();
                } else {
                    // Si al menos un campo está vacío, se limpian los campos
                    limpiarCampos();
                }
            }
        });
        contentPane.add(btnCancelar);

        JPanel panelLista = new JPanel();
        panelLista.setBorder(BorderFactory.createTitledBorder("Clientes Registrados"));
        panelLista.setBounds(400, 80, 350, 300);
        contentPane.add(panelLista);
        panelLista.setLayout(null);

        modeloLista = new DefaultListModel<>();
        listClientes = new JList<>(modeloLista);
        listClientes.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(listClientes);
        scrollPane.setBounds(10, 20, 330, 270);
        panelLista.add(scrollPane);

        clientesRegistrados = new ArrayList<>();
    }

    private void registrarCliente() {
        if (validarDatos()) {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String telefono = txtTelefono.getText();
            double puntos = Double.parseDouble(txtPuntos.getText());

            // Crear un nuevo cliente con los datos ingresados
            Cliente nuevoCliente = new Cliente(id, nombre, apellido, telefono, puntos);

            // Agregar el cliente al sistema
            ModelosApp callbackRegistrarCliente = new ModelosApp();
            callbackRegistrarCliente.registrarCliente(id, nombre, apellido, puntos, telefono);
            // Agregar el cliente a la lista de clientes registrados que se muestra en pantalla
            clientesRegistrados.add(nuevoCliente);
            // Actualizar la lista de clientes en la ventana
            actualizarListaClientes();

            // Mostrar un mensaje de éxito en una ventana emergente
            JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar los campos de texto
            limpiarCampos();
        }
    }

    private boolean validarDatos() {
        // Validar que todos los campos estén completos
        if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                txtApellido.getText().isEmpty() || txtTelefono.getText().isEmpty() ||
                txtPuntos.getText().isEmpty()) {
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

        // Validar que los puntos sean un número decimal válido
        try {
            Double.parseDouble(txtPuntos.getText());
        } catch (NumberFormatException e) {
            mostrarMensajeError("Los puntos deben ser un número decimal válido");
            return false;
        }

        // Validar que el ID no esté ocupado
        if (Datos.getTablaLookUpClientes().containsKey(Integer.parseInt(txtId.getText()))) {
            mostrarMensajeError("El ID ya está ocupado. Por favor, ingrese un ID diferente.");
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
        txtApellido.setText("");
        txtTelefono.setText("");
        txtPuntos.setText("");
    }

    // Actualizar la lista de clientes que aparecen en la ventana
    private void actualizarListaClientes() {
        modeloLista.clear();
        for (Cliente cliente : clientesRegistrados) {
            String itemCliente = "ID: " + cliente.getId() +
                    " | Nombre: " + cliente.getNombre() +
                    " | Apellido: " + cliente.getApellido() +
                    " | Teléfono: " + cliente.getTelefono() +
                    " | Puntos: " + cliente.getPuntos();
            modeloLista.addElement(itemCliente);
        }
    }
}
