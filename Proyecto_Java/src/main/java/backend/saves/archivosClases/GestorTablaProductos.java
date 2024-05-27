package backend.saves.archivosClases;

import backend.modelos.Producto;
import java.io.*;
import java.util.HashMap;

public class GestorTablaProductos
{
    public void guardarDatos(String ruta, HashMap<Integer, Producto> inventario) throws IOException {
        try {
            FileOutputStream archivoOut = new FileOutputStream(ruta);
            ObjectOutputStream objetoOut = new ObjectOutputStream(archivoOut);

            objetoOut.writeObject(inventario);
            objetoOut.close();
            archivoOut.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public HashMap<Integer, Producto> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        HashMap<Integer, Producto> inventario = null;

        try {
            FileInputStream archivoIn = new FileInputStream(ruta);
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);

            inventario = (HashMap<Integer, Producto>) objetoIn.readObject();
            objetoIn.close();
            archivoIn.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Clase no encontrada");
            c.printStackTrace();
        }

        return inventario;
    }
}
