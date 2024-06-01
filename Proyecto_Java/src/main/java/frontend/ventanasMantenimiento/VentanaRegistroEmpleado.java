package frontend.ventanasMantenimiento;

import backend.modelos.herenciaEmpleados.*;
import backend.saves.Datos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class VentanaRegistroEmpleado extends JFrame 
{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JTextField txtSalario;
    private JComboBox<Turno> turnoComboBox;
    private JComboBox<String> tipoEmpleadoComboBox;
    private JList<String> listEmpleados;
    private DefaultListModel<String> modeloLista;

    // Empleados que se han agregado, que se muestran en pantalla
    private ArrayList<Empleado> empleadosRegistrados;

    // ArrayList de todos los empleados en el sistema
    private ArrayList<Empleado> empleados;

    public VentanaRegistroEmpleado()
    {
        setResizable(false);
        this.empleados = new ArrayList<>(Datos.getTablaLookUpEmpleados().values());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Registro de Empleado");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblTitulo.setBounds(0, 20, 400, 30);
        contentPane.add(lblTitulo);

        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblId.setBounds(50, 100, 120, 20);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(189, 99, 200, 25);
        contentPane.add(txtId);
        txtId.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNombre.setBounds(50, 140, 120, 20);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(189, 139, 200, 25);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblApellido.setBounds(50, 180, 120, 20);
        contentPane.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(189, 179, 200, 25);
        contentPane.add(txtApellido);
        txtApellido.setColumns(10);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEdad.setBounds(50, 220, 120, 20);
        contentPane.add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(189, 219, 200, 25);
        contentPane.add(txtEdad);
        txtEdad.setColumns(10);

        JLabel lblSalario = new JLabel("Salario por hora:");
        lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSalario.setBounds(50, 260, 129, 20);
        contentPane.add(lblSalario);

        txtSalario = new JTextField();
        txtSalario.setBounds(189, 259, 200, 25);
        contentPane.add(txtSalario);
        txtSalario.setColumns(10);

        JLabel lblTurno = new JLabel("Turno:");
        lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTurno.setBounds(50, 300, 100, 20);
        contentPane.add(lblTurno);

        turnoComboBox = new JComboBox<>(Turno.values());
        turnoComboBox.setBounds(189, 299, 200, 25);
        contentPane.add(turnoComboBox);

        JLabel lblTipoEmpleado = new JLabel("Tipo de Empleado:");
        lblTipoEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTipoEmpleado.setBounds(50, 340, 129, 20);
        contentPane.add(lblTipoEmpleado);

        tipoEmpleadoComboBox = new JComboBox<>(new String[]{"Limpieza", "Vendedor", "Panadero"});
        tipoEmpleadoComboBox.setBounds(189, 339, 200, 25);
        contentPane.add(tipoEmpleadoComboBox);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnRegistrar.setBackground(new Color(0, 153, 0));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBounds(79, 382, 120, 35);
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarEmpleado();
            }
        });
        contentPane.add(btnRegistrar);

        JPanel panelLista = new JPanel();
        panelLista.setBorder(BorderFactory.createTitledBorder("Empleados Registrados"));
        panelLista.setBounds(413, 80, 350, 300);
        contentPane.add(panelLista);
        panelLista.setLayout(null);

        modeloLista = new DefaultListModel<>();
        listEmpleados = new JList<>(modeloLista);
        listEmpleados.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(listEmpleados);
        scrollPane.setBounds(10, 20, 330, 270);
        panelLista.add(scrollPane);

        empleadosRegistrados = new ArrayList<>();
        
        JButton BotonCancelar = new JButton("Cancelar");
        BotonCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
        BotonCancelar.setBackground(new Color(204, 0, 0));
        BotonCancelar.setForeground(Color.WHITE);
        BotonCancelar.setBounds(239, 381, 120, 35);

        BotonCancelar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (txtId.getText().isEmpty() && txtNombre.getText().isEmpty() &&
                        txtApellido.getText().isEmpty() && txtEdad.getText().isEmpty()
                        && txtSalario.getText().isEmpty()) {
                    // Si TODOS los campos estan vacios, el boton de cancelar actua como boton de dispose.
                    dispose();
                } else if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                        txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty()
                        || txtSalario.getText().isEmpty() ) {
                    // Si al menos un campo esta vacio, se limpian los campos
                    limpiarCampos();
                }
            }
        });

        contentPane.add(BotonCancelar);
    }

    private void registrarEmpleado() {
        if (validarDatos()) {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            double salario = Double.parseDouble(txtSalario.getText());
            Turno turno = (Turno) turnoComboBox.getSelectedItem();
            String tipoEmpleado = (String) tipoEmpleadoComboBox.getSelectedItem();

            // Agregar el empleado al sistema
            switch (tipoEmpleado) 
            {
                case "Limpieza":
                    //nuevoEmpleado = new Limpieza(id, nombre, apellido, edad, salario, turno);
                    agregarEmpleadoLimpieza(id, nombre, apellido, edad, salario, turno);
                    
                    break;
                    
                case "Vendedor":
                    //nuevoEmpleado = new Vendedor(id, nombre, apellido, edad, salario, 0.05, turno);
                    agregarEmpleadoVendedor(id, nombre, apellido, edad, salario, 0.05, turno);

                    break;
                    
                case "Panadero":
                    //nuevoEmpleado = new Panadero(id, nombre, apellido, edad, salario, turno);
                    agregarEmpleadoPanadero(id, nombre, apellido, edad, salario, turno);

                    break;
            }

            // Actualizar la lista de empleados en la ventana
            actualizarListaEmpleados();

            // Mostrar un mensaje de éxito en una ventana emergente
            JOptionPane.showMessageDialog(this, "Empleado registrado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar los campos de texto
            limpiarCampos();
        }
    }

    private boolean validarDatos() {
        // Validar que todos los campos estén completos
        if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty() ||
                txtSalario.getText().isEmpty()) {
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

        // Validar que la edad sea un número entero válido
        try {
            Integer.parseInt(txtEdad.getText());
        } catch (NumberFormatException e) {
            mostrarMensajeError("La edad debe ser un número entero válido");
            return false;
        }

        // Validar que el salario sea un número decimal válido
        try {
            Double.parseDouble(txtSalario.getText());
        } catch (NumberFormatException e) {
            mostrarMensajeError("El salario debe ser un número decimal válido");
            return false;
        }

        // Validar que el ID no esté ocupado
        if (Datos.getTablaLookUpEmpleados().containsKey(Integer.parseInt(txtId.getText()))) {
            mostrarMensajeError("El ID ya está ocupado. Por favor, ingrese un ID diferente.");
            return false;
        }

        return true;
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
    }

    private void limpiarCampos() 
    {
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtSalario.setText("");
        turnoComboBox.setSelectedIndex(0);
        tipoEmpleadoComboBox.setSelectedIndex(0);
    }

    // Actualizar la lista de empleados que aparecen en la ventana
    private void actualizarListaEmpleados() {
        modeloLista.clear();
        for (Empleado empleado : empleadosRegistrados) {
            String itemEmpleado = "ID: " + empleado.getId() +
                    " | Nombre: " + empleado.getNombre() +
                    " | Apellido: " + empleado.getApellido() +
                    " | Edad: " + empleado.getEdad() +
                    " | Salario: " + empleado.getSalario() +
                    " | Turno: " + empleado.getTurno();
            modeloLista.addElement(itemEmpleado);
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
        
        empleadosRegistrados.add(nuevoVendedor);

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
        
        empleadosRegistrados.add(nuevoLimpieza);

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
        
        empleadosRegistrados.add(nuevoPanadero);

        System.out.println("Empleado panadero agregado con éxito");
    }
}
