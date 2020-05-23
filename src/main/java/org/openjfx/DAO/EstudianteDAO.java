package org.openjfx.DAO;

import java.sql.Connection;
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
        try {
            conexion = Conexion.getConnection();
            Statement getEstudiantes = conexion.createStatement();
            ResultSet rs = getEstudiantes.executeQuery(query);
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
            Conexion.close(conexion);
        }
        
        return estudiantes;
    }
}
