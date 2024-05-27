package backend.modelos;
import java.util.ArrayList;

public class Cliente
{
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private double puntos;
    // private ArrayList<Factura> compras;

    public Cliente() {
        this.id = -1;
        this.nombre = "";
        this.apellido = "";
        this.telefono = "";
        this.puntos = 0;
    }

    public Cliente(
        int id,
        String nombre,
        String apellido,
        String telefono,
        double puntos
    ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.puntos = puntos;
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

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getPuntos() {
        return this.puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public void agregarPuntos(double puntos) {
        this.puntos += puntos;
    }

    public void restarPuntos(double puntos) {
        this.puntos -= puntos;
    }

    @Override
    public String toString() {
        return "id: " + this.id +
            ", nombre: " + this.nombre +
            ", apellido: " + this.apellido +
            ", telefono: " + this.telefono +
            ", puntos: " + this.puntos;
    }
}
