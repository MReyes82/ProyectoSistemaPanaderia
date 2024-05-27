package backend.saves.archivosClases;

import backend.modelos.herenciaEmpleados.Limpieza;
import java.io.*;
import java.util.ArrayList;

public class GestorLimpieza
{
    public void guardarDatos(String ruta, ArrayList<Limpieza> empleadosLimpieza) throws IOException {
        try {
            FileOutputStream archivoOut = new FileOutputStream(ruta);
            ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut);

            objetoOut.writeObject(empleadosLimpieza);
            objetoOut.close();
            archivoOut.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public ArrayList<Limpieza> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        ArrayList<Limpieza> empleadosLimpieza = null;

        try {
            FileInputStream archivoIn = new FileInputStream(ruta);
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);

            empleadosLimpieza = (ArrayList<Limpieza>) objetoIn.readObject();
            objetoIn.close();
            archivoIn.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Clase no encontrada");
            c.printStackTrace();
        }

        return empleadosLimpieza;
    }
}
