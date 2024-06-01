package backend.saves.archivosClases;

import backend.modelos.herenciaEmpleados.Vendedor;
import java.io.*;
import java.util.ArrayList;

public class GestorVendedor {

    // Método para guardar datos usando OutputStream
    public void guardarDatos(OutputStream outputStream, ArrayList<Vendedor> empleadosCajeros) throws IOException {
        try (ObjectOutputStream objetoOut = new ObjectOutputStream(outputStream)) {
            objetoOut.writeObject(empleadosCajeros);
        }
    }

    // Método para cargar datos usando InputStream
    public ArrayList<Vendedor> cargarDatos(InputStream inputStream) throws IOException, ClassNotFoundException {
        ArrayList<Vendedor> empleadosCajeros = null;
        try (ObjectInputStream objetoIn = new ObjectInputStream(inputStream)) {
            empleadosCajeros = (ArrayList<Vendedor>) objetoIn.readObject();
        }
        return empleadosCajeros;
    }

    // Métodos anteriores que usan rutas de archivos (opcional)
    public void guardarDatos(String ruta, ArrayList<Vendedor> empleadosCajeros) throws IOException {
        try (FileOutputStream archivoOut = new FileOutputStream(ruta);
             ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut)) {
            objetoOut.writeObject(empleadosCajeros);
        }
    }

    public ArrayList<Vendedor> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        ArrayList<Vendedor> empleadosCajeros = null;
        try (FileInputStream archivoIn = new FileInputStream(ruta);
             ObjectInputStream objetoIn = new ObjectInputStream(archivoIn)) {
            empleadosCajeros = (ArrayList<Vendedor>) objetoIn.readObject();
        }
        return empleadosCajeros;
    }
}
