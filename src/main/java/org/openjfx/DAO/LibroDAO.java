package org.openjfx.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                Libro tmp = new Libro(rs.getInt("id_libros"), rs.getString("codigo"), rs.getString("nombre"), rs.getInt("edicion"));
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
        String query = "INSERT INTO libros(codigo, nombre, edicion, autor, editorial, stock) VALUES(?, ?, ?, ?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement setLib = null;
        try {
            conexion = Conexion.getConnection();
            setLib = conexion.prepareStatement(query);
            setLib.setString(1, libro.getCodigo());
            setLib.setString(2, libro.getNombre());
            setLib.setInt(3, libro.getEdicion());
            setLib.setString(4, libro.getAutor());
            setLib.setString(5, libro.getEditorial());
            setLib.setInt(6, libro.getStock());

            setLib.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(setLib);
            Conexion.close(conexion);
        }
    }
    
    public void updateLibro(Libro libro){
        String query = "UPDATE libros SET codigo = ?, nombre = ?, edicion = ?, autor = ?, editorial = ?, stock = ? WHERE id_libros = ?";

        Connection conexion = null;
        PreparedStatement uptLib = null;
        try {
            conexion = Conexion.getConnection();
            uptLib = conexion.prepareStatement(query);
            uptLib.setString(1, libro.getCodigo());
            uptLib.setString(2, libro.getNombre());
            uptLib.setInt(3, libro.getEdicion());
            uptLib.setString(4, libro.getAutor());
            uptLib.setString(5, libro.getEditorial());
            uptLib.setInt(6, libro.getStock());
            uptLib.setInt(7, libro.getId_libro());

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
    
    public List<Libro> getLibrosForSearch(String busqueda){
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libros WHERE codigo LIKE ? OR nombre LIKE ? OR autor LIKE ? OR editorial LIKE ?";
        Connection conexion = null;
        PreparedStatement getLib = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getLib = conexion.prepareStatement(query);
            getLib.setString(1, busqueda);
            getLib.setString(2, busqueda);
            getLib.setString(3, busqueda);
            getLib.setString(4, busqueda);
            rs = getLib.executeQuery();
            
            while(rs.next()){
                Libro tmp = new Libro(rs.getInt("id_libros"), rs.getString("codigo"), rs.getString("nombre"), rs.getInt("edicion"));
                tmp.setAutor(rs.getString("autor"));
                tmp.setEditorial(rs.getString("editorial"));
                tmp.setStock(rs.getInt("stock"));
                
                libros.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(getLib);
            Conexion.close(conexion);
        }
        return libros;
    }
}
