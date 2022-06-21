/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.MySQLConnection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class Banco {
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
    
    
        final String driver = "com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://localhost/mysql";
        String usuario="root";
        String senha="dominuskratum";
        
        Class.forName(driver);
        return (Connection) DriverManager.getConnection(url, usuario, senha);
            
    }
    
}
