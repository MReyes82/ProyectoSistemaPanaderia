package backend.saves;

import backend.modelos.Cliente;
import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.*;
import backend.servicios.Venta;
import backend.saves.archivosClases.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Datos {

    // listas y tablas de datos
    public static ArrayList<Producto> inventario = new ArrayList<>();
    public static ArrayList<Limpieza> empleadosLimpieza = new ArrayList<>();
    public static ArrayList<Panadero> empleadosPanaderos = new ArrayList<>();
    public static ArrayList<Vendedor> empleadosCajeros = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static HashMap<Integer, Empleado> tablaLookUpEmpleados = new HashMap<>();
    public static HashMap<Integer, Producto> tablaLookUpProductos = new HashMap<>();
    public static HashMap<Integer, Cliente> tablaLookUpClientes = new HashMap<>();
    public static HashMap<Integer, Venta> tablaLookUpVentas = new HashMap<>();

    // métodos para escribir datos
    public static void guardarDatos(OutputStream outputStream, Object data) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(outputStream)) {
            out.writeObject(data);
        }
    }

    // métodos para leer datos
    public static <T> T cargarDatos(InputStream inputStream) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(inputStream)) {
            return (T) in.readObject();
        }
    }

    // métodos para guardar ArrayLists en archivos
    public static void guardarDatosArrayList() {
        try {
            try (OutputStream outputStream = new FileOutputStream("src/main/resources/archivosSerializados/productos.ser")) {
                guardarDatos(outputStream, inventario);
            }
            try (OutputStream outputStream = new FileOutputStream("src/main/resources/archivosSerializados/empleadosLimpieza.ser")) {
                guardarDatos(outputStream, empleadosLimpieza);
            }
            try (OutputStream outputStream = new FileOutputStream("src/main/resources/archivosSerializados/empleadosPanaderos.ser")) {
                guardarDatos(outputStream, empleadosPanaderos);
            }
            try (OutputStream outputStream = new FileOutputStream("src/main/resources/archivosSerializados/empleadosCajeros.ser")) {
                guardarDatos(outputStream, empleadosCajeros);
            }
            try (OutputStream outputStream = new FileOutputStream("src/main/resources/archivosSerializados/clientes.ser")) {
                guardarDatos(outputStream, clientes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatosHashMap() {
        try {
            try (OutputStream outputStream = new FileOutputStream("src/main/resources/archivosSerializados/productosHashMap.ser")) {
                guardarDatos(outputStream, tablaLookUpProductos);
            }
            try (OutputStream outputStream = new FileOutputStream("src/main/resources/archivosSerializados/empleadosHashMap.ser")) {
                guardarDatos(outputStream, tablaLookUpEmpleados);
            }
            try (OutputStream outputStream = new FileOutputStream("src/main/resources/archivosSerializados/clientesHashMap.ser")) {
                guardarDatos(outputStream, tablaLookUpClientes);
            }
            try (OutputStream outputStream = new FileOutputStream("src/main/resources/archivosSerializados/ventasHashMap.ser")) {
                guardarDatos(outputStream, tablaLookUpVentas);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // métodos para cargar ArrayLists desde archivos
    public static void cargarDatosArrayList(ClassLoader classLoader) {
        try {
            try (InputStream inputStream = classLoader.getResourceAsStream("archivosSerializados/productos.ser")) {
                setInventario(cargarDatos(inputStream));
            }
            try (InputStream inputStream = classLoader.getResourceAsStream("archivosSerializados/empleadosLimpieza.ser")) {
                setEmpleadosLimpieza(cargarDatos(inputStream));
            }
            try (InputStream inputStream = classLoader.getResourceAsStream("archivosSerializados/empleadosPanaderos.ser")) {
                setEmpleadosPanaderos(cargarDatos(inputStream));
            }
            try (InputStream inputStream = classLoader.getResourceAsStream("archivosSerializados/empleadosCajeros.ser")) {
                setEmpleadosCajeros(cargarDatos(inputStream));
            }
            try (InputStream inputStream = classLoader.getResourceAsStream("archivosSerializados/clientes.ser")) {
                setClientes(cargarDatos(inputStream));
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void cargarDatosHashMap(ClassLoader classLoader) {
        try {
            try (InputStream inputStream = classLoader.getResourceAsStream("archivosSerializados/productosHashMap.ser")) {
                setTablaLookUpProductos(cargarDatos(inputStream));
            }
            try (InputStream inputStream = classLoader.getResourceAsStream("archivosSerializados/empleadosHashMap.ser")) {
                setTablaLookUpEmpleados(cargarDatos(inputStream));
            }
            try (InputStream inputStream = classLoader.getResourceAsStream("archivosSerializados/clientesHashMap.ser")) {
                setTablaLookUpClientes(cargarDatos(inputStream));
            }
            try (InputStream inputStream = classLoader.getResourceAsStream("archivosSerializados/ventasHashMap.ser")) {
                setTablaLookUpVentas(cargarDatos(inputStream));
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // inicializar las listas
    public static void inicializarDatos() {
        inventario = new ArrayList<>();
        empleadosLimpieza = new ArrayList<>();
        empleadosPanaderos = new ArrayList<>();
        empleadosCajeros = new ArrayList<>();
        clientes = new ArrayList<>();
        tablaLookUpEmpleados = new HashMap<>();
        tablaLookUpProductos = new HashMap<>();
        tablaLookUpClientes = new HashMap<>();
        tablaLookUpVentas = new HashMap<>();
    }

    // getters y setters

    public static ArrayList<Producto> getInventario() {
        return inventario;
    }

    public static void setInventario(ArrayList<Producto> inventario) {
        Datos.inventario = inventario;
    }

    public static ArrayList<Limpieza> getEmpleadosLimpieza() {
        return empleadosLimpieza;
    }

    public static void setEmpleadosLimpieza(ArrayList<Limpieza> empleadosLimpieza) {
        Datos.empleadosLimpieza = empleadosLimpieza;
    }

    public static ArrayList<Panadero> getEmpleadosPanaderos() {
        return empleadosPanaderos;
    }

    public static void setEmpleadosPanaderos(ArrayList<Panadero> empleadosPanaderos) {
        Datos.empleadosPanaderos = empleadosPanaderos;
    }

    public static ArrayList<Vendedor> getEmpleadosCajeros() {
        return empleadosCajeros;
    }

    public static void setEmpleadosCajeros(ArrayList<Vendedor> empleadosCajeros) {
        Datos.empleadosCajeros = empleadosCajeros;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Datos.clientes = clientes;
    }

    public static HashMap<Integer, Empleado> getTablaLookUpEmpleados() {
        return tablaLookUpEmpleados;
    }

    public static void setTablaLookUpEmpleados(HashMap<Integer, Empleado> tablaLookUpEmpleados) {
        Datos.tablaLookUpEmpleados = tablaLookUpEmpleados;
    }

    public static HashMap<Integer, Producto> getTablaLookUpProductos() {
        return tablaLookUpProductos;
    }

    public static void setTablaLookUpProductos(HashMap<Integer, Producto> tablaLookUpProductos) {
        Datos.tablaLookUpProductos = tablaLookUpProductos;
    }

    public static HashMap<Integer, Cliente> getTablaLookUpClientes() {
        return tablaLookUpClientes;
    }

    public static void setTablaLookUpClientes(HashMap<Integer, Cliente> tablaLookUpClientes) {
        Datos.tablaLookUpClientes = tablaLookUpClientes;
    }

    public static HashMap<Integer, Venta> getTablaLookUpVentas() {
        return tablaLookUpVentas;
    }

    public static void setTablaLookUpVentas(HashMap<Integer, Venta> tablaLookUpVentas) {
        Datos.tablaLookUpVentas = tablaLookUpVentas;
    }

    // objetos predefinidos de prueba
    public static void cargarElementosTEST() {
        Producto pan = new Producto(1, "Donas bimbo", 23.00, 15);
        Producto pastel = new Producto(2, "Agua ciel 600ml", 15.00, 20);
        Producto sabritas = new Producto(3, "Sabritas", 22.50, 18);

        Cliente cliente = new Cliente(1, "Carlos", "Pérez", "123456789", 10.5);
        Cliente cliente1 = new Cliente(2, "María", "González", "987654321", 5.0);
        Cliente cliente2 = new Cliente(3, "José", "Hernández", "123456789", 15.0);

        // Crear objeto de prueba para Empleado
        Vendedor empleado = new Vendedor(1, "Juan", "López", 30, 10.00, 0.05, Turno.MATUTINO);

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
        clientes.add(cliente1);
        clientes.add(cliente2);
        tablaLookUpClientes.put(cliente.getId(), cliente);
        tablaLookUpClientes.put(cliente1.getId(), cliente1);
        tablaLookUpClientes.put(cliente2.getId(), cliente2);

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
