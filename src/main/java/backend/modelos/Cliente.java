package backend.modelos;
import backend.servicios.Factura;

import java.util.ArrayList;
import java.io.Serializable;

public class Cliente implements Serializable
{
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private double puntos;
    private ArrayList<Factura> compras;

    public Cliente() {
        this.id = -1;
        this.nombre = "";
        this.apellido = "";
        this.telefono = "";
        this.puntos = 0;
        this.compras = new ArrayList<Factura>();
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
        this.compras = new ArrayList<Factura>();
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

    public void agregarCompra(Factura factura) {
        this.compras.add(factura);
    }

    public ArrayList<Factura> getCompras() {
        return this.compras;
    }

    public void setCompras(ArrayList<Factura> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "\nid: " + this.id +
            "\nnombre: " + this.nombre +
            "\napellido: " + this.apellido +
            "\ntelefono: " + this.telefono +
            "\npuntos: " + this.puntos;
    }
}
