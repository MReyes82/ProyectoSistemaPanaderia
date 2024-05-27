package backend.servicios;
import backend.modelos.Producto;

import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Producto> productos;

    public Inventario()
    {
        productos = new ArrayList<Producto>();
    }

    public Inventario(ArrayList<Producto> productos)
    {
        this.productos = productos;
    }

    public void agregarProducto(Producto producto)
    {
        productos.add(producto);
    }

    public void setProductos(ArrayList<Producto> productos)
    {
        this.productos = productos;
    }

   public ArrayList<Producto> getProductos()
   {
       return productos;
   }
}
