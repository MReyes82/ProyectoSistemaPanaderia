package backend.saves.archivosClases;

import backend.modelos.herenciaEmpleados.Panadero;
import java.io.*;
import java.util.ArrayList;

public class GestorPanadero {

    // Método para guardar datos usando OutputStream
    public void guardarDatos(OutputStream outputStream, ArrayList<Panadero> empleadosPanaderos) throws IOException {
        try (ObjectOutputStream objetoOut = new ObjectOutputStream(outputStream)) {
            objetoOut.writeObject(empleadosPanaderos);
        }
    }

    // Método para cargar datos usando InputStream
    public ArrayList<Panadero> cargarDatos(InputStream inputStream) throws IOException, ClassNotFoundException {
        ArrayList<Panadero> empleadosPanaderos = null;
        try (ObjectInputStream objetoIn = new ObjectInputStream(inputStream)) {
            empleadosPanaderos = (ArrayList<Panadero>) objetoIn.readObject();
        }
        return empleadosPanaderos;
    }

    // Métodos anteriores que usan rutas de archivos (opcional)
    public void guardarDatos(String ruta, ArrayList<Panadero> empleadosPanaderos) throws IOException {
        try (FileOutputStream archivoOut = new FileOutputStream(ruta);
             ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut)) {
            objetoOut.writeObject(empleadosPanaderos);
        }
    }

    public ArrayList<Panadero> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        ArrayList<Panadero> empleadosPanaderos = null;
        try (FileInputStream archivoIn = new FileInputStream(ruta);
             ObjectInputStream objetoIn = new ObjectInputStream(archivoIn)) {
            empleadosPanaderos = (ArrayList<Panadero>) objetoIn.readObject();
        }
        return empleadosPanaderos;
    }
}
