package frontend.ventanasMenuPrincipal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Recibo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private double total;

    /**
     * Create the frame.
     */
    public Recibo() 
    {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(32, 11, 358, 172);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null},
            },
            new String[] {
                "Producto", "Cantidad", "Costo"
            }
        ) {
            boolean[] columnEditables = new boolean[] {
                false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        scrollPane.setViewportView(table);

        JButton ImprimirRecibo = new JButton("Imprimir");
        ImprimirRecibo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ImprimirRecibo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                JOptionPane.showMessageDialog(Recibo.this, "Total de la cuenta: " + total);

                dispose();
            }
        });
        ImprimirRecibo.setBounds(289, 209, 101, 23);
        contentPane.add(ImprimirRecibo);
    }

    public JTable getTable() {
        return table;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
