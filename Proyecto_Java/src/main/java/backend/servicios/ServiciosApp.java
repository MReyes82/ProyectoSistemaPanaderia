package backend.servicios;

import backend.modelos.*;
import backend.modelos.herenciaEmpleados.Vendedor;
import backend.saves.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

/*
* Metodos relacionados con funciones para la realizacion de ventas
* generacion de facturas y manejo de inventario
 */

public class ServiciosApp
{
    // regresa el total de la venta para poder usarla en la generacion de facturas\
    public void crearVenta(int identificadorACliente, int idCajeroQueRealizaVenta, double totalDeLaventa)
    {
        /*
        * REFACTOR: se cambio la implementacion anterior
        * para simplificarla
        */

        if (identificadorACliente == -1)
        System.out.println("Debug: id de cliente es -1");        // generamos un id random para la venta
        int idVenta;

        do {
             idVenta = (int) (Math.random() * 1000000) + 1;

        } while (Datos.getTablaLookUpVentas().containsKey(idVenta)); // mientras que el id generado ya exista en el historial de ventas

        // seteamos el tiempo actual para la fecha de la venta
        long tiempoActual = System.currentTimeMillis(); // tiempo en milisegundos
        Date fecha = new Date(tiempoActual); // convertimos el tiempo a una fecha
        Venta nuevaVenta = new Venta(idVenta, fecha, identificadorACliente, totalDeLaventa, idCajeroQueRealizaVenta);

        // metemos el valor al hashmap de ventas
        HashMap<Integer, Venta> historialVentas = Datos.getTablaLookUpVentas();
        historialVentas.put(idVenta, nuevaVenta);
        Datos.setTablaLookUpVentas(historialVentas);

        // agregamos la venta al historial del vendedor
        // Nota: no se realiza validacion de si el vendedor existe
        // ya que la validacion se maneja en la interfaz
        // (Clase "Principal")
        Vendedor cajero = (Vendedor) Datos.getTablaLookUpEmpleados().get(idCajeroQueRealizaVenta);
        agregarVentaACajero(cajero, nuevaVenta);

        crearFactura(idVenta, identificadorACliente, totalDeLaventa, nuevaVenta);

        return;
    }

    public void crearFactura(int idVenta, int referenciaCliente, double totalDeLaVenta, Venta referenciaVenta)
    {
        /*
        * REFACTOR: se cambio la implementacion anterior
        * para simplificarla
        */
        System.out.println("Debug: Creando factura para venta con id: " + idVenta + " y cliente con id: " + referenciaCliente);

        Factura nuevaFactura = new Factura(idVenta, referenciaCliente, referenciaVenta, totalDeLaVenta);

        // agregamos la factura al historial de facturas del cliente, validando que se haya proporcionado un id a cliente
        if (referenciaCliente != -1)
        {
            Cliente cliente = Datos.getTablaLookUpClientes().get(referenciaCliente);
            cliente.agregarCompra(nuevaFactura);

            // actualizamos los puntos del cliente en base al total de su compra
            cliente.setPuntos(cliente.getPuntos() + (totalDeLaVenta * 0.01));

            // actualizamos el cliente en la base de datos
            HashMap<Integer, Cliente> tablaLookUpClientes = Datos.getTablaLookUpClientes();
            tablaLookUpClientes.put(referenciaCliente, cliente);
            Datos.setTablaLookUpClientes(tablaLookUpClientes);
        }

        return;
    }

    // metodo para agregar la venta al historial de ventas del cajero
    public void agregarVentaACajero(Vendedor cajero, Venta venta)
    {
        cajero.agregarVenta(venta);
    }

    // metodo para actualizar el inventario despues de una venta
    // regresa true si se actualizo correctamente
    public void actualizarInventario(ArrayList<Producto> productosSeleccionados)
    {
        /*
        REFACTOR: se cambio la implementacion anterior
        */

        // actualizamos la tabla original de productos, usando la lista de productos seleccionados
        // los cuales, ya tienen el stock modificado a la que sera la nueva cantidad
        HashMap<Integer, Producto> tablaLookUpProductos = Datos.getTablaLookUpProductos();
        ArrayList<Producto> productos = Datos.getInventario();
        for (Producto producto : productosSeleccionados)
        {
            tablaLookUpProductos.put(producto.getId(), producto);

            for (int i = 0 ; i < productos.size() ; i++)
            {
                Producto productoActual = productos.get(i);

                if (productoActual.getId() == producto.getId())
                {
                    productos.set(i, producto);
                    break;
                }
            }
        }

        // actualizamos la tabla de productos
        Datos.setTablaLookUpProductos(tablaLookUpProductos);
        Datos.setInventario(productos);

        return;
    }

    // REFACTOR: metodo para establecer un identificador de cliente para realizar una venta
    public int establecerIdentificadorCliente()
    {
        Integer tmp = -1;

        while (tmp == null || tmp < 0)
        {
            try
            {
                tmp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del cliente"));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un identificador valido.");
            }

            if (Datos.getTablaLookUpClientes().containsKey(tmp))
            {
                JOptionPane.showMessageDialog(null, "Cliente encontrado: " + Datos.getTablaLookUpClientes().get(tmp).toString());
                return tmp;

            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado, no se asignara un cliente a la venta.");
            }
        }

        return -1; // en caso de que no se encuentra el cliente, el valor se queda igual cuando no hay id de cliente; -1
    }

    // REFACTOR: metodo para establecer un identificador de vendedor para realizar una venta
    public void establecerIdentificadorVendedor()
    {
        if (Datos.getIdentificadorVendedorActual() !=  -1) // si no es -1 quiere decir que hay un identificador establecido
        {
            return;
        }

        Integer tmp = -1;

        while (tmp == null || tmp < 0)
        {
            try {
                tmp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del vendedor"));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un identificador valido.");
            }

            // verificamos que el identificaodr corresponda a un vendedor registrado
            if (Datos.getTablaLookUpEmpleados().containsKey(tmp))
            {
                if (Datos.getTablaLookUpEmpleados().get(tmp) instanceof Vendedor)
                {
                    Datos.setIdentificadorVendedorActual(tmp);
                    return;

                } else {
                    JOptionPane.showMessageDialog(null, "El identificador proporcionado no corresponde a un vendedor.");
                    tmp = -1;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El identificador proporcionado no corresponde a ningun empleado registrado.");
                tmp = -1;
            }
        }
    }
}
