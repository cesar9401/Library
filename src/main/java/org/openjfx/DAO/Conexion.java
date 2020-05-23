package org.openjfx.DAO;

import java.sql.*;

/**
 *
 * @author cesar31
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost/library";
    private static final String USER = "cesar31";
    private static final String PASS = "Huevos94C";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASS);
    }
    
    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
