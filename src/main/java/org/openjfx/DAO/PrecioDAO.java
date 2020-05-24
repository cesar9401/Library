package org.openjfx.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.openjfx.DTO.Precio;

/**
 *
 * @author cesar31
 */
public class PrecioDAO {

    public List<Precio> getPrecios(){
        List<Precio> precios = new ArrayList<>();
        String query = "SELECT * FROM precios";
        
        Connection conexion = null;
        Statement getPrecios = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getPrecios = conexion.createStatement();
            rs = getPrecios.executeQuery(query);
            
            while(rs.next()){
                Precio precio = new Precio(rs.getInt("id_precios"), rs.getString("nombre"), rs.getDouble("precio"));
                precio.setDescripcion(rs.getString("descripcion"));
                
                precios.add(precio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(getPrecios);
            Conexion.close(conexion);
        }
        
        return precios;
    }
    
    public void insertPrecio(Precio precio){
        String query = "INSERT INTO precios(nombre, precio, descripcion) VALUES(?, ?, ?)";
        
        Connection conexion = null;
        PreparedStatement insPrecio = null;
        try {
            conexion = Conexion.getConnection();
            insPrecio = conexion.prepareStatement(query);
            insPrecio.setString(1, precio.getNombre());
            insPrecio.setDouble(2, precio.getPrecio());
            insPrecio.setString(3, precio.getDescripcion());
            
            insPrecio.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(insPrecio);
            Conexion.close(conexion);
        }
    }
    
    public void updatePrecio(Precio precio){
        String query = "UPDATE precios SET nombre = ?, precio = ?, descripcion = ? WHERE id_precios = ?";
        
        Connection conexion = null;
        PreparedStatement uptPrecio = null;
        try {
            conexion = Conexion.getConnection();
            uptPrecio = conexion.prepareStatement(query);
            uptPrecio.setString(1, precio.getNombre());
            uptPrecio.setDouble(2, precio.getPrecio());
            uptPrecio.setString(3, precio.getDescripcion());
            uptPrecio.setInt(4, precio.getId_precio());
            
            uptPrecio.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(uptPrecio);
            Conexion.close(conexion);
        }
    }
    
    public void deletePrecio(Precio precio){
        String query = "DELETE FROM precios WHERE id_precio = ?";
        
        Connection conexion = null;
        PreparedStatement delPrecio = null;
        try {
            conexion = Conexion.getConnection();
            delPrecio.setInt(1, precio.getId_precio());
            
            delPrecio.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
