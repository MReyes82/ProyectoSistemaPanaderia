package backend.saves.archivosClases;

import backend.servicios.Venta;
import java.io.*;
import java.util.HashMap;

public class GestorTablaVentas
{
    public void guardarDatos(String ruta, HashMap<Integer, Venta> ventas) throws IOException {
        try {
            FileOutputStream archivoOut = new FileOutputStream(ruta);
            ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut);

            objetoOut.writeObject(ventas);
            objetoOut.close();
            archivoOut.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public HashMap<Integer, Venta> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        HashMap<Integer, Venta> ventas = null;

        try {
            FileInputStream archivoIn = new FileInputStream(ruta);
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);

            ventas = (HashMap<Integer, Venta>) objetoIn.readObject();
            objetoIn.close();
            archivoIn.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Clase no encontrada");
            c.printStackTrace();
        }

        return ventas;
    }
}
