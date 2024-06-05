package backend.saves.archivosClases;

import backend.modelos.Cliente;
import java.io.*;
import java.util.ArrayList;

public class GestorCliente {

    // Método para guardar datos usando OutputStream
    public void guardarDatos(OutputStream outputStream, ArrayList<Cliente> clientes) throws IOException {
        try (ObjectOutputStream objetoOut = new ObjectOutputStream(outputStream)) {
            objetoOut.writeObject(clientes);
        }
    }

    // Método para cargar datos usando InputStream
    public ArrayList<Cliente> cargarDatos(InputStream inputStream) throws IOException, ClassNotFoundException {
        ArrayList<Cliente> clientes = null;
        try (ObjectInputStream objetoIn = new ObjectInputStream(inputStream)) {
            clientes = (ArrayList<Cliente>) objetoIn.readObject();
        }
        return clientes;
    }

    // Métodos anteriores que usan rutas de archivos (opcional)
    public void guardarDatos(String ruta, ArrayList<Cliente> clientes) throws IOException {
        try (FileOutputStream archivoOut = new FileOutputStream(ruta);
             ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut)) {
            objetoOut.writeObject(clientes);
        }
    }

    public ArrayList<Cliente> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        ArrayList<Cliente> clientes = null;
        try (FileInputStream archivoIn = new FileInputStream(ruta);
             ObjectInputStream objetoIn = new ObjectInputStream(archivoIn)) {
            clientes = (ArrayList<Cliente>) objetoIn.readObject();
        }
        return clientes;
    }
}
