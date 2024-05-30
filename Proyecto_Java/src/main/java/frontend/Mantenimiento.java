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

public class Mantenimiento extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
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
    }

    public Mantenimiento() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        getContentPane().setLayout(null);
        
        /*
         * REGISTRO DE PRODUCTO
         */
        
        JLabel LabelNuevoProducto = new JLabel("Registrar un nuevo producto");
        LabelNuevoProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelNuevoProducto.setBounds(370, 42, 268, 23);
        getContentPane().add(LabelNuevoProducto);
        
        JButton BotonAgregarProducto = new JButton("Agregar");
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
        BotonAgregarProducto.setBounds(429, 82, 150, 31);
        getContentPane().add(BotonAgregarProducto);
        
        ////////////////////////////////////////////////////////////////////////////
        
        /*
         * LISTA EMPLEADOS
         */
        
        JLabel LabelListaEmpleados = new JLabel("Mostrar lista de emplados");
        LabelListaEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelListaEmpleados.setBounds(386, 375, 236, 31);
        getContentPane().add(LabelListaEmpleados);
        
        JButton BotonListaEmpleados = new JButton("Mostar lista");
        BotonListaEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonListaEmpleados.setBounds(429, 427, 150, 31);
        getContentPane().add(BotonListaEmpleados);
        
        BotonListaEmpleados.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		VentanaListaEmpleados listaEmpleados = new VentanaListaEmpleados();
        		listaEmpleados.setVisible(true);
        	}
        });
                        
        ////////////////////////////////////////////////////////////////////////////
        
        /*
         * REGISTRO DE EMPLEADO 
         */
        
        JLabel LabelRegistrarEmpleado = new JLabel("Registrar un empleado");
        LabelRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelRegistrarEmpleado.setBounds(399, 263, 209, 31);
        getContentPane().add(LabelRegistrarEmpleado);
        
        JButton BotonRegistrarEmpleado = new JButton("Agregar");
        BotonRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));

        BotonRegistrarEmpleado.setBounds(429, 315, 150, 31);
        getContentPane().add(BotonRegistrarEmpleado);
        
        BotonRegistrarEmpleado.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		VentanaRegistroEmpleado registroEmpleado = new VentanaRegistroEmpleado();
        		registroEmpleado.setVisible(true);
        	}
        });
        
        ////////////////////////////////////////////////////////////////////////////
        
        /*
        * REGISTRO DE CLIENTES
        */
        
        JLabel LabelNuevoCliente = new JLabel("Registrar datos de nuevo cliente");
        LabelNuevoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelNuevoCliente.setBounds(353, 147, 301, 30);
        getContentPane().add(LabelNuevoCliente);
        
        JButton BotonRegistrarCliente = new JButton("Agregar");
        BotonRegistrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonRegistrarCliente.setBounds(429, 202, 150, 31);
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
        
        JLabel LabelMostrarEmpleado = new JLabel("Mostrar datos de un empleado");
        LabelMostrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelMostrarEmpleado.setBounds(364, 488, 280, 23);
        getContentPane().add(LabelMostrarEmpleado);
        
        JButton BotonMostrarEmpleado = new JButton("Buscar");
        BotonMostrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonMostrarEmpleado.setBounds(429, 535, 150, 31);
        getContentPane().add(BotonMostrarEmpleado);
        
        BotonMostrarEmpleado.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		EmpleadoIDInputFrame busquedaEmpleado = new EmpleadoIDInputFrame();
        		busquedaEmpleado.setVisible(true);
        	}
        });
        
        ////////////////////////////////////////////////////////////////////////////
        
        JButton Cerrar = new JButton("Cerrar");
        Cerrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual de Mantenimiento
                Soporte soporte = new Soporte(); // Crea una nueva instancia de la ventana de SOPORTE
                soporte.setVisible(true); // Muestra la ventana de SOPORTE
            }
        });
        Cerrar.setBounds(436, 651, 135, 41);
        getContentPane().add(Cerrar);
    }
}
