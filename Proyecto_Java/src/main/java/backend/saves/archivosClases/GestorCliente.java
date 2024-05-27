package backend.saves.archivosClases;

import backend.modelos.Cliente;
import java.io.*;
import java.util.ArrayList;

public class GestorCliente
{
    public void guardarDatos(String ruta, ArrayList<Cliente> clientes) throws IOException {
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

    public ArrayList<Cliente> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        ArrayList<Cliente> clientes = null;

        try {
            FileInputStream archivoIn = new FileInputStream(ruta);
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);

            clientes = (ArrayList<Cliente>) objetoIn.readObject();
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
