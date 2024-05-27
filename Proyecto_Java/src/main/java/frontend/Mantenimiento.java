package frontend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

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
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar pan
            }
        });
        BotonAgregarProducto.setBounds(429, 82, 150, 31);
        getContentPane().add(BotonAgregarProducto);
        
        ////////////////////////////////////////////////////////////////////////////
        
        /*
         * REGISTRO DE EMPLEADO 
         */
        
        JLabel LabelEliminarProducto = new JLabel("Eliminar un producto de inventario");
        LabelEliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelEliminarProducto.setBounds(347, 138, 313, 31);
        getContentPane().add(LabelEliminarProducto);
        
        JButton BotonEliminarProducto = new JButton("Eliminar");
        BotonEliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonEliminarProducto.setBounds(429, 180, 150, 31);
        getContentPane().add(BotonEliminarProducto);
                
        ////////////////////////////////////////////////////////////////////////////
        
        /*
         * REGISTRO DE EMPLEADO 
         */
        
        JLabel LabelRegistrarEmpleado = new JLabel("Registrar un empleado");
        LabelRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelRegistrarEmpleado.setBounds(399, 328, 209, 31);
        getContentPane().add(LabelRegistrarEmpleado);
        
        JButton BotonRegistrarEmpleado = new JButton("Agregar");
        BotonRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonRegistrarEmpleado.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        BotonRegistrarEmpleado.setBounds(429, 370, 150, 31);
        getContentPane().add(BotonRegistrarEmpleado);
        
        ////////////////////////////////////////////////////////////////////////////
        
        /*
         * MODIFICACIÓN DE EMPLEADO
         */
        
        JLabel LabelModificarEmpleado = new JLabel("Modificar datos de un empleado");
        LabelModificarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelModificarEmpleado.setBounds(356, 418, 296, 31);
        getContentPane().add(LabelModificarEmpleado);
        
        JButton BotonModificarEmpleado = new JButton("Modificar");
        BotonModificarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonModificarEmpleado.setBounds(429, 460, 150, 31);
        getContentPane().add(BotonModificarEmpleado);
        
        ////////////////////////////////////////////////////////////////////////////
        
        /*
        * REGISTRO DE CLIENTES
        */
        
        JLabel LabelNuevoCliente = new JLabel("Registrar datos de nuevo cliente");
        LabelNuevoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelNuevoCliente.setBounds(353, 234, 301, 30);
        getContentPane().add(LabelNuevoCliente);
        
        JButton BotonRegistrarCliente = new JButton("Agregar");
        BotonRegistrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonRegistrarCliente.setBounds(429, 275, 150, 31);
        getContentPane().add(BotonRegistrarCliente);
        
        ////////////////////////////////////////////////////////////////////////////
        
        /*
         * BUSQUEDA DE EMPLEADO
         */
        
        JLabel LabelMostrarEmpleado = new JLabel("Mostrar datos de un empleado");
        LabelMostrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelMostrarEmpleado.setBounds(368, 513, 313, 23);
        getContentPane().add(LabelMostrarEmpleado);
        
        JButton BotonMostrarEmpleado = new JButton("Buscar");
        BotonMostrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonMostrarEmpleado.setBounds(429, 547, 150, 31);
        getContentPane().add(BotonMostrarEmpleado);
        
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
