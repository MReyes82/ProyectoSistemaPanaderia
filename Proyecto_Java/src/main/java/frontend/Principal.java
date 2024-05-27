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
    public Principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1028, 768);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu bebidas = new JMenu("Bebidas");
        menuBar.add(bebidas);
        
        JMenuItem Agregar_bebidas = new JMenuItem("Agregar bebidas");
        bebidas.add(Agregar_bebidas);
        
        JMenu panes = new JMenu("Panes");
        menuBar.add(panes);
        
        JMenuItem Agregar_panes = new JMenuItem("Agregar panes");
        panes.add(Agregar_panes);
        
        JMenu otro = new JMenu("Opciones");
        menuBar.add(otro);
        
        JMenuItem Terminar = new JMenuItem("Cerrar sesión");
        otro.add(Terminar);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        
        Tabla_Cobro = new JTable();
        Tabla_Cobro.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null},
            },
            new String[] {
                "Producto", "Cantidad", "Costo"
            }
        ));
        scrollPane.setViewportView(Tabla_Cobro);
        
        JButton btn_borrar_tabla_cobro = new JButton("Borrar");
        
        JButton aceptar_pagar = new JButton("Pagar");
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(btn_borrar_tabla_cobro)
                            .addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                            .addComponent(aceptar_pagar)))
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btn_borrar_tabla_cobro)
                        .addComponent(aceptar_pagar))
                    .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);

        // Agregar ActionListener para abrir la ventana Tipo_bebida
        Agregar_bebidas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TipoBebida tipoBebida = new TipoBebida();
                tipoBebida.setVisible(true);
            }
        });
        
        // Agregar ActionListener para abrir la ventana Tipo_de_panes
        Agregar_panes.addActionListener(new ActionListener() {
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
        
        // Agregar ActionListener para abrir la ventana Resibo al hacer clic en "Pagar"
        aceptar_pagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Recibo resibo = new Recibo();
                resibo.setVisible(true);
                dispose(); // Cerrar la ventana actual de Principal
            }
        });
    }
}
