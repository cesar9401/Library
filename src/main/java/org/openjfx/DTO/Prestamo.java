package org.openjfx.DTO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
    
    //Atributo para ver en la tabla;
    private String carnetEstudiante;
    private String nombreLibro;
    private String fechaString;

    public Prestamo(int id_prestamo, int id_estudiante, int id_libro) {
        this.id_prestamo = id_prestamo;
        this.id_estudiante = id_estudiante;
        this.id_libro = id_libro;
    }

    public Prestamo(int id_estudiante, int id_libro, Timestamp fechaPrestamo) {
        this.id_estudiante = id_estudiante;
        this.id_libro = id_libro;
        this.fechaPrestamo = fechaPrestamo;
    }

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
        convertDate();
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(String carnetEstudiante) {
        this.carnetEstudiante = carnetEstudiante;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getFechaString() {
        return fechaString;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }
    
    @Override
    public String toString() {
        return "Prestamo{" + "id_prestamo=" + id_prestamo + ", id_estudiante=" + id_estudiante + ", id_libro=" + id_libro + ", fechaPrestamo=" + fechaPrestamo + ", activo=" + activo + '}';
    }
    
    private void convertDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        this.fechaString = sdf.format(this.fechaPrestamo);
    }
}
