package frontend;

import backend.saves.Datos;
import java.util.ArrayList;

import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.*;
import backend.servicios.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

public class Mantenimiento extends JFrame {

    private static final long serialVersionUID = 1L;

    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mantenimiento frame = new Mantenimiento();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    public Mantenimiento() {
    	setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        setTitle("Ventana de mantenimiento");
        
        JButton BotonAgregarProducto = new JButton("Registrar un nuevo producto");
        BotonAgregarProducto.setBounds(51, 158, 258, 41);
        BotonAgregarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                // Logica para registrar un producto.
            	ArrayList<Producto> inventario = Datos.getInventario();
            	
                VentanaRegistroProducto registroProducto = new VentanaRegistroProducto(inventario);
                registroProducto.setVisible(true);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(BotonAgregarProducto);
        
        JButton BotonListaEmpleados = new JButton("Mostrar lista de empleados");
        BotonListaEmpleados.setBounds(51, 309, 258, 41);
        BotonListaEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonListaEmpleados);
        
        BotonListaEmpleados.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		VentanaListaEmpleados listaEmpleados = new VentanaListaEmpleados();
        		listaEmpleados.setVisible(true);
        	}
        });
        
        JButton BotonRegistrarEmpleado = new JButton("Registrar un empleado");
        BotonRegistrarEmpleado.setBounds(691, 158, 258, 41);
        BotonRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonRegistrarEmpleado);
        
        BotonRegistrarEmpleado.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		VentanaRegistroEmpleado registroEmpleado = new VentanaRegistroEmpleado();
        		registroEmpleado.setVisible(true);
        	}
        });
        
        JButton BotonRegistrarCliente = new JButton("Registrar datos de nuevo cliente");
        BotonRegistrarCliente.setBounds(348, 158, 300, 41);
        BotonRegistrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonRegistrarCliente);
        
        BotonRegistrarCliente.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
            {
            	VentanaRegistroCliente pantallaRegistrarCLiente = new VentanaRegistroCliente();
            	pantallaRegistrarCLiente.setVisible(true);
            }
        });
        
        ////////////////////////////////////////////////////////////////////////////
        
        /*
         * BUSQUEDA DE EMPLEADO
         */
        
        JLabel LabelMostrarEmpleado = new JLabel("Busqueda de elementos");
        LabelMostrarEmpleado.setBounds(51, 421, 279, 31);
        LabelMostrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(LabelMostrarEmpleado);
        
        JButton BotonBuscarEmpleado = new JButton("Buscar un empleado");
        BotonBuscarEmpleado.setBounds(51, 489, 258, 41);
        BotonBuscarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonBuscarEmpleado);
        
        BotonBuscarEmpleado.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		EmpleadoIDInputFrame busquedaEmpleado = new EmpleadoIDInputFrame();
        		busquedaEmpleado.setVisible(true);
        	}
        });
        
        ////////////////////////////////////////////////////////////////////////////
        
        JButton Cerrar = new JButton("Cerrar");
        Cerrar.setBounds(436, 651, 135, 41);
        Cerrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual de Mantenimiento
                Soporte soporte = new Soporte(); // Crea una nueva instancia de la ventana de SOPORTE
                soporte.setVisible(true); // Muestra la ventana de SOPORTE
            }
        });
        getContentPane().add(Cerrar);
        
        JLabel LabelRegistroDeElementos = new JLabel("Registro de elementos");
        LabelRegistroDeElementos.setBounds(51, 85, 258, 31);
        LabelRegistroDeElementos.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(LabelRegistroDeElementos);
        
        JLabel LabelMostrarDatos = new JLabel("Mostrar datos");
        LabelMostrarDatos.setBounds(51, 244, 258, 31);
        LabelMostrarDatos.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(LabelMostrarDatos);
        
        JButton BotonMostrarInventario = new JButton("Mostrar inventario");
        BotonMostrarInventario.setBounds(383, 309, 241, 41);
        BotonMostrarInventario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonMostrarInventario);
        
        JButton BotonMostrarClientes = new JButton("Mostrar clientes registrados");
        BotonMostrarClientes.setBounds(691, 309, 258, 41);
        BotonMostrarClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonMostrarClientes);
        
        JButton btnNewButton = new JButton("Buscar un  producto");
        btnNewButton.setBounds(383, 489, 241, 41);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Buscar un cliente");
        btnNewButton_1.setBounds(691, 489, 189, 41);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(btnNewButton_1);
    }
}
