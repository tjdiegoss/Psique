/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class Repositorio {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Repositorio() {
    }
    
    
   public void add(Pessoa p){
    try{
            
                con = Banco.getConnection();
                ps = (PreparedStatement) con.prepareStatement("insert into pessoa values (?,?);");
                ps.setString(1, p.getNome());
                ps.setString(2, p.getEmail());
                
                ps.execute();            
                ps.close();
                con.close();
            
            }catch (SQLException ex){Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Repositorio.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
}
