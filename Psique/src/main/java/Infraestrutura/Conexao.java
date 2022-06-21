/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {  
   public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException{
    
    
        final String driver = "com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://localhost/psique_db";
        String usuario="root";
        String senha="dominuskratum";
        
        Class.forName(driver);
        return (Connection) DriverManager.getConnection(url, usuario, senha);
        
    
   }  
}  