package org.openjfx.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.openjfx.DTO.Prestamo;

/**
 *
 * @author cesar31
 */
public class PrestamoDAO {
    
//select id_prestamos, prestamos.id_estudiantes, carnet, libros.id_libros, nombre, fecha_prestamo from prestamos inner join estudiantes inner join libros 
//where prestamos.id_estudiantes = estudiantes.id_estudiantes and  prestamos.id_libros = libros.id_libros and activo = true;    
    
    public List<Prestamo> getPrestamosActivos(){
        List<Prestamo> prestamos = new ArrayList<>();
        String query = "SELECT id_prestamos, prestamos.id_estudiantes, carnet, libros.id_libros, nombre, fecha_prestamo FROM prestamos INNER JOIN estudiantes INNER JOIN libros "
                + "WHERE prestamos.id_estudiantes = estudiantes.id_estudiantes AND prestamos.id_libros = libros.id_libros AND activo = true";
        Connection conexion = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            st = conexion.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                Prestamo tmp = new Prestamo(rs.getInt("id_prestamos"), rs.getInt("id_estudiantes"), rs.getInt("id_libros"));
                tmp.setCarnetEstudiante(rs.getString("carnet"));
                tmp.setFechaPrestamo(rs.getTimestamp("fecha_prestamo"));
                tmp.setNombreLibro(rs.getString("nombre"));
                
                prestamos.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(st);
            Conexion.close(conexion);
        }
        
        return prestamos;
    }
}
