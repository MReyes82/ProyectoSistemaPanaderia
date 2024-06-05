package backend.saves.archivosClases;

import backend.modelos.Producto;
import java.io.*;
import java.util.ArrayList;

public class GestorProducto {

    // Método para guardar datos usando OutputStream
    public void guardarDatos(OutputStream outputStream, ArrayList<Producto> inventario) throws IOException {
        try (ObjectOutputStream objetoOut = new ObjectOutputStream(outputStream)) {
            objetoOut.writeObject(inventario);
        }
    }

    // Método para cargar datos usando InputStream
    public ArrayList<Producto> cargarDatos(InputStream inputStream) throws IOException, ClassNotFoundException {
        ArrayList<Producto> inventario = null;
        try (ObjectInputStream objetoIn = new ObjectInputStream(inputStream)) {
            inventario = (ArrayList<Producto>) objetoIn.readObject();
        }
        return inventario;
    }

    // Métodos anteriores que usan rutas de archivos (opcional)
    public void guardarDatos(String ruta, ArrayList<Producto> inventario) throws IOException {
        try (FileOutputStream archivoOut = new FileOutputStream(ruta);
             ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut)) {
            objetoOut.writeObject(inventario);
        }
    }

    public ArrayList<Producto> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        ArrayList<Producto> inventario = null;
        try (FileInputStream archivoIn = new FileInputStream(ruta);
             ObjectInputStream objetoIn = new ObjectInputStream(archivoIn)) {
            inventario = (ArrayList<Producto>) objetoIn.readObject();
        }
        return inventario;
    }
}
