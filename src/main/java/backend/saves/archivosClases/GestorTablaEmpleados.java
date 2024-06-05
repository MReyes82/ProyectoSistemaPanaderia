package backend.saves.archivosClases;

import backend.modelos.herenciaEmpleados.Empleado;
import java.io.*;
import java.util.HashMap;

public class GestorTablaEmpleados {

    // Método para guardar datos usando OutputStream
    public void guardarDatos(OutputStream outputStream, HashMap<Integer, Empleado> empleados) throws IOException {
        try (ObjectOutputStream objetoOut = new ObjectOutputStream(outputStream)) {
            objetoOut.writeObject(empleados);
        }
    }

    // Método para cargar datos usando InputStream
    public HashMap<Integer, Empleado> cargarDatos(InputStream inputStream) throws IOException, ClassNotFoundException {
        HashMap<Integer, Empleado> empleados = null;
        try (ObjectInputStream objetoIn = new ObjectInputStream(inputStream)) {
            empleados = (HashMap<Integer, Empleado>) objetoIn.readObject();
        }
        return empleados;
    }

    // Métodos anteriores que usan rutas de archivos (opcional)
    public void guardarDatos(String ruta, HashMap<Integer, Empleado> empleados) throws IOException {
        try (FileOutputStream archivoOut = new FileOutputStream(ruta);
             ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut)) {
            objetoOut.writeObject(empleados);
        }
    }

    public HashMap<Integer, Empleado> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        HashMap<Integer, Empleado> empleados = null;
        try (FileInputStream archivoIn = new FileInputStream(ruta);
             ObjectInputStream objetoIn = new ObjectInputStream(archivoIn)) {
            empleados = (HashMap<Integer, Empleado>) objetoIn.readObject();
        }
        return empleados;
    }
}
