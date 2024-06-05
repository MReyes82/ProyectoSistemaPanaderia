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
    private int idACliente;
    //private ArrayList<Producto> productosAdquiridos;
    private double totalVenta;
    private int idAVendedor; // referenci al vendedor que realizo la venta

    public Venta()
    {
        this.id = -1;
        this.fecha = new Date();
        this.idACliente = -1;
        //this.productosAdquiridos = new ArrayList<Producto>();
        this.totalVenta = 0;
        this.idAVendedor = -1;
    }

    public Venta(
        int id,
        Date fecha,
        int idACliente,
        double totalVenta,
        int idAVendedor
    ){
        this.id = id;
        this.fecha = fecha;
        this.idACliente = idACliente;
        this.totalVenta = totalVenta;
        this.idAVendedor = idAVendedor;
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

    public int getIdACliente() {
		return idACliente;
	}

	public void setIdACliente(int idACliente) {
		this.idACliente = idACliente;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public void setTotalVente(double totalVenta)
    {
    	this.totalVenta = totalVenta;
    }
    
    public double getTotalVenta()
    {
    	return this.totalVenta;
    }

	public int getIdAVendedor() {
		return idAVendedor;
	}

	public void setIdAVendedor(int idAVendedor) {
		this.idAVendedor = idAVendedor;
	}
}
