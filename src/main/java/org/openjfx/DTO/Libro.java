package org.openjfx.DTO;

/**
 *
 * @author cesar31
 */
public class Libro {
    private int id_libro;
    private String codigo;
    private String nombre;
    private int edicion;
    private String autor;
    private String editorial;
    private int stock;

    public Libro(int id_libro, String codigo, String nombre, int edicion) {
        this.id_libro = id_libro;
        this.codigo = codigo;
        this.nombre = nombre;
        this.edicion = edicion;
    }
    
    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Libro{" + "id_libro=" + id_libro + ", nombre=" + nombre + ", edicion=" + edicion + ", autor=" + autor + ", editorial=" + editorial + ", stock=" + stock + '}';
    }
}
