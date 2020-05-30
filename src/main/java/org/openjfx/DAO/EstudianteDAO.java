package org.openjfx.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.openjfx.DTO.Estudiante;

/**
 *
 * @author cesar31
 */
public class EstudianteDAO {
    
    public List<Estudiante> getEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        String query = "SELECT * FROM estudiantes";
        
        Connection conexion = null;
        Statement getEstudiantes = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getEstudiantes = conexion.createStatement();
            rs = getEstudiantes.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id_estudiantes");
                String carnet = rs.getString("carnet");
                String nombre = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String dpi = rs.getString("dpi");
                String carrera = rs.getString("carrera");
                boolean socio = rs.getBoolean("socio");
                
                Estudiante tmp = new Estudiante(id, carnet, carrera);
                tmp.setNombres(nombre);
                tmp.setApellidos(apellidos);
                tmp.setDpi(dpi);
                tmp.setSocio(socio);
                
                estudiantes.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(getEstudiantes);
            Conexion.close(conexion);
        }
        
        return estudiantes;
    }
    
    public Estudiante getEstudiantebyCarnet(String carnet){
        Estudiante estudiante = null;
        String query = "SELECT * FROM estudiantes WHERE carnet = ?";
        
        Connection conexion = null;
        PreparedStatement getEst = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getEst = conexion.prepareStatement(query);
            getEst.setString(1, carnet);
            rs = getEst.executeQuery();
            
            if(rs.next()){
                estudiante = new Estudiante(rs.getInt("id_estudiantes"), rs.getString("carnet"), rs.getString("carrera"));
                estudiante.setNombres(rs.getString("nombres"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setDpi(rs.getString("dpi"));
                estudiante.setSocio(rs.getBoolean("socio"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(getEst);
            Conexion.close(conexion);
        }
        
        return estudiante;
    }
    
    public void insertEstudiante(Estudiante estudiante){
        String query = "INSERT INTO estudiantes(carnet, nombres, apellidos, dpi, carrera, socio) VALUES(?, ?, ?, ?, ?, ?)";
       
        Connection conexion = null;
        PreparedStatement setEst = null;
        try {
            conexion = Conexion.getConnection();
            setEst = conexion.prepareStatement(query);
            setEst.setString(1, estudiante.getCarnet());
            setEst.setString(2, estudiante.getNombres());
            setEst.setString(3, estudiante.getApellidos());
            setEst.setString(4, estudiante.getDpi());
            setEst.setString(5, estudiante.getCarrera());
            setEst.setBoolean(6, estudiante.isSocio());
            
            setEst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(setEst);
            Conexion.close(conexion);
        }
    }
    
    public void updateEstudiante(Estudiante estudiante){
        String query = "UPDATE estudiantes SET carnet = ?, nombres = ?, apellidos = ?, dpi = ?, carrera = ?, socio = ? WHERE id_estudiantes = ?";
       
        Connection conexion = null;
        PreparedStatement uptEst = null;
        try {
            conexion = Conexion.getConnection();
            uptEst = conexion.prepareStatement(query);
            uptEst.setString(1, estudiante.getCarnet());
            uptEst.setString(2, estudiante.getNombres());
            uptEst.setString(3, estudiante.getApellidos());
            uptEst.setString(4, estudiante.getDpi());
            uptEst.setString(5, estudiante.getCarrera());
            uptEst.setBoolean(6, estudiante.isSocio());
            uptEst.setInt(7, estudiante.getId_estudiante());
            
            uptEst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(uptEst);
            Conexion.close(conexion);
        }
    }
    
    public void deleteEstudiante(Estudiante estudiante){
        String query = "DELETE FROM estudiantes WHERE id_estudiantes = ?";
       
        Connection conexion = null;
        PreparedStatement delEst = null;
        try {
            conexion = Conexion.getConnection();
            delEst = conexion.prepareStatement(query);
            delEst.setInt(1, estudiante.getId_estudiante());
            
            delEst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(delEst);
            Conexion.close(conexion);
        }
    }
}
