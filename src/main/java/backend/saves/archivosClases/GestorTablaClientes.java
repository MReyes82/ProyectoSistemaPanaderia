package backend.saves.archivosClases;

import backend.modelos.Cliente;
import java.io.*;
import java.util.HashMap;

public class GestorTablaClientes {

    // Método para guardar datos usando OutputStream
    public void guardarDatos(OutputStream outputStream, HashMap<Integer, Cliente> clientes) throws IOException {
        try (ObjectOutputStream objetoOut = new ObjectOutputStream(outputStream)) {
            objetoOut.writeObject(clientes);
        }
    }

    // Método para cargar datos usando InputStream
    public HashMap<Integer, Cliente> cargarDatos(InputStream inputStream) throws IOException, ClassNotFoundException {
        HashMap<Integer, Cliente> clientes = null;
        try (ObjectInputStream objetoIn = new ObjectInputStream(inputStream)) {
            clientes = (HashMap<Integer, Cliente>) objetoIn.readObject();
        }
        return clientes;
    }

    // Métodos anteriores que usan rutas de archivos (opcional)
    public void guardarDatos(String ruta, HashMap<Integer, Cliente> clientes) throws IOException {
        try (FileOutputStream archivoOut = new FileOutputStream(ruta);
             ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut)) {
            objetoOut.writeObject(clientes);
        }
    }

    public HashMap<Integer, Cliente> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        HashMap<Integer, Cliente> clientes = null;
        try (FileInputStream archivoIn = new FileInputStream(ruta);
             ObjectInputStream objetoIn = new ObjectInputStream(archivoIn)) {
            clientes = (HashMap<Integer, Cliente>) objetoIn.readObject();
        }
        return clientes;
    }
}
