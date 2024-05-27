package backend.modelos;

import java.io.Serializable;

public class Producto implements Serializable
{
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {
        this.id = -1;
        this.nombre = "";
        this.precio = -1;
        this.stock = -1;
    }

    public Producto(
        int id,
        String nombre,
        double precio,
        int stock
    ){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
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

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        return this.nombre + " - " + this.precio + " - " + this.stock;
    }
}
