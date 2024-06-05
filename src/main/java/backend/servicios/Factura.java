package backend.servicios;

import backend.modelos.Cliente;

public class Factura
{
    private int id;
    private int referenciaCliente;
    private Venta referenciaVenta;
    private double total;

    public Factura()
    {
        this.id = -1;
        this.referenciaCliente = -1;
        this.referenciaVenta = new Venta();
        this.total = 0;
    }

    public Factura(
        int id,
        int referenciaCliente,
        Venta referenciaVenta,
        double total
    ){
        this.id = id;
        this.referenciaCliente = referenciaCliente;
        this.referenciaVenta = referenciaVenta;
        this.total = total;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReferenciaCliente() {
		return referenciaCliente;
	}

	public void setReferenciaCliente(int referenciaCliente) {
		this.referenciaCliente = referenciaCliente;
	}

	public Venta getReferenciaVenta() {
        return this.referenciaVenta;
    }

    public void setReferenciaVenta(Venta referenciaVenta) {
        this.referenciaVenta = referenciaVenta;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
