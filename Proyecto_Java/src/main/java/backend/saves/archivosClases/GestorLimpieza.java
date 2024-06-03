package backend.saves.archivosClases;

import backend.modelos.herenciaEmpleados.Limpieza;
import java.io.*;
import java.util.ArrayList;

public class GestorLimpieza {

    // Método para guardar datos usando OutputStream
    public void guardarDatos(OutputStream outputStream, ArrayList<Limpieza> empleadosLimpieza) throws IOException {
        try (ObjectOutputStream objetoOut = new ObjectOutputStream(outputStream)) {
            objetoOut.writeObject(empleadosLimpieza);
        }
    }

    // Método para cargar datos usando InputStream
    public ArrayList<Limpieza> cargarDatos(InputStream inputStream) throws IOException, ClassNotFoundException {
        ArrayList<Limpieza> empleadosLimpieza = null;
        try (ObjectInputStream objetoIn = new ObjectInputStream(inputStream)) {
            empleadosLimpieza = (ArrayList<Limpieza>) objetoIn.readObject();
        }
        return empleadosLimpieza;
    }

    // Métodos anteriores que usan rutas de archivos (opcional)
    public void guardarDatos(String ruta, ArrayList<Limpieza> empleadosLimpieza) throws IOException {
        try (FileOutputStream archivoOut = new FileOutputStream(ruta);
             ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut)) {
            objetoOut.writeObject(empleadosLimpieza);
        }
    }

    public ArrayList<Limpieza> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        ArrayList<Limpieza> empleadosLimpieza = null;
        try (FileInputStream archivoIn = new FileInputStream(ruta);
             ObjectInputStream objetoIn = new ObjectInputStream(archivoIn)) {
            empleadosLimpieza = (ArrayList<Limpieza>) objetoIn.readObject();
        }
        return empleadosLimpieza;
    }
}
