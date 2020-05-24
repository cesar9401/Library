package org.openjfx.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.openjfx.DTO.Administrador;

/**
 *
 * @author cesar31
 */
public class AdministradorDAO {
    
    public Administrador getAdmin(String user, String pass){
        Administrador admin = null;
        String query = "SELECT * from administradores WHERE usuario = ? AND password = ?";
        
        Connection conexion = null;
        PreparedStatement getAdmin = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.getConnection();
            getAdmin = conexion.prepareStatement(query);
            getAdmin.setString(1, user);
            getAdmin.setString(2, pass);
            rs = getAdmin.executeQuery();
            if(rs.next()){
                admin = new Administrador(rs.getInt("id_administradores"), rs.getString("usuario"), rs.getString("password"));
                admin.setNombres(rs.getString("nombres"));
                admin.setApellidos(rs.getString("apellidos"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(getAdmin);
            Conexion.close(conexion);
        }
        
        return admin;
    }
}
