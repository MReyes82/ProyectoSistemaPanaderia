package backend.saves.archivosClases;

import backend.servicios.Venta;
import java.io.*;
import java.util.HashMap;

public class GestorTablaVentas {

    // Método para guardar datos usando OutputStream
    public void guardarDatos(OutputStream outputStream, HashMap<Integer, Venta> ventas) throws IOException {
        try (ObjectOutputStream objetoOut = new ObjectOutputStream(outputStream)) {
            objetoOut.writeObject(ventas);
        }
    }

    // Método para cargar datos usando InputStream
    public HashMap<Integer, Venta> cargarDatos(InputStream inputStream) throws IOException, ClassNotFoundException {
        HashMap<Integer, Venta> ventas = null;
        try (ObjectInputStream objetoIn = new ObjectInputStream(inputStream)) {
            ventas = (HashMap<Integer, Venta>) objetoIn.readObject();
        }
        return ventas;
    }

    // Métodos anteriores que usan rutas de archivos (opcional)
    public void guardarDatos(String ruta, HashMap<Integer, Venta> ventas) throws IOException {
        try (FileOutputStream archivoOut = new FileOutputStream(ruta);
             ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut)) {
            objetoOut.writeObject(ventas);
        }
    }

    public HashMap<Integer, Venta> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        HashMap<Integer, Venta> ventas = null;
        try (FileInputStream archivoIn = new FileInputStream(ruta);
             ObjectInputStream objetoIn = new ObjectInputStream(archivoIn)) {
            ventas = (HashMap<Integer, Venta>) objetoIn.readObject();
        }
        return ventas;
    }
}
