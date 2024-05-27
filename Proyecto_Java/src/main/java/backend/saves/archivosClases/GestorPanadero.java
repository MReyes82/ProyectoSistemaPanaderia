package backend.saves.archivosClases;

import backend.modelos.herenciaEmpleados.*;
import java.io.*;
import java.util.ArrayList;

public class GestorPanadero
{
    public void guardarDatos(String ruta, ArrayList<Panadero> empleadosPanaderos) throws IOException
    {
        try {
            FileOutputStream archivoOut = new FileOutputStream(ruta);
            ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut);

            objetoOut.writeObject(empleadosPanaderos);
            objetoOut.close();
            archivoOut.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public ArrayList<Panadero> cargarDatos(String ruta) throws IOException, ClassNotFoundException
    {
        ArrayList<Panadero> empleadosPanaderos = null;

        try {
            FileInputStream archivoIn = new FileInputStream(ruta);
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);

            empleadosPanaderos = (ArrayList<Panadero>) objetoIn.readObject();
            objetoIn.close();
            archivoIn.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Clase no encontrada");
            c.printStackTrace();
        }

        return empleadosPanaderos;
    }
}
