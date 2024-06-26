package backend.modelos;

import backend.modelos.herenciaEmpleados.Empleado;
import backend.modelos.herenciaEmpleados.Limpieza;
import backend.modelos.herenciaEmpleados.Turno;
import backend.modelos.herenciaEmpleados.Vendedor;
import backend.modelos.herenciaEmpleados.Panadero;
import backend.saves.Datos;
import backend.servicios.Venta;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

/*
* Metodos relacionadas con funciones para gestion de empleados
*
* Todos los metodos asumen que los datos han sido validados previamente
* Las unicas validaciones realizadas son para verificar si el elemento a modificar o eliminar existe
 */

public class ModelosApp
{
    public ModelosApp()
    {
        // constructor
    }

    public void agregarEmpleadoVendedor(int id, String nombre, String apellido, int edad, double salario, Turno turno)
    {
        ArrayList<Vendedor> empleados = Datos.getEmpleadosCajeros();
        HashMap<Integer, Empleado> empleadosMap = Datos.getTablaLookUpEmpleados();

        Vendedor nuevoVendedor = new Vendedor(
            id,
            nombre,
            apellido,
            edad,
            salario,
            turno
        );

        empleados.add(nuevoVendedor);
        Datos.setEmpleadosCajeros(empleados);
        empleadosMap.put(id, nuevoVendedor);
        Datos.setTablaLookUpEmpleados(empleadosMap);


        System.out.println("Empleado vendedor agregado con exito");
        return;
    }

    public void agregarEmpleadoLimpieza(int id, String nombre, String apellido, int edad, double salario, Turno turno)
    {
        ArrayList<Limpieza> empleados = Datos.getEmpleadosLimpieza();
        HashMap<Integer, Empleado> empleadosMap = Datos.getTablaLookUpEmpleados();

        Limpieza nuevoLimpieza = new Limpieza(
            id,
            nombre,
            apellido,
            edad,
            salario,
            turno
        );

        empleados.add(nuevoLimpieza);
        Datos.setEmpleadosLimpieza(empleados);
        empleadosMap.put(id, nuevoLimpieza);
        Datos.setTablaLookUpEmpleados(empleadosMap);

        System.out.println("Empleado de limpieza agregado con exito");
        return;
    }

    public void agregarEmpleadoPanadero(int id, String nombre, String apellido, int edad, double salario, Turno turno)
    {
        ArrayList<Panadero> empleados = Datos.getEmpleadosPanaderos();
        HashMap<Integer, Empleado> empleadosMap = Datos.getTablaLookUpEmpleados();

        Panadero nuevoPanadero = new Panadero(
            id,
            nombre,
            apellido,
            edad,
            salario,
            turno
        );

        empleados.add(nuevoPanadero);
        Datos.setEmpleadosPanaderos(empleados);
        empleadosMap.put(id, nuevoPanadero);
        Datos.setTablaLookUpEmpleados(empleadosMap);

        System.out.println("Empleado panadero agregado con exito");
        return;
    }

    public Cliente buscarCliente(int id)
    {
        HashMap<Integer, Cliente> clientesMap = Datos.getTablaLookUpClientes();

        if (!clientesMap.containsKey(id))
        {
            return null;
        }

        return clientesMap.get(id);
    }

    public Producto buscarProducto(int id)
    {
        HashMap<Integer, Producto> productosMap = Datos.getTablaLookUpProductos();

        if (!productosMap.containsKey(id))
        {
            return null;
        }

        return productosMap.get(id);
    }

    public Empleado buscarEmpleado(int id)
    {
        HashMap<Integer, Empleado> empleadosMap = Datos.getTablaLookUpEmpleados();

        if (!empleadosMap.containsKey(id))
        {
            return null;
        }

        return empleadosMap.get(id);
    }

    public void eliminarEmpleado(int id)
    {
        HashMap<Integer, Empleado> empleadosMap = Datos.getTablaLookUpEmpleados();
        Empleado empleadoAEditar;

        try {
            empleadoAEditar = buscarEmpleado(id);

        } catch (Exception e) {
            System.out.println("Empleado no encontrado");
            return;
        }

        if (empleadoAEditar instanceof  Vendedor){
            ArrayList<Vendedor> empleados = Datos.getEmpleadosCajeros();
            empleados.remove(empleadoAEditar);
            Datos.setEmpleadosCajeros(empleados);

        }else if (empleadoAEditar instanceof  Limpieza){
            ArrayList<Limpieza> empleados = Datos.getEmpleadosLimpieza();
            empleados.remove(empleadoAEditar);
            Datos.setEmpleadosLimpieza(empleados);

        } else if (empleadoAEditar instanceof  Panadero){
            ArrayList<Panadero> empleados = Datos.getEmpleadosPanaderos();
            empleados.remove(empleadoAEditar);
            Datos.setEmpleadosPanaderos(empleados);
        }

        empleadosMap.remove(id);
        Datos.setTablaLookUpEmpleados(empleadosMap);

        System.out.println("Empleado eliminado con exito");

        return;
    }

    public void registrarCliente(int id, String nombre, String apellido, double puntos, String telefono)
    {
        ArrayList<Cliente> clientes = Datos.getClientes();
        HashMap<Integer, Cliente> tablaLookUpClientes = Datos.getTablaLookUpClientes();
        // REGRESA NULO?????

        Cliente nuevoCliente = new Cliente(
            id,
            nombre,
            apellido,
            telefono,
            puntos
        );

        clientes.add(nuevoCliente);
        Datos.setClientes(clientes);
        tablaLookUpClientes.put(id, nuevoCliente);
        Datos.setTablaLookUpClientes(tablaLookUpClientes);


        System.out.println("Cliente registrado con exito");

        return;
    }

    public void registrarProducto(int id, String nombre, double precio, int stock)
    {
        ArrayList<Producto> productos = Datos.getInventario();
        HashMap<Integer, Producto> tablaLookUpProductos = Datos.getTablaLookUpProductos();

        Producto nuevoProducto = new Producto(
            id,
            nombre,
            precio,
            stock
        );

        productos.add(nuevoProducto);
        Datos.setInventario(productos);

        tablaLookUpProductos.put(id, nuevoProducto);
        Datos.setTablaLookUpProductos(tablaLookUpProductos);

        System.out.println("Producto registrado con exito");

        return;
    }

    public void eliminarProducto(int id)
    {
        HashMap<Integer, Producto> tablaLookUpProductos = Datos.getTablaLookUpProductos();
        Producto productoAEditar;

        try {
            productoAEditar = tablaLookUpProductos.get(id);

        } catch (Exception e) {
            System.out.println("Producto no encontrado");
            return;
        }

        ArrayList<Producto> productos = Datos.getInventario();
        productos.remove(productoAEditar);
        Datos.setInventario(productos);

        tablaLookUpProductos.remove(id);
        Datos.setTablaLookUpProductos(tablaLookUpProductos);

        System.out.println("Producto eliminado con exito");

        return;
    }

    public void eliminarCliente(int id)
    {
        HashMap<Integer, Cliente> tablaLookUpClientes = Datos.getTablaLookUpClientes();
        Cliente clienteAEditar;

        try {
            clienteAEditar = tablaLookUpClientes.get(id);

        } catch (Exception e) {
            System.out.println("Cliente no encontrado");
            return;
        }

        ArrayList<Cliente> clientes = Datos.getClientes();
        clientes.remove(clienteAEditar);
        Datos.setClientes(clientes);

        tablaLookUpClientes.remove(id);
        Datos.setTablaLookUpClientes(tablaLookUpClientes);

        System.out.println("Cliente eliminado con exito");

        return;
    }
}
