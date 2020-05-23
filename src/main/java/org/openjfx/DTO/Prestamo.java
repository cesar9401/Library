package org.openjfx.DTO;

import java.sql.Timestamp;

/**
 *
 * @author cesar31
 */
public class Prestamo {
    private int id_prestamo;
    private int id_estudiante;
    private int id_libro;
    private java.sql.Timestamp fechaPrestamo;
    private boolean activo;

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public Timestamp getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Timestamp fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id_prestamo=" + id_prestamo + ", id_estudiante=" + id_estudiante + ", id_libro=" + id_libro + ", fechaPrestamo=" + fechaPrestamo + ", activo=" + activo + '}';
    }
}
