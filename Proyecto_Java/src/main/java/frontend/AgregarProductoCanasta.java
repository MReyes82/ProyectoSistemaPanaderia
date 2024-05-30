package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class AgregarProductoCanasta extends JFrame {

	// TODO: REFACTOR
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarProductoCanasta frame = new AgregarProductoCanasta();
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
	public AgregarProductoCanasta() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox Tipo_bebidas = new JComboBox();
		Tipo_bebidas.setBounds(64, 109, 209, 22);
		contentPane.add(Tipo_bebidas);
		
		JSpinner Cantidad_bebidas = new JSpinner();
		Cantidad_bebidas.setBounds(327, 110, 30, 20);
		contentPane.add(Cantidad_bebidas);
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.setBounds(172, 174, 89, 23);
		contentPane.add(Aceptar);
	}
}
