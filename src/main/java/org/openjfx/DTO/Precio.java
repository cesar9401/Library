package org.openjfx.DTO;

/**
 *
 * @author cesar31
 */
public class Precio {
    private int id_precio;
    private int nombre;
    private double precio;
    private String descripcion;

    public Precio(int id_precio, int nombre, double precio) {
        this.id_precio = id_precio;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId_precio() {
        return id_precio;
    }

    public void setId_precio(int id_precio) {
        this.id_precio = id_precio;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Precio{" + "id_precio=" + id_precio + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion + '}';
    }
}
