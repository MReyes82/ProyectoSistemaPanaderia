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
        Datos.inicializarDatos();
        iniciarModulosInfo();

        
        Login comienzoDelPrograma = new Login();
        comienzoDelPrograma.iniciarFrontEnd();
        

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
