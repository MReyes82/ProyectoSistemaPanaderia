package backend.saves.archivosClases;

import backend.modelos.Producto;
import java.io.*;
import java.util.ArrayList;

public class GestorProducto
{
    public void guardarDatos(String ruta, ArrayList<Producto> inventario) throws IOException {
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

    public ArrayList<Producto> cargarDatos(String ruta) throws IOException, ClassNotFoundException {
        ArrayList<Producto> inventario = null;

        try {
            FileInputStream archivoIn = new FileInputStream(ruta);
            ObjectInputStream objetoIn = new ObjectInputStream(archivoIn);

            inventario = (ArrayList<Producto>) objetoIn.readObject();
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
