package frontend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable Tabla_Cobro;

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
    public Principal() 
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1028, 768);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu productos = new JMenu("Agregar producto");
        menuBar.add(productos);
        
        JMenuItem AgregarPorID = new JMenuItem("Ingresar ID de producto");
        productos.add(AgregarPorID);
        
        JMenuItem AgregarPorNombre = new JMenuItem("Ingresar nombre de producto");
        productos.add(AgregarPorNombre);
        
        JMenu Eliminar = new JMenu("Eliminar producto");
        menuBar.add(Eliminar);
        
        JMenuItem EliminarProducto = new JMenuItem("Eliminar...");
        Eliminar.add(EliminarProducto);
        
        JMenu otro = new JMenu("Opciones");
        menuBar.add(otro);
        
        JMenuItem Terminar = new JMenuItem("Cerrar sesión");
        otro.add(Terminar);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        
        Tabla_Cobro = new JTable();
        Tabla_Cobro.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        Tabla_Cobro.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null},
            },
            new String[] {
                "Producto", "Cantidad", "Costo"
            }
        ));
        scrollPane.setViewportView(Tabla_Cobro);
        
        JButton aceptar_pagar = new JButton("Cobrar cuenta");
        aceptar_pagar.setFont(new Font("Tahoma", Font.PLAIN, 25));
        
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

        // Agregar ActionListener para abrir la ventana Tipo_bebida
        AgregarPorID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AgregarProductoCanasta tipoBebida = new AgregarProductoCanasta();
                tipoBebida.setVisible(true);
            }
        });
        
        AgregarPorNombre.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		
        	}
        });
        
        // Agregar ActionListener para abrir la ventana Tipo_de_panes
        EliminarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TipoPanes tipoDePanes = new TipoPanes();
                tipoDePanes.setVisible(true);
            }
        });
        
        // Agregar ActionListener para cerrar sesión y abrir la ventana Login
        Terminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose(); // Cerrar la ventana actual de Principal
            }
        });
        
        // Agregar ActionListener para abrir la ventana Recibo al hacer clic en "Pagar"
        aceptar_pagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Recibo recibo = new Recibo();
                recibo.setVisible(true);
                dispose(); // Cerrar la ventana actual de Principal
            }
        });
    }
}
