package backend.modelos.herenciaEmpleados;

import backend.modelos.Producto;

import java.util.ArrayList;

public class Panadero extends Empleado
{
    //public String especialidad;

    public Panadero() {
        super();
        //this.especialidades = new ArrayList<Producto>();
    }

    public Panadero(
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
