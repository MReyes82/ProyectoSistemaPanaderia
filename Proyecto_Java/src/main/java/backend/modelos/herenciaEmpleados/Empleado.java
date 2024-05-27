package backend.modelos.herenciaEmpleados;

import java.io.Serializable;

public class Empleado implements Serializable
{
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private double salario; // salario por hora
    Turno turno;

    public Empleado() {
        this.id = -1;
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.salario = 0.0;
        this.turno = Turno.MATUTINO; // default value
    }

    public Empleado(
        int id,
        String nombre,
        String apellido,
        int edad,
        double salario,
        Turno turno
    ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
        this.turno = turno;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Turno getTurno() {
        return this.turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "id: " + this.id +
            ", nombre: " + this.nombre + '\'' +
            ", apellido: " + this.apellido + '\'' +
            ", edad: " + this.edad +
            ", salario: " + this.salario;
    }
}
