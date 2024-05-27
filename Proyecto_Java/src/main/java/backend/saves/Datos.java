package backend.saves;
import backend.modelos.Cliente;
import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.*;
import backend.saves.archivosAlmacenamiento.*;
import backend.saves.archivosClases.*;

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
    public static void guardarDatosArrayList() {
        try {
            GestorProducto gestorProducto = new GestorProducto();
            gestorProducto.guardarDatos("src/main/java/backend/saves/archivos/productos.txt", inventario);

            GestorLimpieza gestorLimpieza = new GestorLimpieza();
            gestorLimpieza.guardarDatos("src/main/java/backend/saves/archivos/empleadosLimpieza.txt", empleadosLimpieza);

            GestorPanadero gestorPanadero = new GestorPanadero();
            gestorPanadero.guardarDatos("src/main/java/backend/saves/archivos/empleadosPanaderos.txt", empleadosPanaderos);

            GestorVendedor gestorVendedor = new GestorVendedor();
            gestorVendedor.guardarDatos("src/main/java/backend/saves/archivos/empleadosCajeros.txt", empleadosCajeros);

            GestorCliente gestorCliente = new GestorCliente();
            gestorCliente.guardarDatos("src/main/java/backend/saves/archivos/clientes.txt", clientes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatosHashMap() {
        try {
            GestorTablaProductos gestorTablaProductos = new GestorTablaProductos();
            gestorTablaProductos.guardarDatos("src/main/java/backend/saves/archivos/productosHashMap.txt", tablaLookUpProductos);

            GestorTablaEmpleados gestorTablaEmpleados = new GestorTablaEmpleados();
            gestorTablaEmpleados.guardarDatos("src/main/java/backend/saves/archivos/empleadosHashMap.txt", tablaLookUpEmpleados);

            GestorTablaClientes gestorTablaClientes = new GestorTablaClientes();
            gestorTablaClientes.guardarDatos("src/main/java/backend/saves/archivos/clientesHashMap.txt", tablaLookUpClientes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodos para leer de archivos
    public static void cargarDatosArrayList() {
        // usamos los metodos set para evitar acceder directamente a los atributos
        try {
            GestorProducto gestorProducto = new GestorProducto();
            setInventario(gestorProducto.cargarDatos("src/main/java/backend/saves/archivos/productos.txt"));

            GestorLimpieza gestorLimpieza = new GestorLimpieza();
            setEmpleadosLimpieza(gestorLimpieza.cargarDatos("src/main/java/backend/saves/archivos/empleadosLimpieza.txt"));

            GestorPanadero gestorPanadero = new GestorPanadero();
            setEmpleadosPanaderos(gestorPanadero.cargarDatos("src/main/java/backend/saves/archivos/empleadosPanaderos.txt"));

            GestorVendedor gestorVendedor = new GestorVendedor();
            setEmpleadosCajeros(gestorVendedor.cargarDatos("src/main/java/backend/saves/archivos/empleadosCajeros.txt"));

            GestorCliente gestorCliente = new GestorCliente();
            setClientes(gestorCliente.cargarDatos("src/main/java/backend/saves/archivos/clientes.txt"));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void cargarDatosHashMap() {
        try {
            GestorTablaProductos gestorTablaProductos = new GestorTablaProductos();
            setTablaLookUpProductos(gestorTablaProductos.cargarDatos("src/main/java/backend/saves/archivos/productosHashMap.txt"));

            GestorTablaEmpleados gestorTablaEmpleados = new GestorTablaEmpleados();
            setTablaLookUpEmpleados(gestorTablaEmpleados.cargarDatos("src/main/java/backend/saves/archivos/empleadosHashMap.txt"));

            GestorTablaClientes gestorTablaClientes = new GestorTablaClientes();
            setTablaLookUpClientes(gestorTablaClientes.cargarDatos("src/main/java/backend/saves/archivos/clientesHashMap.txt"));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
