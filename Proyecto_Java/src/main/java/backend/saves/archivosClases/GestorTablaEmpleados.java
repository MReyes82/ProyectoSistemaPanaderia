package backend.saves.archivosClases;

import backend.modelos.herenciaEmpleados.Empleado;
import java.io.*;
import java.util.HashMap;

public class GestorTablaEmpleados
{
    public void guardarDatos(String ruta, HashMap<Integer, Empleado> empleados) throws IOException {
        try {
            FileOutputStream archivoOut = new FileOutputStream(ruta);
            ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut);

            objetoOut.writeObject(empleados);
            objetoOut.close();
            archivoOut.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public HashMap<Integer, Empleado> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        HashMap<Integer, Empleado> empleados = null;

        try {
            FileInputStream archivoIn = new FileInputStream(ruta);
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);

            empleados = (HashMap<Integer, Empleado>) objetoIn.readObject();
            objetoIn.close();
            archivoIn.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Clase no encontrada");
            c.printStackTrace();
        }

        return empleados;
    }

}
