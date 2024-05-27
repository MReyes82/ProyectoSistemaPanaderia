package frontend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Usuario;
    private JPasswordField contra_usuario;
    
    // credenciales para ingreso
    private String user = "marcuchi";
    private String pass = "VivaJava";

    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
    
    public void ejecutar()
    {
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() 
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setBounds(432, 264, 107, 20);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        contentPane.add(lblNewLabel);
        
        Usuario = new JTextField();
        Usuario.setBounds(380, 295, 212, 20);
        contentPane.add(Usuario);
        Usuario.setColumns(10);
        
        JLabel Contra = new JLabel("Contraseña");
        Contra.setBounds(415, 337, 150, 29);
        Contra.setFont(new Font("Times New Roman", Font.BOLD, 30));
        contentPane.add(Contra);
        
        contra_usuario = new JPasswordField();
        contra_usuario.setBounds(380, 377, 212, 20);
        contentPane.add(contra_usuario);
        
        JButton Ingreso_usuario = new JButton("Ingresar");
        Ingreso_usuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Ingreso_usuario.setBounds(369, 435, 235, 39);
        contentPane.add(Ingreso_usuario);
        
        JButton btnNewButton_1 = new JButton("Soporte");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(26, 631, 161, 66);
        contentPane.add(btnNewButton_1);
        
        Ingreso_usuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = Usuario.getText();
                String contrasena = new String(contra_usuario.getPassword());
                boolean credencialesCorrectas = verificarCredenciales(usuario, contrasena);

                if (credencialesCorrectas) {
                    dispose(); // Cierra la ventana actual de Login
                    Principal principal = new Principal(); // Crea una nueva instancia de la ventana Principal
                    principal.setVisible(true); // Muestra la ventana Principal
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual de Login
                Soporte soporte = new Soporte(); // Crea una nueva instancia de la ventana de SOPORTE
                soporte.setVisible(true); // Muestra la ventana de SOPORTE
            }
        });
    }
    
    private boolean verificarCredenciales(String usuario, String contrasena) {
        return usuario.equals(user) && contrasena.equals(pass);
    }
}
