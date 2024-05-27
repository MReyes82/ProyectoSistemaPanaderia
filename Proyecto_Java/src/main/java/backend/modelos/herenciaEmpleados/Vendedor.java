package backend.modelos.herenciaEmpleados;

import backend.servicios.Venta;
import java.util.ArrayList;

public class Vendedor extends Empleado
{
    private double comision;
    private ArrayList<Venta> ventasRealizadas;

    public Vendedor() {
        super();
        this.comision = 0.0;
        this.ventasRealizadas = new ArrayList<Venta>();
    }

    public Vendedor(
        int id,
        String nombre,
        String apellido,
        int edad,
        double salario,
        double comision,
        ArrayList<Venta> ventasRealizadas,
        Turno turno
    ){
        super(id, nombre, apellido, edad, salario, turno);
        this.comision = comision;
        this.ventasRealizadas = ventasRealizadas;
    }

    public double getComision() {
        return this.comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public ArrayList<Venta> getVentasRealizadas() {
        return this.ventasRealizadas;
    }

    public void agregarVenta(Venta venta) {
        this.ventasRealizadas.add(venta);
    }

    public void setVentasRealizadas(ArrayList<Venta> ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }
}
