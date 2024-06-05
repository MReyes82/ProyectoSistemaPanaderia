package backend.saves.archivosClases;

import backend.modelos.Producto;
import java.io.*;
import java.util.HashMap;

public class GestorTablaProductos {

    // Método para guardar datos usando OutputStream
    public void guardarDatos(OutputStream outputStream, HashMap<Integer, Producto> inventario) throws IOException {
        try (ObjectOutputStream objetoOut = new ObjectOutputStream(outputStream)) {
            objetoOut.writeObject(inventario);
        }
    }

    // Método para cargar datos usando InputStream
    public HashMap<Integer, Producto> cargarDatos(InputStream inputStream) throws IOException, ClassNotFoundException {
        HashMap<Integer, Producto> inventario = null;
        try (ObjectInputStream objetoIn = new ObjectInputStream(inputStream)) {
            inventario = (HashMap<Integer, Producto>) objetoIn.readObject();
        }
        return inventario;
    }

    // Métodos anteriores que usan rutas de archivos (opcional)
    public void guardarDatos(String ruta, HashMap<Integer, Producto> inventario) throws IOException {
        try (FileOutputStream archivoOut = new FileOutputStream(ruta);
             ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut)) {
            objetoOut.writeObject(inventario);
        }
    }

    public HashMap<Integer, Producto> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        HashMap<Integer, Producto> inventario = null;
        try (FileInputStream archivoIn = new FileInputStream(ruta);
             ObjectInputStream objetoIn = new ObjectInputStream(archivoIn)) {
            inventario = (HashMap<Integer, Producto>) objetoIn.readObject();
        }
        return inventario;
    }
}
