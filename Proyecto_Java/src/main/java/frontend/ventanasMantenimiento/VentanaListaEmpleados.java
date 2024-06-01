package frontend.ventanasMantenimiento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


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

    private void inicializarComponentes() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());

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

        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelPrincipal);
    }

    private void llenarTabla() 
    {
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

    public static void main(String[] args) {
        // Mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            new VentanaListaEmpleados().setVisible(true);
        });
    }
}