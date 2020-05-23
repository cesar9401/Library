package org.openjfx.DTO;

import java.sql.Timestamp;

/**
 *
 * @author cesar31
 */
public class Devoluciones {
    private int id_devolucion;
    private int id_prestamos;
    private java.sql.Timestamp fechaDevolucion;
    private double costo;
    private String descripcion;

    public Devoluciones(int id_devolucion, int id_prestamos, Timestamp fechaDevolucion, double costo) {
        this.id_devolucion = id_devolucion;
        this.id_prestamos = id_prestamos;
        this.fechaDevolucion = fechaDevolucion;
        this.costo = costo;
    }
    
    public int getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
    }

    public int getId_prestamos() {
        return id_prestamos;
    }

    public void setId_prestamos(int id_prestamos) {
        this.id_prestamos = id_prestamos;
    }

    public Timestamp getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Timestamp fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Devoluciones{" + "id_devolucion=" + id_devolucion + ", id_prestamos=" + id_prestamos + ", fechaDevolucion=" + fechaDevolucion + ", costo=" + costo + '}';
    }
}
