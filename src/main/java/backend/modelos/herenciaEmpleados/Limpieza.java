package backend.modelos.herenciaEmpleados;

public class Limpieza extends Empleado
{
    // public String areaDesignada;
    public Limpieza() {
        super();
    }

    public Limpieza(
        int id,
        String nombre,
        String apellido,
        int edad,
        double salario,
        Turno turno
    ){
        super(id, nombre, apellido, edad, salario, turno);
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.turno;
    }
}
