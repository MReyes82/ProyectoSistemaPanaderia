package frontend.ventanasMantenimiento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import backend.modelos.ModelosApp;
import backend.saves.*;
import backend.modelos.herenciaEmpleados.Empleado;

public class VentanaListaEmpleados extends JFrame {
    private JTable tablaEmpleados;
    private DefaultTableModel modeloTabla;

    public VentanaListaEmpleados() {
        setTitle("Lista de Empleados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() 
    {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        //Datos.inicializarDatos();
        //Datos.cargarElementosTEST();

        // Columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Apellido", "Edad", "Salario", "Turno"};

        // Modelo de la tabla
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer las celdas no editables
            }
        };

        tablaEmpleados = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);

        // Llenar la tabla con los datos de los empleados
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
                int selectedRow = tablaEmpleados.getSelectedRow();
                
                if (selectedRow == -1) 
                {
                    JOptionPane.showMessageDialog(null, "Selecciona un elemento primero", "Error", JOptionPane.ERROR_MESSAGE);
                    
                } else {
                    // Acción de edición (a implementar)
                    Empleado empleadoSeleccionado = obtenerTodosLosEmpleados().get(selectedRow);
                    VentanaEditarEmpleado editar = new VentanaEditarEmpleado(empleadoSeleccionado);
                    editar.setVisible(true);
                }
            }
        });

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnEliminar.setBackground(new Color(204, 0, 0));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaEmpleados.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Selecciona un elemento primero", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Acción de eliminación (a implementar)
                    Empleado empleadoSeleccionado = obtenerTodosLosEmpleados().get(selectedRow);
                    new ModelosApp().eliminarEmpleado(empleadoSeleccionado.getId());
                    JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
        List<Empleado> todosEmpleados = obtenerTodosLosEmpleados();

        for (Empleado empleado : todosEmpleados) {
            Object[] fila = {
                    empleado.getId(),
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getEdad(),
                    empleado.getSalario(),
                    empleado.getTurno()
            };
            modeloTabla.addRow(fila);
        }
    }

    private List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> todosEmpleados = new ArrayList<>();

        if (Datos.getEmpleadosLimpieza() != null) {
            todosEmpleados.addAll(Datos.getEmpleadosLimpieza());
        }
        if (Datos.getEmpleadosPanaderos() != null) {
            todosEmpleados.addAll(Datos.getEmpleadosPanaderos());
        }
        if (Datos.getEmpleadosCajeros() != null) {
            todosEmpleados.addAll(Datos.getEmpleadosCajeros());
        }

        return todosEmpleados;
    }
}
