package backend.servicios;

import backend.modelos.Cliente;

public class Factura
{
    private int id;
    private Cliente referenciaCliente;
    private Venta referenciaVenta;
    private double total;

    public Factura()
    {
        this.id = -1;
        this.referenciaCliente = new Cliente();
        this.referenciaVenta = new Venta();
        this.total = 0;
    }

    public Factura(
        int id,
        Cliente refernciaCliente,
        Venta referenciaVenta,
        double total
    ){
        this.id = id;
        this.referenciaCliente = refernciaCliente;
        this.referenciaVenta = referenciaVenta;
        this.total = total;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getRefernciaCliente() {
        return this.referenciaCliente;
    }

    public void setRefernciaCliente(Cliente refernciaCliente) {
        this.referenciaCliente = refernciaCliente;
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
