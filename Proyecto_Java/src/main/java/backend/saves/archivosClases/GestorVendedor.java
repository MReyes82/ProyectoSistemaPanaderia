package backend.saves.archivosClases;

import backend.modelos.herenciaEmpleados.Vendedor;
import java.io.*;
import java.util.ArrayList;

public class GestorVendedor
{
    public void guardarDatos(String ruta, ArrayList<Vendedor> empleadosCajeros) throws IOException
    {
        try {
            FileOutputStream archivoOut = new FileOutputStream(ruta);
            ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut);

            objetoOut.writeObject(empleadosCajeros);
            objetoOut.close();
            archivoOut.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public ArrayList<Vendedor> cargarDatos(String ruta) throws IOException, ClassNotFoundException
    {
        ArrayList<Vendedor> empleadosCajeros = null;

        try {
            FileInputStream archivoIn = new FileInputStream(ruta);
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);

            empleadosCajeros = (ArrayList<Vendedor>) objetoIn.readObject();
            objetoIn.close();
            archivoIn.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Clase no encontrada");
            c.printStackTrace();
        }

        return empleadosCajeros;
    }
}
