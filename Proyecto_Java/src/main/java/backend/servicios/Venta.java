package backend.servicios;

import backend.modelos.Cliente;
import java.util.ArrayList;
import java.util.Date;
import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.Vendedor;

public class Venta
{
    private int id;
    private Date fecha;
    private Cliente cliente;

    private ArrayList<Producto> productosAdquiridos;
    private Vendedor identificadorVendedor; // referenci al vendedor que realizo la venta

    public Venta()
    {
        this.id = -1;
        this.fecha = new Date();
        this.cliente = new Cliente();
        this.productosAdquiridos = new ArrayList<Producto>();
        this.identificadorVendedor = new Vendedor();
    }

    public Venta(
        int id,
        Date fecha,
        Cliente cliente,
        ArrayList<Producto> productosAdquiridos,
        Vendedor identificadorVendedor
    ){
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.productosAdquiridos = productosAdquiridos;
        this.identificadorVendedor = identificadorVendedor;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductosAdquiridos() {
        return this.productosAdquiridos;
    }

    public void setProductosAdquiridos(ArrayList<Producto> productosAdquiridos) {
        this.productosAdquiridos = productosAdquiridos;
    }

    public Vendedor getIdentificadorVendedor() {
        return this.identificadorVendedor;
    }

    public void setIdentificadorVendedor(Vendedor identificadorVendedor) {
        this.identificadorVendedor = identificadorVendedor;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productosAdquiridos) {
            total += producto.getPrecio();
        }
        return total;
    }
}