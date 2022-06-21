/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Usuario;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class RepositorioUsuario implements InterfaceRepositorios<Usuario>{
    
    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    @Override
    public void cadastrar(Usuario u) {
        try {
            con = (Connection) Conexao.getConnection();

            stm = (PreparedStatement) con.prepareStatement("insert into usuario values(?,?,?)");

            stm.setString(1, u.getLogin());
            stm.setString(2, u.getSenha());
            stm.setString(3, u.getCargo());            
            
            stm.execute();            
            stm.close();
            con.close();


        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Usuario> consultar() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        
         try {
            con = (Connection) Conexao.getConnection();
            
            stm = (PreparedStatement) con.prepareStatement("select * from usuario order by login_pk;");
            rs = stm.executeQuery();
            
            
           
            
            while(rs.next()){
     
                
               
                String login = rs.getString("login_pk");
                String senha = rs.getString("senha");
                String cargo = rs.getString("cargo");
                               
                Usuario u = new Usuario(login, senha, cargo);
                
               lista.add(u);
               
                
                
                
            }
            
            stm.close();  
            con.close();   
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public ArrayList<Usuario> consultarNome(String busca) {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        
         try {
            con = (Connection) Conexao.getConnection();
                        
            
            stm = (PreparedStatement) con.prepareStatement("select * from usuario where login_pk = '" + busca + "' order by login_pk;");
            rs = stm.executeQuery();
            
            
           
            
            while(rs.next()){
     
                
               
                String login = rs.getString("login_pk");
                String senha = rs.getString("senha");
                String cargo = rs.getString("cargo");
                
                
                Usuario u = new Usuario(login, senha, cargo);
                
                lista.add(u);
               
                
                
                
            }
            stm.close();
            con.close();   
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    

    @Override
    public void atualizar(Usuario u) {
        try {
            con = (Connection) Conexao.getConnection();
            
            stm = (PreparedStatement) con.prepareStatement("update usuario set login_pk = '"+ u.getLogin()+"',"
                    + " cargo = '"+u.getCargo()+"',"
                    + " senha = '"+u.getSenha()+"'"
                    +" where login_pk = '"+u.getLogin()+"';");
                                                         
            stm.execute();
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(String s) {
        try {
            con = (Connection) Conexao.getConnection();

                     
            stm = (PreparedStatement) con.prepareStatement("delete from usuario where login_pk = '" + s+"';");

            stm.execute();            
            stm.close();
            con.close();


        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public boolean verificatLogin(String log, String sen){

    Usuario user = new Usuario(log, sen, null);
    boolean resp = false;
        
         try {
            con = (Connection) Conexao.getConnection();
                        
            
            stm = (PreparedStatement) con.prepareStatement("select * from usuario where login_pk = '" + log + "';");
            rs = stm.executeQuery();
            
            
           
            
            while(rs.next()){
     
                
               
                String login = rs.getString("login_pk");
                String senha = rs.getString("senha");
                String cargo = rs.getString("cargo");
                
                
                Usuario u = new Usuario(login, senha, cargo);
                                
            if(u.getLogin().equals(user.getLogin()) && u.getSenha().equals(user.getSenha())){
            
                resp = true;
            }else {
            
                resp = false;
            }
                
                
                
            }
            stm.close();
            con.close();   
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    return resp;
}
    
}