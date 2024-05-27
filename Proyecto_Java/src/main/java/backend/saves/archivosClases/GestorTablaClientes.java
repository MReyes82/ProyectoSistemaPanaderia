package backend.saves.archivosClases;

import backend.modelos.Cliente;
import java.io.*;
import java.util.HashMap;

public class GestorTablaClientes
{
    public void guardarDatos(String ruta, HashMap<Integer, Cliente> clientes) throws IOException {
        try {
            FileOutputStream archivoOut = new FileOutputStream(ruta);
            ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut);

            objetoOut.writeObject(clientes);
            objetoOut.close();
            archivoOut.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public HashMap<Integer, Cliente> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        HashMap<Integer, Cliente> clientes = null;

        try {
            FileInputStream archivoIn = new FileInputStream(ruta);
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);

            clientes = (HashMap<Integer, Cliente>) objetoIn.readObject();
            objetoIn.close();
            archivoIn.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Clase no encontrada");
            c.printStackTrace();
        }

        return clientes;
    }
}
