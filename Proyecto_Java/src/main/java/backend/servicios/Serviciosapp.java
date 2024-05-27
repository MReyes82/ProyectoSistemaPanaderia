package backend.servicios;

import backend.modelos.*;
import backend.modelos.herenciaEmpleados.Vendedor;
import backend.saves.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.*;

/*
* Metodos relacionados con funciones para la realizacion de ventas
* generacion de facturas y manejo de inventario
 */

public class Serviciosapp
{
    // regresa el total de la venta para poder usarla en la generacion de facturas
    public double crearVenta(int idVenta, int identificadorACliente, ArrayList<Producto> productosComprados, Vendedor cajeroQueRealizaVenta)
    {
        HashMap<Integer, Cliente> clientes = Datos.getTablaLookUpClientes();

        if (clientes == null)
        {
            System.out.println("No hay clientes registrados");
            return -1;
        }

        if (!clientes.containsKey(identificadorACliente))
        {
            System.out.println("Cliente no encontrado");
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

        Venta nuevaVenta = new Venta(
            idVenta,
            fecha,
            cliente,
            productosComprados,
                cajeroQueRealizaVenta
        );

        double totalVenta = 0.0;
        // Referencia al hashmap para actualizar el inventario
        HashMap<Integer, Producto> inventario = Datos.getTablaLookUpProductos();

        // calcular el total de la venta
        for (Producto productoActual : productosComprados)
        {
            // si se realizo la actualizacion del inventario
            if (actualizarInventario(productoActual, inventario))
            {
                totalVenta += productoActual.getPrecio();
            }
        }
        // valifacion de que se haya realizado la venta
        // Si el total es 0 quiere decir que no se vendio nada
        // debido a la falta de stock de todos los productos
        if (totalVenta == 0)
        {
            System.out.println("No se pudo realizar la venta");
            return -1;
        }
        // agregar la venta al historial del cajero
        agregarVentaACajero(cajeroQueRealizaVenta, nuevaVenta);
        // actualizar el inventario
        Datos.setTablaLookUpProductos(inventario);

        // agregar la venta al historial de ventas
        HashMap<Integer, Venta> historialVentas = Datos.getTablaLookUpVentas();
        historialVentas.put(idVenta, nuevaVenta);
        Datos.setTablaLookUpVentas(historialVentas);

        return totalVenta;
    }

    public void generarFactura(int idVenta, int identificadorACliente, ArrayList<Producto> productosComprados, Vendedor cajeroQueRealizaVenta)
    {
        double ventaRealizada = crearVenta(idVenta, identificadorACliente, productosComprados, cajeroQueRealizaVenta);

        // validacion de que se haya realizado la venta
        if (ventaRealizada == -1 || identificadorACliente == -1)
        {
            System.out.println("ERROR GENERANDO LA FACTURA");
            return;
        }

        Venta ventaRecienCreada = Datos.getTablaLookUpVentas().get(idVenta);

        Factura facturaVentaRealizada = new Factura(
            idVenta,
            ventaRecienCreada.getCliente(),
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
    public Boolean actualizarInventario(Producto productoActual, HashMap<Integer, Producto> tablaLookUpProductos)
    {
        // NOTA:
        // Se asume que el producto actual ya existe en el inventario
        // Ademas, las validaciones de stock se realiza razones practicas
        // A nivel de mayor escabilidad, no es necesario validar el stock
        // Pues solo se podra vender productos que esten en el inventario fisico

        if (productoActual.getStock() == 0)
        {
            System.out.println("STOCK INSUFICIENTE: " + productoActual.getNombre());
            return false;
        }

        // restamos uno ya que el objeto de Producto que recibe como parametro
        // pertene a un ArrayList en el cual se repite el producto
        // de acuerdo a la cantidad que se desea comprar
        productoActual.setStock(productoActual.getStock() - 1);
        tablaLookUpProductos.put(productoActual.getId(), productoActual);

        return true;
    }
}
