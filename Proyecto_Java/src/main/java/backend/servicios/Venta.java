package backend.servicios;

import backend.modelos.Cliente;
import java.util.ArrayList;
import java.util.Date;
import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.Vendedor;
import java.io.Serializable;

public class Venta implements Serializable
{
    private int id;
    private Date fecha;
    private Cliente cliente;

    //private ArrayList<Producto> productosAdquiridos;
    private double totalVenta;
    private Vendedor identificadorVendedor; // referenci al vendedor que realizo la venta

    public Venta()
    {
        this.id = -1;
        this.fecha = new Date();
        this.cliente = new Cliente();
        //this.productosAdquiridos = new ArrayList<Producto>();
        this.totalVenta = 0;
        this.identificadorVendedor = new Vendedor();
    }

    public Venta(
        int id,
        Date fecha,
        Cliente cliente,
        //ArrayList<Producto> productosAdquiridos,
        double totalVenta,
        Vendedor identificadorVendedor
    ){
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        //this.productosAdquiridos = productosAdquiridos;
        this.totalVenta = totalVenta;
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

    public void setTotalVente(double totalVenta)
    {
    	this.totalVenta = totalVenta;
    }
    
    public double getTotalVenta()
    {
    	return this.totalVenta;
    }

    public Vendedor getIdentificadorVendedor() {
        return this.identificadorVendedor;
    }

    public void setIdentificadorVendedor(Vendedor identificadorVendedor) {
        this.identificadorVendedor = identificadorVendedor;
    }
}
