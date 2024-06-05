package frontend.ventanasMenuPrincipal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.saves.Datos;
import backend.servicios.ServiciosApp;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recibo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private double total;
    private Principal principal;

    /**
     * Create the frame.
     */
    public Recibo(Principal principal) {
        this.principal = principal;

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
                new Object[][] {},
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
        ImprimirRecibo.setBackground(new Color(0, 153, 204));
        ImprimirRecibo.setForeground(Color.WHITE);

        ImprimirRecibo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Recibo.this, "Total de la cuenta: " + total);
                principal.actualizarInventarioReal();

                ServiciosApp callbackServiciosApp = new ServiciosApp();

                callbackServiciosApp.crearVenta(
                    principal.identificadorDelCliente,
                    Datos.getIdentificadorVendedorActual(),
                    total
                );

                principal.identificadorDelCliente = -1; // reestablecemos el identificador del cliente tras la venta.

                dispose();
            }
        });
        ImprimirRecibo.setBounds(289, 209, 101, 23);
        contentPane.add(ImprimirRecibo);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCancelar.setBackground(new Color(204, 0, 0));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBounds(32, 209, 101, 23);
        contentPane.add(btnCancelar);

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(Recibo.this,
                        "¿Está seguro que desea cancelar la compra?",
                        "Cancelar compra", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    dispose();
                    int confirmacionLimpiarCarrito = JOptionPane.showConfirmDialog(Recibo.this,
                            "¿Desea limpiar el carrito?",
                            "Limpiar carrito", JOptionPane.YES_NO_OPTION);

                    if (confirmacionLimpiarCarrito == JOptionPane.YES_OPTION) {
                        principal.limpiarCarrito();
                    }

                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    public JTable getTable() {
        return table;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
