package frontend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.modelos.Producto;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable Tabla_Cobro;
    private DefaultTableModel modeloTabla;
    private ArrayList<Producto> productosSeleccionados;
    private ArrayList<Integer> cantidadesSeleccionadas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Principal() {
        productosSeleccionados = new ArrayList<>();
        cantidadesSeleccionadas = new ArrayList<>();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1028, 768);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu productos = new JMenu("Agregar producto");
        menuBar.add(productos);

        JMenuItem AgregarPorID = new JMenuItem("Elegir de inventario");
        productos.add(AgregarPorID);

        JMenu Eliminar = new JMenu("Eliminar producto");
        menuBar.add(Eliminar);

        JMenuItem EliminarProducto = new JMenuItem("Eliminar...");
        Eliminar.add(EliminarProducto);

        JMenu otro = new JMenu("Opciones");
        menuBar.add(otro);

        JMenuItem Terminar = new JMenuItem("Cerrar sesión");
        otro.add(Terminar);
        
        JMenuItem entrarEnModoAdmin = new JMenuItem("Acceder a modo admin");
        otro.add(entrarEnModoAdmin);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        Tabla_Cobro = new JTable();
        Tabla_Cobro.setFont(new Font("Tahoma", Font.PLAIN, 14));

        modeloTabla = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Producto", "Cantidad", "Costo"}
        );
        Tabla_Cobro.setModel(modeloTabla);
        scrollPane.setViewportView(Tabla_Cobro);

        JButton aceptar_pagar = new JButton("Cobrar cuenta");
        aceptar_pagar.setFont(new Font("Tahoma", Font.PLAIN, 25));
        aceptar_pagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTotalCuenta();
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                        .addComponent(aceptar_pagar, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                    .addComponent(aceptar_pagar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);

        // Agregar ActionListener para abrir la ventana de agregar producto al carrito
        AgregarPorID.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                AgregarProductoCanasta agregarCarrito = new AgregarProductoCanasta(Principal.this);
                agregarCarrito.setVisible(true);
            }
        });

        // Agregar ActionListener para abrir la ventana EliminarProductoCanasta
        EliminarProducto.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                EliminarProductoCanasta eliminarProductoCanasta = new EliminarProductoCanasta(Principal.this);
                eliminarProductoCanasta.setVisible(true);
            }
        });

        // Agregar ActionListener para cerrar sesión y abrir la ventana Login
        Terminar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                Login login = new Login();
                login.setVisible(true);
                dispose(); // Cerrar la ventana actual de Principal
            }
        });
        
        entrarEnModoAdmin.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		dispose();
        		Soporte soporte = new Soporte();
        		soporte.setVisible(true);
        	}
        });
    }

    public void agregarProductoATabla(Producto producto, int cantidad, double costo) 
    {
        modeloTabla.addRow(new Object[] {producto.getNombre(), cantidad, costo});
        productosSeleccionados.add(producto);
        cantidadesSeleccionadas.add(cantidad);
    }

    public void eliminarProductoDeTabla(Producto producto) 
    {
        int index = productosSeleccionados.indexOf(producto);
        
        if (index != -1) 
        {
            productosSeleccionados.remove(index);
            cantidadesSeleccionadas.remove(index);
            modeloTabla.removeRow(index);
        }
    }

    public ArrayList<Producto> getProductosSeleccionados() 
    {
        return productosSeleccionados;
    }

    private void calcularTotalCuenta() 
    {
        double total = 0;
        for (int i = 0; i < productosSeleccionados.size(); i++) 
        {
            Producto producto = productosSeleccionados.get(i);
            int cantidad = cantidadesSeleccionadas.get(i);
            total += producto.getPrecio() * cantidad;
        }
        JOptionPane.showMessageDialog(this, "Total de la cuenta: " + total);
    }
}
