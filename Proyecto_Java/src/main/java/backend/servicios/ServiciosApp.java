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
    // regresa el total de la venta para poder usarla en la generacion de facturas
    public double crearVenta(int idVenta, int identificadorACliente, int idCajeroQueRealizaVenta)
    {
        HashMap<Integer, Cliente> clientes = Datos.getTablaLookUpClientes();

        if (clientes == null)
        {
            //System.out.println("No hay clientes registrados");
            JOptionPane.showMessageDialog(null, "ERROR: NO HAY CLIENTES REGISTRADOS", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        if (!clientes.containsKey(identificadorACliente))
        {
            System.out.println("Cliente no encontrado");
            JOptionPane.showMessageDialog(null, "ERROR: CLIENTE NO ENCONTRADO", "Error", JOptionPane.ERROR_MESSAGE);
            identificadorACliente = -1;
        }

        // seteamos el tiempo actual para la fecha de la venta
        long tiempoActual = System.currentTimeMillis(); // tiempo en milisegundos
        Date fecha = new Date(tiempoActual); // convertimos el tiempo a una fecha

        // revisamos si el identificador del parametro es -1
        // es decir, si no se encontro el cliente
        Cliente cliente;
        if (identificadorACliente == -1) {
            // si no se encontro el cliente, se crea un cliente nuevo
            // sin embargo, este sera una instancia vacia
            // se valida que es una instancia vacia si su identificador es -1
            cliente = new Cliente();
        }else{
            // obtenemos el cliente que realizo la compra
            cliente = clientes.get(identificadorACliente);
        }
        
        // calcular el total de la venta
        

        Venta nuevaVenta = new Venta(
            idVenta,
            fecha,
            identificadorACliente,
            0.0,//total,
            idCajeroQueRealizaVenta
        );

        double totalVenta = 0.0;
        // Referencia al hashmap para actualizar el inventario
        HashMap<Integer, Producto> inventario = Datos.getTablaLookUpProductos();

        
        // valifacion de que se haya realizado la venta
        // Si el total es 0 quiere decir que no se vendio nada
        // debido a la falta de stock de todos los productos
        if (totalVenta == 0)
        {
        	JOptionPane.showMessageDialog(null, "ERROR: NO SE PUDO REALIZAR LA VENTA", "Error", JOptionPane.ERROR_MESSAGE);
        	//System.out.println("No se pudo realizar la venta");
            return -1;
        }
        // agregar la venta al historial del cajero
        //agregarVentaACajero(cajeroQueRealizaVenta, nuevaVenta);
        // actualizar el inventario
        Datos.setTablaLookUpProductos(inventario);

        // agregar la venta al historial de ventas
        HashMap<Integer, Venta> historialVentas = Datos.getTablaLookUpVentas();
        historialVentas.put(idVenta, nuevaVenta);
        Datos.setTablaLookUpVentas(historialVentas);

        return totalVenta;
    }

    public void generarFactura(int idVenta, int identificadorACliente, double totalVenta, int cajeroQueRealizaVenta)
    {
        double ventaRealizada = crearVenta(idVenta, identificadorACliente, cajeroQueRealizaVenta);

        // validacion de que se haya realizado la venta
        if (ventaRealizada == -1 || identificadorACliente == -1)
        {
        	JOptionPane.showMessageDialog(null, "ERROR GENERANDO LA FACTURA", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Venta ventaRecienCreada = Datos.getTablaLookUpVentas().get(idVenta);

        Factura facturaVentaRealizada = new Factura(
            idVenta,
            identificadorACliente,
            ventaRecienCreada,
            ventaRealizada
        );

        // Agregamos la venta realizada, por medio de la factura al cliente
        Cliente cliente = Datos.getTablaLookUpClientes().get(identificadorACliente);
        cliente.agregarCompra(facturaVentaRealizada);
        // actualizamos los puntos del cliente en base al total de su compra
        cliente.setPuntos(cliente.getPuntos() + (ventaRealizada * 0.01));
        // actualizamos el cliente en la base de datos
        HashMap<Integer, Cliente> tablaLookUpClientes = Datos.getTablaLookUpClientes();
        tablaLookUpClientes.put(identificadorACliente, cliente);

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
            // sobreescribimos el producto en la tabla original
            // usando el mismo id, la implementacion de HashMap
            // se encarga de sobreescribir el producto
            tablaLookUpProductos.put(producto.getId(), producto);

            // actualizamos el producto en la lista de productos
            tablaLookUpProductos.put(producto.getId(), producto);
        }

        // actualizamos la tabla de productos
        Datos.setTablaLookUpProductos(tablaLookUpProductos);
        Datos.setInventario(productos);

        return;
    }
}
