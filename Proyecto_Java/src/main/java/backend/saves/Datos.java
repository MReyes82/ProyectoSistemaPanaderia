package backend.saves;
import backend.modelos.Cliente;
import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.*;

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

    // metodos para escribir a archivos

    // metodos para leer de archivos

}
