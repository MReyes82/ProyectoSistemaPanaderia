package frontend.ventanasLogin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

import APLICACION_PRINCIPAL.mainApp;
import frontend.ventanasMenuPrincipal.Principal;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Usuario;
    private JPasswordField contra_usuario;

    // credenciales para ingreso
    private String user = "user";
    private String pass = "user123";

    public void iniciarFrontEnd()
    {
        EventQueue.invokeLater(
                new Runnable()
                {
                    public void run()
                    {
                        try {
                            Login pantallaInicio = new Login();
                            pantallaInicio.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

    public Login() {
    	setResizable(false);
        setTitle("LOGIN DE USUARIO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Ventana de confirmacion de salida. Utilizada para saber
        // cuando mandar a llamar al metodo de almacenamiento de datos.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Agregamos un mensaje de confirmacion para cerrar la aplicacion
                int confirmacion = JOptionPane.showOptionDialog(
                        Login.this,
                        "¿Esta seguro de que desea salir?",
                        "Confirmar cierre",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, null, null);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    //ClassLoader classLoader = mainApp.class.getClassLoader();
                    //mainApp.cargarDatos(classLoader);
                    System.out.println("Adios!");

                    // System.exit es el comando que se utiliza para cerrar la aplicacion totalmente
                    System.exit(0);
                } else {
                    // Si el usuario selecciona que no, se cancela el cierre de la aplicacion
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        // Añadir imagen
        ClassLoader imagen = getClass().getClassLoader();
        ImageIcon icon = new ImageIcon(imagen.getResource("imagenes/image.jpeg"));
        //JLabel lblImagen = new JLabel(new ImageIcon("src/main/resources/imagenes/image.jpeg"));
        JLabel lblImagen = new JLabel(icon);
        lblImagen.setBounds(376, 59, 256, 244); // Ajusta la posición y tamaño de la imagen
        contentPane.add(lblImagen);

        JLabel lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setBounds(450, 311, 107, 29);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contentPane.add(lblNewLabel);

        Usuario = new JTextField();
        Usuario.setBounds(386, 350, 235, 20);
        contentPane.add(Usuario);
        Usuario.setColumns(10);

        JLabel Contra = new JLabel("Contraseña");
        Contra.setBounds(422, 392, 163, 29);
        Contra.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contentPane.add(Contra);

        contra_usuario = new JPasswordField();
        contra_usuario.setBounds(386, 432, 235, 20);
        contentPane.add(contra_usuario);

        JButton Ingreso_usuario = new JButton("Ingresar");
        Ingreso_usuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Ingreso_usuario.setBounds(386, 490, 235, 39);
        contentPane.add(Ingreso_usuario);

        JButton btnNewButton_1 = new JButton("Login de administrador");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(26, 644, 267, 53);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("Bienvenido");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel_1.setBounds(428, 12, 152, 39);
        contentPane.add(lblNewLabel_1);

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
