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
        
        JButton BotonAgregarProducto = new JButton("Agregar");
        BotonAgregarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar pan
            }
        });
        BotonAgregarProducto.setBounds(429, 82, 150, 31);
        getContentPane().add(BotonAgregarProducto);
        
        JButton BotonRegistrarCliente = new JButton("Agregar");
        BotonRegistrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonRegistrarCliente.setBounds(429, 275, 150, 31);
        getContentPane().add(BotonRegistrarCliente);
        
        JButton Eliminar_pan = new JButton("Modificar");
        Eliminar_pan.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Eliminar_pan.setBounds(429, 460, 150, 31);
        getContentPane().add(Eliminar_pan);
        
        JButton BotonRegistrarEmpleado = new JButton("Agregar");
        BotonRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonRegistrarEmpleado.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        BotonRegistrarEmpleado.setBounds(429, 370, 150, 31);
        getContentPane().add(BotonRegistrarEmpleado);
        
        JButton BotonEliminarProducto = new JButton("Editar");
        BotonEliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        BotonEliminarProducto.setBounds(429, 180, 150, 31);
        getContentPane().add(BotonEliminarProducto);
        
        JButton btnNewButton_5 = new JButton("Buscar");
        btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_5.setBounds(429, 547, 150, 31);
        getContentPane().add(btnNewButton_5);
        
        JLabel LabelNuevoProducto = new JLabel("Registrar un nuevo producto");
        LabelNuevoProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelNuevoProducto.setBounds(370, 42, 268, 23);
        getContentPane().add(LabelNuevoProducto);
        
        JLabel LabelEliminarProducto = new JLabel("Eliminar un producto de inventario");
        LabelEliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelEliminarProducto.setBounds(347, 138, 313, 31);
        getContentPane().add(LabelEliminarProducto);
        
        JLabel LabelRegistrarEmpleado = new JLabel("Registrar un empleado");
        LabelRegistrarEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelRegistrarEmpleado.setBounds(399, 328, 209, 31);
        getContentPane().add(LabelRegistrarEmpleado);
        
        JLabel lblNewLabel_3 = new JLabel("Modificar datos de un empleado");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(356, 418, 296, 31);
        getContentPane().add(lblNewLabel_3);
        
        JLabel LabelNuevoCliene = new JLabel("Registrar datos de nuevo cliente");
        LabelNuevoCliene.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LabelNuevoCliene.setBounds(353, 234, 301, 30);
        getContentPane().add(LabelNuevoCliene);
        
        JLabel lblNewLabel_5 = new JLabel("Mostrar datos de un empleado");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(368, 513, 313, 23);
        getContentPane().add(lblNewLabel_5);
        
        JButton Cerrar = new JButton("cerrar");
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
