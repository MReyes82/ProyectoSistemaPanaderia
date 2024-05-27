package backend.saves;
import backend.modelos.Cliente;
import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.*;
//import backend.saves.archivosAlmacenamiento.*;
import backend.saves.archivosClases.*;
import backend.servicios.Venta;

import java.io.IOException;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
// en este paquete se incluyen los archivos para persistencia de datos y la clase control

public class Datos // Clase control para el manejo de datos
{
    // lista de productos en el inventario
    public static ArrayList<Producto> inventario;
    // listas de empleados registrados
    public static ArrayList<Limpieza> empleadosLimpieza;
    public static ArrayList<Panadero> empleadosPanaderos;
    public static ArrayList<Vendedor> empleadosCajeros;
    public static ArrayList<Cliente> clientes;
    public static HashMap<Integer, Empleado> tablaLookUpEmpleados;
    public static HashMap<Integer, Producto> tablaLookUpProductos;
    public static HashMap<Integer, Cliente> tablaLookUpClientes;

    public static HashMap<Integer, Venta> tablaLookUpVentas;

    // listas de clientes registrados


    // inicializar las listas
    public static void inicializarDatos()
    {
        inventario = new ArrayList<Producto>();
        empleadosLimpieza = new ArrayList<Limpieza>();
        empleadosPanaderos = new ArrayList<Panadero>();
        empleadosCajeros = new ArrayList<Vendedor>();
        clientes = new ArrayList<Cliente>();
        tablaLookUpEmpleados = new HashMap<Integer, Empleado>();
        tablaLookUpProductos = new HashMap<Integer, Producto>();
        tablaLookUpClientes = new HashMap<Integer, Cliente>();
        tablaLookUpVentas = new HashMap<Integer, Venta>();
    }

    public static ArrayList<Producto> getInventario()
    {
        return inventario;
    }

    public static void setInventario(ArrayList<Producto> inventario)
    {
        Datos.inventario = inventario;
    }

    public static ArrayList<Limpieza> getEmpleadosLimpieza()
    {
        return empleadosLimpieza;
    }

    public static void setEmpleadosLimpieza(ArrayList<Limpieza> empleadosLimpieza)
    {
        Datos.empleadosLimpieza = empleadosLimpieza;
    }

    public static ArrayList<Panadero> getEmpleadosPanaderos()
    {
        return empleadosPanaderos;
    }

    public static void setEmpleadosPanaderos(ArrayList<Panadero> empleadosPanaderos)
    {
        Datos.empleadosPanaderos = empleadosPanaderos;
    }

    public static ArrayList<Vendedor> getEmpleadosCajeros()
    {
        return empleadosCajeros;
    }

    public static void setEmpleadosCajeros(ArrayList<Vendedor> empleadosCajeros)
    {
        Datos.empleadosCajeros = empleadosCajeros;
    }

    public static ArrayList<Cliente> getClientes()
    {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes)
    {
        Datos.clientes = clientes;
    }

    public static HashMap<Integer, Empleado> getTablaLookUpEmpleados()
    {
        return tablaLookUpEmpleados;
    }

    public static void setTablaLookUpEmpleados(HashMap<Integer, Empleado> tablaLookUpEmpleados)
    {
        Datos.tablaLookUpEmpleados = tablaLookUpEmpleados;
    }

    public static HashMap<Integer, Producto> getTablaLookUpProductos()
    {
        return tablaLookUpProductos;
    }

    public static void setTablaLookUpProductos(HashMap<Integer, Producto> tablaLookUpProductos)
    {
        Datos.tablaLookUpProductos = tablaLookUpProductos;
    }

    public static HashMap<Integer, Cliente> getTablaLookUpClientes()
    {
        return tablaLookUpClientes;
    }

    public static void setTablaLookUpClientes(HashMap<Integer, Cliente> tablaLookUpClientes)
    {
        Datos.tablaLookUpClientes = tablaLookUpClientes;
    }

    public static HashMap<Integer, Venta> getTablaLookUpVentas()
    {
        return tablaLookUpVentas;
    }

