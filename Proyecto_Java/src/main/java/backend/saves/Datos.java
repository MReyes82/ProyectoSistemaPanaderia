package backend.saves;
import backend.modelos.Cliente;
import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.*;
//import backend.saves.archivosAlmacenamiento.*;
import backend.saves.archivosClases.*;
import backend.servicios.Factura;
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
            gestorProducto.guardarDatos("src/main/java/backend/saves/archivosAlmacenamiento/productos.ser", inventario);
            //gestorProducto.guardarDatos("archivosAlmacenamiento/productos.ser", inventario);

            GestorLimpieza gestorLimpieza = new GestorLimpieza();
            gestorLimpieza.guardarDatos("src/main/java/backend/saves/archivosAlmacenamiento/empleadosLimpieza.ser", empleadosLimpieza);
            //gestorLimpieza.guardarDatos("archivosAlmacenamiento/empleadosLimpieza.ser", empleadosLimpieza);

            GestorPanadero gestorPanadero = new GestorPanadero();
            gestorPanadero.guardarDatos("src/main/java/backend/saves/archivosAlmacenamiento/empleadosPanaderos.ser", empleadosPanaderos);
            //gestorPanadero.guardarDatos("archivosAlmacenamiento/empleadosPanaderos.ser", empleadosPanaderos);

            GestorVendedor gestorVendedor = new GestorVendedor();
            gestorVendedor.guardarDatos("src/main/java/backend/saves/archivosAlmacenamiento/empleadosCajeros.ser", empleadosCajeros);
            //gestorVendedor.guardarDatos("archivosAlmacenamiento/empleadosCajeros.ser", empleadosCajeros);

            GestorCliente gestorCliente = new GestorCliente();
            gestorCliente.guardarDatos("src/main/java/backend/saves/archivosAlmacenamiento/clientes.ser", clientes);
            //gestorCliente.guardarDatos("archivosAlmacenamiento/clientes.ser", clientes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatosHashMap() {
        try {
            GestorTablaProductos gestorTablaProductos = new GestorTablaProductos();
            gestorTablaProductos.guardarDatos("src/main/java/backend/saves/archivosAlmacenamiento/productosHashMap.ser", tablaLookUpProductos);
            //gestorTablaProductos.guardarDatos("archivosAlmacenamiento/productosHashMap.ser", tablaLookUpProductos);

            GestorTablaEmpleados gestorTablaEmpleados = new GestorTablaEmpleados();
            gestorTablaEmpleados.guardarDatos("src/main/java/backend/saves/archivosAlmacenamiento/empleadosHashMap.ser", tablaLookUpEmpleados);
            //gestorTablaEmpleados.guardarDatos("archivosAlmacenamiento/empleadosHashMap.ser", tablaLookUpEmpleados);

            GestorTablaClientes gestorTablaClientes = new GestorTablaClientes();
            gestorTablaClientes.guardarDatos("src/main/java/backend/saves/archivosAlmacenamiento/clientesHashMap.ser", tablaLookUpClientes);
            //gestorTablaClientes.guardarDatos("archivosAlmacenamiento/clientesHashMap.ser", tablaLookUpClientes);

            GestorTablaVentas gestorTablaVentas = new GestorTablaVentas();
            gestorTablaVentas.guardarDatos("src/main/java/backend/saves/archivosAlmacenamiento/ventasHashMap.ser", tablaLookUpVentas);
            //gestorTablaVentas.guardarDatos("archivosAlmacenamiento/ventasHashMap.ser", tablaLookUpVentas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodos para leer de archivos
    public static void cargarDatosArrayList() {
        // usamos los metodos set para evitar acceder directamente a los atributos
        try {
            GestorProducto gestorProducto = new GestorProducto();
            setInventario(gestorProducto.cargarDatos("src/main/java/backend/saves/archivosAlmacenamiento/productos.ser"));
            //setInventario(gestorProducto.cargarDatos("archivosAlmacenamiento/productos.ser"));

            GestorLimpieza gestorLimpieza = new GestorLimpieza();
            setEmpleadosLimpieza(gestorLimpieza.cargarDatos("src/main/java/backend/saves/archivosAlmacenamiento/empleadosLimpieza.ser"));
            //setEmpleadosLimpieza(gestorLimpieza.cargarDatos("archivosAlmacenamiento/empleadosLimpieza.ser"));

            GestorPanadero gestorPanadero = new GestorPanadero();
            setEmpleadosPanaderos(gestorPanadero.cargarDatos("src/main/java/backend/saves/archivosAlmacenamiento/empleadosPanaderos.ser"));
            //setEmpleadosPanaderos(gestorPanadero.cargarDatos("archivosAlmacenamiento/empleadosPanaderos.ser"));

            GestorVendedor gestorVendedor = new GestorVendedor();
            setEmpleadosCajeros(gestorVendedor.cargarDatos("src/main/java/backend/saves/archivosAlmacenamiento/empleadosCajeros.ser"));
            //setEmpleadosCajeros(gestorVendedor.cargarDatos("archivosAlmacenamiento/empleadosCajeros.ser"));

            GestorCliente gestorCliente = new GestorCliente();
            setClientes(gestorCliente.cargarDatos("src/main/java/backend/saves/archivosAlmacenamiento/clientes.ser"));
            //setClientes(gestorCliente.cargarDatos("archivosAlmacenamiento/clientes.ser"));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void cargarDatosHashMap() {
        try {
            GestorTablaProductos gestorTablaProductos = new GestorTablaProductos();
            setTablaLookUpProductos(gestorTablaProductos.cargarDatos("src/main/java/backend/saves/archivosAlmacenamiento/productosHashMap.ser"));
            //setTablaLookUpProductos(gestorTablaProductos.cargarDatos("archivosAlmacenamiento/productosHashMap.ser"));

            GestorTablaEmpleados gestorTablaEmpleados = new GestorTablaEmpleados();
            setTablaLookUpEmpleados(gestorTablaEmpleados.cargarDatos("src/main/java/backend/saves/archivosAlmacenamiento/empleadosHashMap.ser"));
            //setTablaLookUpEmpleados(gestorTablaEmpleados.cargarDatos("archivosAlmacenamiento/empleadosHashMap.ser"));

            GestorTablaClientes gestorTablaClientes = new GestorTablaClientes();
            setTablaLookUpClientes(gestorTablaClientes.cargarDatos("src/main/java/backend/saves/archivosAlmacenamiento/clientesHashMap.ser"));
            //setTablaLookUpClientes(gestorTablaClientes.cargarDatos("archivosAlmacenamiento/clientesHashMap.ser"));

            GestorTablaVentas gestorTablaVentas = new GestorTablaVentas();
            setTablaLookUpVentas(gestorTablaVentas.cargarDatos("src/main/java/backend/saves/archivosAlmacenamiento/ventasHashMap.ser"));
            //setTablaLookUpVentas(gestorTablaVentas.cargarDatos("archivosAlmacenamiento/ventasHashMap.ser"));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    // objetos predefinidos de prueba
    public static void cargarElementosTEST()
    {
    	Producto pan = new Producto(1, "Donas bimbo", 23.00, 15);
        Producto pastel = new Producto(2, "Agua ciel 600ml", 15.00, 20);
        Producto sabritas = new Producto(3, "Sabritas", 22.50, 18);
        
        Cliente cliente = new Cliente(1, "Carlos", "Pérez", "123456789", 10.5);

        // Crear objeto de prueba para Empleado
        Vendedor empleado = new Vendedor(1, "Juan", "López", 30, 10.00, 0.05,Turno.MATUTINO);

        // Crear objeto de prueba para Limpieza
        Limpieza limpieza = new Limpieza(2, "Ana", "Gómez", 25, 8.00, Turno.VESPERTINO);

        // Crear objeto de prueba para Panadero
        Panadero panadero = new Panadero(3, "Pedro", "Martínez", 35, 12.00, Turno.MATUTINO);
        
        Vendedor vendedor = new Vendedor(4, "Lucía", "Fernández", 28, 9.00, 0.10, Turno.MATUTINO);
        
        inventario.add(pastel);
        inventario.add(pan);
        inventario.add(sabritas);
        
        tablaLookUpProductos.put(sabritas.getId(), sabritas);
        tablaLookUpProductos.put(pan.getId(), pan);
        tablaLookUpProductos.put(pastel.getId(), pastel);
        
        clientes.add(cliente);
        tablaLookUpClientes.put(cliente.getId(), cliente);
        
        empleadosLimpieza.add(limpieza);
        tablaLookUpEmpleados.put(limpieza.getId(), limpieza);
        
        empleadosCajeros.add(vendedor);
        empleadosCajeros.add(empleado);
        tablaLookUpEmpleados.put(vendedor.getId(), vendedor);
        tablaLookUpEmpleados.put(empleado.getId(), empleado);
        
        empleadosPanaderos.add(panadero);
        tablaLookUpEmpleados.put(panadero.getId(), panadero);
        
    }
    
}










