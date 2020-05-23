package org.openjfx.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.openjfx.DTO.Libro;

/**
 *
 * @author cesar31
 */
public class LibroDAO {
    
    public List<Libro> getLibros(){
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libros";
        
        Connection conexion = null;
        Statement getLibros = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getLibros = conexion.createStatement();
            rs = getLibros.executeQuery(query);
            while(rs.next()){
                Libro tmp = new Libro(rs.getInt("id_libros"), rs.getString("nombre"), rs.getInt("edicion"));
                tmp.setAutor(rs.getString("autor"));
                tmp.setEditorial(rs.getString("editorial"));
                tmp.setStock(rs.getInt("stock"));
                
                libros.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(getLibros);
            Conexion.close(conexion);
        }
        
        return libros;
    }
    
    public void insertLibro(Libro libro){
        String query = "INSERT INTO libros(nombre, edicion, autor, editorial, stock) VALUES(?, ?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setLib = null;
        try {
            conexion = Conexion.getConnection();
            setLib = conexion.prepareStatement(query);
            setLib.setString(1, libro.getNombre());
            setLib.setInt(2, libro.getEdicion());
            setLib.setString(3, libro.getAutor());
            setLib.setString(4, libro.getEditorial());
            setLib.setInt(5, libro.getStock());

            setLib.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(setLib);
            Conexion.close(conexion);
        }
    }
    
    public void updateLibro(Libro libro){
        String query = "UPDATE libros SET nombre = ?, edicion = ?, autor = ?, editorial = ?, stock = ? WHERE id_libros = ?";

        Connection conexion = null;
        PreparedStatement uptLib = null;
        try {
            conexion = Conexion.getConnection();
            uptLib = conexion.prepareStatement(query);
            uptLib.setString(1, libro.getNombre());
            uptLib.setInt(2, libro.getEdicion());
            uptLib.setString(3, libro.getAutor());
            uptLib.setString(4, libro.getEditorial());
            uptLib.setInt(5, libro.getStock());
            uptLib.setInt(6, libro.getId_libro());

            uptLib.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(uptLib);
            Conexion.close(conexion);
        }
    }
    
    public void deleteLibro(Libro libro){
        String query = "DELETE FROM libros WHERE id_libros = ?";
        
        Connection conexion = null;
        PreparedStatement delLib = null;
        try {
            conexion = Conexion.getConnection();
            delLib = conexion.prepareStatement(query);
            delLib.setInt(1, libro.getId_libro());
            
            delLib.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(delLib);
            Conexion.close(conexion);
        }
    }
}
