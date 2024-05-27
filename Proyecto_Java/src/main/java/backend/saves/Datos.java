package backend.saves;
import backend.modelos.Cliente;
import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.*;

import java.util.ArrayList;
// en este paquete se incluyen los archivos para persistencia de datos y la clase control

public class Datos // Clase control para el manejo de datos
{
    // lista de productos en el inventario
    public ArrayList<Producto> inventario;
    // listas de empleados registrados
    public ArrayList<Limpieza> empleadosLimpieza;
    public ArrayList<Panadero> empleadosPanaderos;
    public ArrayList<Vendedor> empleadosCajeros;

    // listas de clientes registrados
    public ArrayList<Cliente> clientes;

    // inicializar las listas
    public static void inicializarDatos(Datos datos)
    {
        datos.inventario = new ArrayList<Producto>();
        datos.empleadosLimpieza = new ArrayList<Limpieza>();
        datos.empleadosPanaderos = new ArrayList<Panadero>();
        datos.empleadosCajeros = new ArrayList<Vendedor>();
        datos.clientes = new ArrayList<Cliente>();
    }


}
