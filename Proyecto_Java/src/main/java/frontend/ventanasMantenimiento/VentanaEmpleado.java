package frontend.ventanasMantenimiento;

import javax.swing.*;
import backend.modelos.herenciaEmpleados.Empleado;
import backend.modelos.herenciaEmpleados.Limpieza;
import backend.modelos.herenciaEmpleados.Panadero;
import backend.modelos.herenciaEmpleados.Vendedor;
import backend.servicios.Venta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEmpleado extends JFrame {
    public VentanaEmpleado(Empleado empleado) {
        setTitle("Detalles del Empleado");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelEmpleado = new JPanel();
        panelEmpleado.setLayout(new GridLayout(7, 2, 10, 10));
        panelEmpleado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelEmpleado.add(new JLabel("ID:"));
        panelEmpleado.add(new JLabel(String.valueOf(empleado.getId())));

        panelEmpleado.add(new JLabel("Nombre:"));
        panelEmpleado.add(new JLabel(empleado.getNombre()));

        panelEmpleado.add(new JLabel("Apellido:"));
        panelEmpleado.add(new JLabel(empleado.getApellido()));

        panelEmpleado.add(new JLabel("Edad:"));
        panelEmpleado.add(new JLabel(String.valueOf(empleado.getEdad())));

        panelEmpleado.add(new JLabel("Salario:"));
        panelEmpleado.add(new JLabel(String.valueOf(empleado.getSalario())));

        panelEmpleado.add(new JLabel("Turno:"));
        panelEmpleado.add(new JLabel(String.valueOf(empleado.getTurno())));

        panelEmpleado.add(new JLabel("Tipo de Empleado:"));
        String tipoEmpleado = "";
        if (empleado instanceof Limpieza) {
            tipoEmpleado = "Limpieza";
        } else if (empleado instanceof Vendedor) {
            tipoEmpleado = "Vendedor";
        } else if (empleado instanceof Panadero) {
            tipoEmpleado = "Panadero";
        }
        panelEmpleado.add(new JLabel(tipoEmpleado));

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCerrar.setBackground(new Color(204, 0, 0));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEditar.setBackground(new Color(0, 153, 204));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaEditarEmpleado editar = new VentanaEditarEmpleado(empleado);
                editar.setVisible(true);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(btnEditar);
        panelBotones.add(btnCerrar);

        add(panelEmpleado, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }
}
