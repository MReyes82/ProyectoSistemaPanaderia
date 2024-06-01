package frontend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Soporte extends JFrame 
{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField admin;
    private JPasswordField clave_admin;

    // Credenciales de administrador
    private final String adminUser = "admin";
    private final String adminPass = "1234";

    public Soporte() 
    {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        setTitle("LOGIN DE ADMINISTRADOR");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                // Agregamos un mensaje de confirmacion para cerrar la aplicacion
                int confirmacion = JOptionPane.showOptionDialog(
                        Soporte.this,
                        "¿Regresar a Login normal?",
                        "Seleccione una opcion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, null, null);

                if (confirmacion == JOptionPane.YES_OPTION)
                {
                    //mainApp.cargarDatos();
                    // System.exit es el comando que se utiliza para cerrar la aplicacion totalmente
                    //System.exit(0);
                	Login regresoALogin = new Login();
                	regresoALogin.setVisible(true);
                	
                } else {
                    // Si el usuario selecciona que no, se cancela el cierre de la aplicacion
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        
        JLabel lblNewLabel = new JLabel("Usuario Admin");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(407, 255, 193, 29);
        contentPane.add(lblNewLabel);
        
        admin = new JTextField();
        admin.setBounds(398, 295, 212, 20);
        contentPane.add(admin);
        admin.setColumns(10);
        
        JLabel clave = new JLabel("Contraseña Admin");
        clave.setFont(new Font("Tahoma", Font.PLAIN, 30));
        clave.setBounds(378, 337, 251, 29);
        contentPane.add(clave);
        
        clave_admin = new JPasswordField();
        clave_admin.setBounds(398, 377, 212, 20);
        contentPane.add(clave_admin);
        
        JButton aceptar_admin = new JButton("Ingresar");
        aceptar_admin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        aceptar_admin.setBounds(386, 435, 235, 39);
        contentPane.add(aceptar_admin);
        
        JButton retornoLogin = new JButton("Regresar a login de usuario");
        retornoLogin.setBounds(26, 658, 302, 39);
        retornoLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(retornoLogin);
        
        retornoLogin.addActionListener(
        new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                dispose(); // Cierra la ventana actual de SOPORTE
                Login login = new Login(); // Crea una nueva instancia de la ventana de Login
                login.setVisible(true); // Muestra la ventana de Login
            }
        });
        
        aceptar_admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = admin.getText();
                String password = new String(clave_admin.getPassword());
                
                if (username.equals(adminUser) && password.equals(adminPass)) {
                    dispose(); // Cierra la ventana actual de SOPORTE
                    Mantenimiento mantenimiento = new Mantenimiento(); // Crea una nueva instancia de la ventana de Mantenimiento
                    mantenimiento.setVisible(true); // Muestra la ventana de Mantenimiento
                } else {
                    // Muestra un mensaje de error
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
