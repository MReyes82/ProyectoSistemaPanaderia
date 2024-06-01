package APLICACION_PRINCIPAL;

import backend.saves.Datos;
import frontend.ventanasLogin.Login;

public class mainApp {
    public static void main(String[] args) {
        Datos.inicializarDatos();
        iniciarModulosInfo();

        Login comienzoDelPrograma = new Login();
        comienzoDelPrograma.iniciarFrontEnd();
    }

    public static void iniciarModulosInfo() {
        System.out.println("BIENVENIDO, BREAD_STOREV1.0");
        System.out.println("INICIALIZANDO MODULOS DE INFORMACION");

        try {
            Datos.inicializarDatos(); // inicializamos los arraylist y hashmaps
            ClassLoader classLoader = mainApp.class.getClassLoader();
            Datos.cargarDatosArrayList(classLoader);
            Datos.cargarDatosHashMap(classLoader);
        } catch (Exception e) {
            System.out.println("Archivos vacios, no se pudo cargar la informacion");
            e.printStackTrace();
        }
    }

    public static void cargarDatos(ClassLoader classLoader) {
        System.out.println("GUARDANDO DATOS");

        try {
            Datos.guardarDatosArrayList();
            Datos.guardarDatosHashMap();
        } catch (Exception e) {
            System.out.println("Archivos vacios, no se pudo guardar la informacion");
            e.printStackTrace();
        }
    }
}
