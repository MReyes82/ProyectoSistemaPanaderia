package frontend.ventanasMenuPrincipal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.Vendedor;
import backend.servicios.ServiciosApp;
import frontend.ventanasLogin.Login;
import frontend.ventanasLogin.Soporte;
import backend.saves.Datos;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Principal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable Tabla_Cobro;
    private DefaultTableModel modeloTabla;
    private ArrayList<Producto> productosSeleccionados;
    private ArrayList<Integer> cantidadesSeleccionadas;
    private HashMap<Integer, Producto> copiaInventario;

    // identificador para asignar una venta a un cliente
    int identificadorDelCliente;
    // callback para los servicios de la aplicacion
    ServiciosApp callbackServicios = new ServiciosApp();

    /**
     * Create the frame.
     */
    public Principal() {
        setResizable(false);
        productosSeleccionados = new ArrayList<>();
        cantidadesSeleccionadas = new ArrayList<>();
        copiaInventario = clonarInventario(Datos.getTablaLookUpProductos());
        identificadorDelCliente = -1;


        setTitle("MENU PRINCIPAL DEL SISTEMA");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 1090, 800);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu productos = new JMenu("Agregar producto");
        menuBar.add(productos);

        JMenuItem AgregarPorID = new JMenuItem("Agregar producto a carrito");
        productos.add(AgregarPorID);

        JMenu Eliminar = new JMenu("Eliminar producto");
        menuBar.add(Eliminar);

        JMenuItem EliminarProducto = new JMenuItem("Eliminar producto de carrito");
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
            public void actionPerformed(ActionEvent e)
            {
                if (productosSeleccionados.size() == 0)
                {
                    // Mostrar un JOptionPane con un mensaje de error
                    JOptionPane.showMessageDialog(null, "No hay productos agregados en el carrito");
                } else {
                    calcularTotalCuenta();
                }
            }
        });

        JLabel LabelTextoCarrito = new JLabel("Carrito de compra\r\n");
        LabelTextoCarrito.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JButton BotonAgregarIdCliente = new JButton("Ingresar identificador de cliente");
        BotonAgregarIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
        BotonAgregarIdCliente.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                identificadorDelCliente = callbackServicios.establecerIdentificadorCliente();
            }
        });


        JLabel LabelProductosAgregados = new JLabel("Productos agregados:");
        LabelProductosAgregados.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JButton BotonLimpiarCarrito = new JButton("Vaciar Carrito");

        BotonLimpiarCarrito.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                limpiarCarrito();
            }
        });

        BotonLimpiarCarrito.setFont(new Font("Tahoma", Font.PLAIN, 25));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(45)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(BotonAgregarIdCliente)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(BotonLimpiarCarrito, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
        				.addComponent(aceptar_pagar, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 956, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(LabelProductosAgregados, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(LabelTextoCarrito, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)))
        			.addContainerGap(79, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(LabelTextoCarrito, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addGap(17)
        			.addComponent(LabelProductosAgregados)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
        			.addGap(48)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addComponent(BotonLimpiarCarrito, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        				.addComponent(BotonAgregarIdCliente, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
        			.addComponent(aceptar_pagar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        			.addGap(54))
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

        callbackServicios.establecerIdentificadorVendedor();
    }

    private HashMap<Integer, Producto> clonarInventario(HashMap<Integer, Producto> inventarioOriginal) {
        HashMap<Integer, Producto> inventarioClonado = new HashMap<>();
        for (Integer id : inventarioOriginal.keySet()) {
            Producto productoOriginal = inventarioOriginal.get(id);
            Producto productoClonado = new Producto(productoOriginal);
            inventarioClonado.put(id, productoClonado);
        }
        return inventarioClonado;
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
            int cantidad = cantidadesSeleccionadas.get(index);
            productosSeleccionados.remove(index);
            cantidadesSeleccionadas.remove(index);
            modeloTabla.removeRow(index);

            Producto productoOriginal = copiaInventario.get(producto.getId());
            productoOriginal.setStock(productoOriginal.getStock() + cantidad);
        }
    }

    public ArrayList<Producto> getProductosSeleccionados()
    {
        return productosSeleccionados;
    }

    public HashMap<Integer, Producto> getCopiaInventario() {
        return copiaInventario;
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
        // Crear e instanciar la ventana de recibo
        Recibo recibo = new Recibo(this);

        // Establecer el total en la ventana de recibo
        recibo.setTotal(total);

        // Agregar los productos al recibo
        DefaultTableModel modeloRecibo = (DefaultTableModel) recibo.getTable().getModel();
        for (int i = 0; i < productosSeleccionados.size(); i++) {
            Producto producto = productosSeleccionados.get(i);
            int cantidad = cantidadesSeleccionadas.get(i);
            modeloRecibo.addRow(new Object[] {producto.getNombre(), cantidad, producto.getPrecio() * cantidad});
        }

        // Mostrar el recibo
        recibo.setVisible(true);
    }

    public void limpiarCarrito()
    {
        productosSeleccionados.clear();
        cantidadesSeleccionadas.clear();
        modeloTabla.setRowCount(0);
        copiaInventario = clonarInventario(Datos.getTablaLookUpProductos());
    }

    public void actualizarInventarioReal()
    {
        new ServiciosApp().actualizarInventario(productosSeleccionados);
        limpiarCarrito();
    }
}
