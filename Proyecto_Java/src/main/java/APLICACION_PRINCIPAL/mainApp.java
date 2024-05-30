package APLICACION_PRINCIPAL;

import backend.saves.*;
import backend.saves.Datos;
import backend.servicios.*;
import backend.modelos.*;
import backend.saves.*;
import backend.saves.archivosAlmacenamiento.*;
import backend.saves.archivosClases.*;


import frontend.*;

import java.io.File;
import java.util.ArrayList;


//import java.util.random.*;


public class mainApp
{
    public static void main (String[] args)
    {
        //System.out.println("Test");
        //System.out.println(new File(".").getAbsolutePath());

        Datos.inicializarDatos();
        //Datos.cargarElementosTEST();
        iniciarModulosInfo();

        //Producto producto1 = new Producto(1, "Sabritas", 55, 60);

        //ArrayList<Producto> inventario = Datos.getInventario();
        

        //ModelosApp model = new ModelosApp();
        //Serviciosapp servicios = new Serviciosapp();
        
        Login comienzoDelPrograma = new Login();
        comienzoDelPrograma.iniciarFrontEnd();
        
        
        
        //cargarDatos();
        //TODO: incorporar una tecnica de manejo de evetos para evitar que se cargue a los archivos inmediatamente

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
