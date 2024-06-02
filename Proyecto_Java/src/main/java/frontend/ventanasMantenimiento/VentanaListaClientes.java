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
import backend.modelos.Cliente;

public class VentanaListaClientes extends JFrame {
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;
    private List<Cliente> listaClientes;

    public VentanaListaClientes() 
    {
        setTitle("Lista de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        // cargar datos de prueba
        //Datos.inicializarDatos();
        //Datos.cargarElementosTEST();
        
        // Columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Apellido", "Teléfono", "Puntos"};

        // Modelo de la tabla
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer las celdas no editables
            }
        };

        tablaClientes = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaClientes);

        // Llenar la tabla con los datos de los clientes
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
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                int selectedRow = tablaClientes.getSelectedRow();
                
                if (selectedRow == -1) 
                {
                    JOptionPane.showMessageDialog(null, "Selecciona un elemento primero", "Error", JOptionPane.ERROR_MESSAGE);
                    
                } else {
                    // Acción de edición (a implementar)
                    // Aquí puedes utilizar clienteSeleccionado para editarlo
                    Cliente clienteSeleccionado = listaClientes.get(selectedRow);
                    VentanaEditarCliente ventanaEditarCliente = new VentanaEditarCliente(clienteSeleccionado);
                    ventanaEditarCliente.setVisible(true);
                }
            }
        });

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnEliminar.setBackground(new Color(204, 0, 0));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                int selectedRow = tablaClientes.getSelectedRow();
                if (selectedRow == -1) 
                {
                    JOptionPane.showMessageDialog(null, "Selecciona un elemento primero", "Error", JOptionPane.ERROR_MESSAGE);
                    
                } else {
                    // Acción de eliminación (a implementar)
                    // Aquí puedes utilizar clienteSeleccionado para eliminarlo
                    Cliente clienteAEliminar = listaClientes.get(selectedRow);
                    new ModelosApp().eliminarCliente(clienteAEliminar.getId());
                    JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
        List<Cliente> todosClientes = obtenerTodosLosClientes();
        listaClientes = new ArrayList<>();

        for (Cliente cliente : todosClientes) {
            Object[] fila = {
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getTelefono(),
                    cliente.getPuntos()
            };
            modeloTabla.addRow(fila);
            listaClientes.add(cliente); // Agregar el cliente a la lista
        }
    }

    private List<Cliente> obtenerTodosLosClientes() {
        return Datos.getClientes();
    }

    public static void main(String[] args) {
        // Mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            new VentanaListaClientes().setVisible(true);
        });
    }
}
