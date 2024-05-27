package backend.modelos.herenciaEmpleados;

import backend.modelos.Producto;

import java.util.ArrayList;

public class Panadero extends Empleado
{
    ArrayList<Producto> especialidades;

    public Panadero() {
        super();
        this.especialidades = new ArrayList<Producto>();
    }

    public Panadero(
        int id,
        String nombre,
        String apellido,
        int edad,
        double salario,
        ArrayList<Producto> especialidades,
        Turno turno
    ){
        super(id, nombre, apellido, edad, salario, turno);
        this.especialidades = especialidades;
    }

    public ArrayList<Producto> getEspecialidades() {
        return this.especialidades;
    }

    public void agregarEspecialidad(Producto especialidad) {
        this.especialidades.add(especialidad);
    }

    public void setEspecialidades(ArrayList<Producto> especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.especialidades + " " + this.turno;
    }

}
