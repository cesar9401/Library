package org.openjfx.DTO;

/**
 *
 * @author cesar31
 */
public class Administrador {
    private int id_administrador;
    private String usuario;
    private String password;
    private String nombres;
    private String apellidos;

    public Administrador(int id_administrador, String usuario, String password) {
        this.id_administrador = id_administrador;
        this.usuario = usuario;
        this.password = password;
    }
    
    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "Administrador{" + "id_administrador=" + id_administrador + ", usuario=" + usuario + ", password=" + password + ", nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }
}
