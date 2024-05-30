package frontend;

import backend.modelos.herenciaEmpleados.*;
import backend.saves.Datos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class VentanaRegistroEmpleado extends JFrame {

    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField idField;
    private JTextField edadField;
    private JTextField salarioField;
    private JComboBox<Turno> turnoComboBox;
    private JComboBox<String> tipoEmpleadoComboBox;
    private JButton registrarButton;
    private JButton cancelarButton;

    public VentanaRegistroEmpleado() {
        // Configuración de la ventana
        setTitle("Registro de Empleado");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));

        // Crear y añadir los componentes al panel
        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        panel.add(apellidoField);

        panel.add(new JLabel("Edad:"));
        edadField = new JTextField();
        panel.add(edadField);

        panel.add(new JLabel("Salario (por hora):"));
        salarioField = new JTextField();
        panel.add(salarioField);

        panel.add(new JLabel("Turno:"));
        turnoComboBox = new JComboBox<>(Turno.values());
        panel.add(turnoComboBox);

        panel.add(new JLabel("Tipo de Empleado:"));
        tipoEmpleadoComboBox = new JComboBox<>(new String[]{"Limpieza", "Vendedor", "Panadero"});
        panel.add(tipoEmpleadoComboBox);

        registrarButton = new JButton("Registrar");
        panel.add(registrarButton);

        cancelarButton = new JButton("Cancelar");
        panel.add(cancelarButton);

        // Añadir el panel a la ventana
        add(panel);

        // Añadir ActionListeners a los botones
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEmpleado();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void registrarEmpleado() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            int edad = Integer.parseInt(edadField.getText());
            double salario = Double.parseDouble(salarioField.getText());
            Turno turno = (Turno) turnoComboBox.getSelectedItem();
            String tipoEmpleado = (String) tipoEmpleadoComboBox.getSelectedItem();

            // Validación básica
            if (nombre.isEmpty() || apellido.isEmpty() || id < 0 || edad < 0 || salario < 0) {
                JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos y ser válidos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que el ID no esté ocupado
            if (Datos.getTablaLookUpEmpleados().containsKey(id)) {
                JOptionPane.showMessageDialog(this, "El ID ya está ocupado. Por favor, ingrese un ID diferente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            switch (tipoEmpleado) {
                case "Limpieza":
                    agregarEmpleadoLimpieza(id, nombre, apellido, edad, salario, turno);
                    break;
                case "Vendedor":
                    agregarEmpleadoVendedor(id, nombre, apellido, edad, salario, 0.05, turno);
                    break;
                case "Panadero":
                    agregarEmpleadoPanadero(id, nombre, apellido, edad, salario, turno);
                    break;
            }

            JOptionPane.showMessageDialog(this, "Empleado registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID, Edad y Salario deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarEmpleadoVendedor(int id, String nombre, String apellido, int edad, double salario, double comision, Turno turno) {
        ArrayList<Vendedor> empleadosVendedores = Datos.getEmpleadosCajeros();
        HashMap<Integer, Empleado> empleadosMap = Datos.getTablaLookUpEmpleados();

        Vendedor nuevoVendedor = new Vendedor(id, nombre, apellido, edad, salario, comision, turno);

        empleadosVendedores.add(nuevoVendedor);
        Datos.setEmpleadosCajeros(empleadosVendedores);
        empleadosMap.put(id, nuevoVendedor);
        Datos.setTablaLookUpEmpleados(empleadosMap);

        System.out.println("Empleado vendedor agregado con éxito");
    }

    private void agregarEmpleadoLimpieza(int id, String nombre, String apellido, int edad, double salario, Turno turno) {
        ArrayList<Limpieza> empleadosLimpieza = Datos.getEmpleadosLimpieza();
        HashMap<Integer, Empleado> empleadosMap = Datos.getTablaLookUpEmpleados();

        Limpieza nuevoLimpieza = new Limpieza(id, nombre, apellido, edad, salario, turno);

        empleadosLimpieza.add(nuevoLimpieza);
        Datos.setEmpleadosLimpieza(empleadosLimpieza);
        empleadosMap.put(id, nuevoLimpieza);
        Datos.setTablaLookUpEmpleados(empleadosMap);

        System.out.println("Empleado de limpieza agregado con éxito");
    }

    private void agregarEmpleadoPanadero(int id, String nombre, String apellido, int edad, double salario, Turno turno) {
        ArrayList<Panadero> empleadosPanaderos = Datos.getEmpleadosPanaderos();
        HashMap<Integer, Empleado> empleadosMap = Datos.getTablaLookUpEmpleados();

        Panadero nuevoPanadero = new Panadero(id, nombre, apellido, edad, salario, turno);

        empleadosPanaderos.add(nuevoPanadero);
        Datos.setEmpleadosPanaderos(empleadosPanaderos);
        empleadosMap.put(id, nuevoPanadero);
        Datos.setTablaLookUpEmpleados(empleadosMap);

        System.out.println("Empleado panadero agregado con éxito");
    }

    private void limpiarCampos() {
        idField.setText("");
        nombreField.setText("");
        apellidoField.setText("");
        edadField.setText("");
        salarioField.setText("");
        turnoComboBox.setSelectedIndex(0);
        tipoEmpleadoComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaRegistroEmpleado().setVisible(true);
            }
        });
    }
}