    public static void setTablaLookUpVentas(HashMap<Integer, Venta> tablaLookUpVentas)
    {
        Datos.tablaLookUpVentas = tablaLookUpVentas;
    }
    // metodos para escribir a archivos
    public static void guardarDatosArrayList() {
        try {
            GestorProducto gestorProducto = new GestorProducto();
            gestorProducto.guardarDatos("backend/saves/archivosAlmacenamiento/productos.ser", inventario);

            GestorLimpieza gestorLimpieza = new GestorLimpieza();
            gestorLimpieza.guardarDatos("backend/saves/archivosAlmacenamiento/empleadosLimpieza.ser", empleadosLimpieza);

            GestorPanadero gestorPanadero = new GestorPanadero();
            gestorPanadero.guardarDatos("backend/saves/archivosAlmacenamiento/empleadosPanaderos.ser", empleadosPanaderos);

            GestorVendedor gestorVendedor = new GestorVendedor();
            gestorVendedor.guardarDatos("backend/saves/archivosAlmacenamiento/empleadosCajeros.ser", empleadosCajeros);

            GestorCliente gestorCliente = new GestorCliente();
            gestorCliente.guardarDatos("backend/saves/archivosAlmacenamiento/clientes.ser", clientes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatosHashMap() {
        try {
            GestorTablaProductos gestorTablaProductos = new GestorTablaProductos();
            gestorTablaProductos.guardarDatos("backend/saves/archivosAlmacenamiento/productosHashMap.ser", tablaLookUpProductos);

            GestorTablaEmpleados gestorTablaEmpleados = new GestorTablaEmpleados();
            gestorTablaEmpleados.guardarDatos("backend/saves/archivosAlmacenamiento/empleadosHashMap.ser", tablaLookUpEmpleados);

            GestorTablaClientes gestorTablaClientes = new GestorTablaClientes();
            gestorTablaClientes.guardarDatos("backend/saves/archivosAlmacenamiento/clientesHashMap.ser", tablaLookUpClientes);

            GestorTablaVentas gestorTablaVentas = new GestorTablaVentas();
            gestorTablaVentas.guardarDatos("backend/saves/archivosAlmacenamiento/ventasHashMap.ser", tablaLookUpVentas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodos para leer de archivos
    public static void cargarDatosArrayList() {
        // usamos los metodos set para evitar acceder directamente a los atributos
        try {
            GestorProducto gestorProducto = new GestorProducto();
            setInventario(gestorProducto.cargarDatos("backend/saves/archivosAlmacenamiento/productos.ser"));

            GestorLimpieza gestorLimpieza = new GestorLimpieza();
            setEmpleadosLimpieza(gestorLimpieza.cargarDatos("backend/saves/archivosAlmacenamiento/empleadosLimpieza.ser"));

            GestorPanadero gestorPanadero = new GestorPanadero();
            setEmpleadosPanaderos(gestorPanadero.cargarDatos("backend/saves/archivosAlmacenamiento/empleadosPanaderos.ser"));

            GestorVendedor gestorVendedor = new GestorVendedor();
            setEmpleadosCajeros(gestorVendedor.cargarDatos("backend/saves/archivosAlmacenamiento/empleadosCajeros.ser"));

            GestorCliente gestorCliente = new GestorCliente();
            setClientes(gestorCliente.cargarDatos("backend/saves/archivosAlmacenamiento/clientes.ser"));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void cargarDatosHashMap() {
        try {
            GestorTablaProductos gestorTablaProductos = new GestorTablaProductos();
            setTablaLookUpProductos(gestorTablaProductos.cargarDatos("backend/saves/archivosAlmacenamiento/productosHashMap.ser"));

            GestorTablaEmpleados gestorTablaEmpleados = new GestorTablaEmpleados();
            setTablaLookUpEmpleados(gestorTablaEmpleados.cargarDatos("backend/saves/archivosAlmacenamiento/empleadosHashMap.ser"));

            GestorTablaClientes gestorTablaClientes = new GestorTablaClientes();
            setTablaLookUpClientes(gestorTablaClientes.cargarDatos("backend/saves/archivosAlmacenamiento/clientesHashMap.ser"));

            GestorTablaVentas gestorTablaVentas = new GestorTablaVentas();
            setTablaLookUpVentas(gestorTablaVentas.cargarDatos("backend/saves/archivosAlmacenamiento/ventasHashMap.ser"));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
