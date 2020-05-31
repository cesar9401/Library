package org.openjfx.DTO;

/**
 *
 * @author cesar31
 */
public class Estudiante {
    private int id_estudiante;
    private String carnet;
    private String nombres;
    private String apellidos;
    private String dpi;
    private String carrera;
    private boolean socio;

    public Estudiante(int id_estudiante, String carnet, String carrera) {
        this.id_estudiante = id_estudiante;
        this.carnet = carnet;
        this.carrera = carrera;
    }

    public Estudiante(String carnet, String nombres, String apellidos, String dpi, String carrera, boolean socio) {
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dpi = dpi;
        this.carrera = carrera;
        this.socio = socio;
    }
    
    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public boolean isSocio() {
        return socio;
    }

    public void setSocio(boolean socio) {
        this.socio = socio;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id_estudiante=" + id_estudiante + ", carnet=" + carnet + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dpi=" + dpi + ", carrera=" + carrera + ", socio=" + socio + '}';
    }
}
