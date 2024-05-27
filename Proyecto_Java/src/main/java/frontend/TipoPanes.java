package frontend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class TipoPanes extends JFrame {

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
                    TipoPanes frame = new TipoPanes();
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
    public TipoPanes() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JComboBox<String> Tipo_panes = new JComboBox<>();
        Tipo_panes.setMaximumRowCount(16);
        Tipo_panes.setBounds(34, 87, 102, 22);
        contentPane.add(Tipo_panes);
        
        JSpinner Cantidad_panes = new JSpinner();
        Cantidad_panes.setBounds(257, 88, 30, 20);
        contentPane.add(Cantidad_panes);
        
        JButton btnNewButton = new JButton("Aceptar");
        btnNewButton.setBounds(59, 159, 89, 23);
        contentPane.add(btnNewButton);
    }
}
