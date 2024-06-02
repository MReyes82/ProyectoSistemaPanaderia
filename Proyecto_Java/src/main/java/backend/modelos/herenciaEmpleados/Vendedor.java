package backend.modelos.herenciaEmpleados;

import backend.servicios.Venta;
import java.util.ArrayList;

public class Vendedor extends Empleado
{
    private ArrayList<Venta> ventasRealizadas;

    public Vendedor() {
        super();
        this.ventasRealizadas = new ArrayList<Venta>();
    }

    public Vendedor(
        int id,
        String nombre,
        String apellido,
        int edad,
        double salario,
        Turno turno
    ){
        super(id, nombre, apellido, edad, salario, turno);
        this.ventasRealizadas = new ArrayList<Venta>();
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
