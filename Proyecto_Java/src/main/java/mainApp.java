import backend.modelos.herenciaEmpleados.*;
import backend.saves.Datos;
import backend.saves.archivosClases.*;
import backend.saves.archivosAlmacenamiento.*;
import backend.servicios.*;
import backend.modelos.*;
import backend.saves.Datos;
import static backend.modelos.herenciaEmpleados.Turno.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;


//import java.util.random.*;


public class mainApp
{
    public static void main (String[] args)
    {
        System.out.println("Test");

        Datos.inicializarDatos();

        iniciarModulosInfo();
        cargarDatos();

        ModelosApp model = new ModelosApp();
        Serviciosapp servicios = new Serviciosapp();
        
        /*
        Empleado found = model.buscarEmpleado(1);;
        
        if (found == null) {
        	System.out.println("Nulo");
        }else {
        	System.out.println(found.toString());
        }*/
        
        

        //model.agregarEmpleadoVendedor(1, "Juan", "Perez", 25, 65.60, 0.05, VESPERTINO);
        //model.agregarEmpleadoPanadero(2, "Pedro", "Lopez", 30, 70.60, MATUTINO);
        //model.agregarEmpleadoLimpieza(3, "Jose", "Garcia", 35, 75.60, VESPERTINO);

        //model.registrarCliente(1, "Maria", "Gonzalez", "6645165116");

        //model.registrarProducto(1, "Botella agua 600ml", 19.50, 100);
        //model.registrarProducto(2, "Conchas", 23.50, 50);
        //model.registrarProducto(3, "Pan de barra", 35.50, 30);
        //iniciarModulosInfo();

        return;
    }

    public static void iniciarModulosInfo()
    {
        System.out.println("BIENVENIDO, BREAD_STOREV1.0");
        System.out.println("INICIALIZANDO MODULOS DE INFORMACION");

        try {

            Datos.inicializarDatos(); // inicializamos los arraylist y hashmaps
            Datos.cargarDatosArrayList();
            Datos.cargarDatosHashMap();

        } catch (Exception e) {
            System.out.println("Archivos vacios, no se pudo cargar la informacion");
        }

        return;
    }

    public static void cargarDatos()
    {
        System.out.println("GUARDANDO DATOS");

        try {
            Datos.guardarDatosArrayList();
            Datos.guardarDatosHashMap();

        } catch (Exception e) {
            System.out.println("Archivos vacios, no se pudo cargar la informacion");
        }
        return;
    }
}
