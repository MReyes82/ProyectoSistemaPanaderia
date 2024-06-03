package frontend.ventanasMantenimiento;

import APLICACION_PRINCIPAL.mainApp;
import backend.saves.Datos;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import backend.modelos.Producto;
import frontend.ventanasLogin.Login;
import frontend.ventanasLogin.Soporte;
import frontend.ventanasMenuPrincipal.Principal;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mantenimiento extends JFrame {

    private static final long serialVersionUID = 1L;

    public Mantenimiento() {
    	setResizable(false);
        // la unica forma de salir es regresar al login de soporte y cerrar la aplicacion
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        setTitle("Ventana de mantenimiento");

        /*
        * MODULOS PARA REGISTRO DE OBJETOS
        */

        JLabel LabelRegistroDeElementos = new JLabel("Registro de elementos");
        LabelRegistroDeElementos.setHorizontalAlignment(SwingConstants.CENTER);
        LabelRegistroDeElementos.setBounds(51, 85, 898, 31);
        LabelRegistroDeElementos.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(LabelRegistroDeElementos);

        JButton BotonAgregarProducto = new JButton("Registrar un nuevo producto");
        BotonAgregarProducto.setBounds(51, 158, 300, 41);
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

        JButton BotonRegistrarEmpleado = new JButton("Registrar un empleado");
        BotonRegistrarEmpleado.setBounds(680, 158, 269, 41);
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

        JButton BotonRegistrarCliente = new JButton("Registrar un cliente");
        BotonRegistrarCliente.setBounds(383, 158, 252, 41);
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
        * MODULOS PARA MOSTRAR DATOS
        */

        JLabel LabelMostrarDatos = new JLabel("Mostrar datos");
        LabelMostrarDatos.setHorizontalAlignment(SwingConstants.CENTER);
        LabelMostrarDatos.setBounds(51, 244, 898, 31);
        LabelMostrarDatos.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(LabelMostrarDatos);

        JButton BotonListaEmpleados = new JButton("Mostrar empleados");
        BotonListaEmpleados.setBounds(680, 309, 269, 41);
        BotonListaEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonListaEmpleados);
        
        BotonListaEmpleados.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		VentanaListaEmpleados listaEmpleados = new VentanaListaEmpleados();
        		listaEmpleados.setVisible(true);
        	}
        });

        JButton BotonMostrarInventario = new JButton("Mostrar inventario");
        BotonMostrarInventario.setBounds(51, 309, 300, 41);
        BotonMostrarInventario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonMostrarInventario);

        BotonMostrarInventario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
                VentanaListaProductos listaProductos = new VentanaListaProductos();
                listaProductos.setVisible(true);
        	}
        });

        JButton BotonMostrarClientes = new JButton("Mostrar Clientes");
        BotonMostrarClientes.setBounds(383, 309, 258, 41);
        BotonMostrarClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonMostrarClientes);

        BotonMostrarClientes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		VentanaListaClientes listaClientes = new VentanaListaClientes();
        		listaClientes.setVisible(true);
        	}
        });

        ////////////////////////////////////////////////////////////////////////////
        
        /*
         * MODULOS BUSQUEDA DE ELEMENTOS (SE BUSCA POR IDENTIFICADOR)
         */

        JLabel LabelMostrarEmpleado = new JLabel("Busqueda de elementos");
        LabelMostrarEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
        LabelMostrarEmpleado.setBounds(51, 421, 898, 31);
        LabelMostrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 25));
        getContentPane().add(LabelMostrarEmpleado);
        
        JButton BotonBuscarEmpleado = new JButton("Buscar un empleado");
        BotonBuscarEmpleado.setBounds(680, 489, 269, 41);
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

        JButton BotonBuscarProducto = new JButton("Buscar un  producto");
        BotonBuscarProducto.setBounds(51, 489, 300, 41);
        BotonBuscarProducto.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	ProductoIDInputFrame busquedaProducto = new ProductoIDInputFrame();
                busquedaProducto.setVisible(true);
            }
        });

        BotonBuscarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonBuscarProducto);

        JButton BotonBuscarCliente = new JButton("Buscar un cliente");
        BotonBuscarCliente.setBounds(383, 489, 258, 41);
        BotonBuscarCliente.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	ClienteIDInputFrame busquedaCliente = new ClienteIDInputFrame();
            	busquedaCliente.setVisible(true);
            }
        });

        BotonBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(BotonBuscarCliente);

        ////////////////////////////////////////////////////////////////////////////

        /*
         * BOTONES DE PIE DE VENTANA
         */

        JButton Cerrar = new JButton("Cerrar");
        Cerrar.setBounds(383, 676, 104, 31);
        Cerrar.setFont(new Font("Tahoma", Font.BOLD, 15));
        Cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual de Mantenimiento
                Soporte soporte = new Soporte(); // Crea una nueva instancia de la ventana de SOPORTE
                soporte.setVisible(true); // Muestra la ventana de SOPORTE
            }
        });
        getContentPane().add(Cerrar);

        JButton BotonVolverAMenuPrincipal = new JButton("Volver a ventana principal");
        BotonVolverAMenuPrincipal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                dispose();
                Principal volverAMenuPrincipal = new Principal();
                volverAMenuPrincipal.setVisible(true);
        	}
        });
        BotonVolverAMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 15));
        BotonVolverAMenuPrincipal.setBounds(51, 676, 300, 31);
        getContentPane().add(BotonVolverAMenuPrincipal);
    }
}
