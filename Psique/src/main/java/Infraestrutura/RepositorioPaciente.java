/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Endereco;
import Dominio.Paciente;
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
public class RepositorioPaciente implements InterfaceRepositorios<Paciente> {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;
    @Override
    public void cadastrar(Paciente p) {
        
        try {
            con = (Connection) Conexao.getConnection();

            stm = (PreparedStatement) con.prepareStatement("insert into paciente values(?,?,?,?,?,?,?,?,?,?,?)");

            stm.setString(1, p.getNome());
            stm.setString(2, p.getCpf());
            stm.setInt(3, p.getRg());
            stm.setString(4, p.getEndereco().getLogradouro());
            stm.setInt(5, p.getEndereco().getNumero());
            stm.setString(6, p.getEndereco().getComplemento());
            stm.setString(7, p.getEndereco().getBairro());
            stm.setString(8, p.getEndereco().getCidade());
            stm.setString(9, p.getEndereco().getEstado());
            stm.setInt(10, p.getEndereco().getCep());
            stm.setInt(11, p.getEndereco().getTelefone());
            
            stm.execute();            
            stm.close();
            con.close();


        } catch (SQLException ex) {
            Logger.getLogger(RepositorioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public ArrayList<Paciente> consultar() {
        
        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        
         try {
            con = (Connection) Conexao.getConnection();
            
            stm = (PreparedStatement) con.prepareStatement("select * from paciente order by nome;");
            rs = stm.executeQuery();
            
            
           
            
            while(rs.next()){
     
                
               
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF_PK");
                int rg = rs.getInt("RG");
                String logradouro = rs.getString("LOGRADOURO");
                int numero = rs.getInt("NUMERO");
                String complemento = rs.getString("COMPLEMENTO");
                String bairro = rs.getString("BAIRRO");
                String cidade = rs.getString("CIDADE");
                String estado = rs.getString("ESTADO");
                int cep = rs.getInt("CEP");
                int telefone = rs.getInt("TELEFONE");
                Endereco end = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, telefone);             
                Paciente p = new Paciente(nome, cpf, rg, end);
                
               lista.add(p);
               
                
                
                
            }
            
            stm.close();  
            con.close();   
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public ArrayList<Paciente> consultarNome(String busca) {
        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        
         try {
            con = (Connection) Conexao.getConnection();
                        
            
            stm = (PreparedStatement) con.prepareStatement("select * from paciente where nome like '%" + busca + "%' order by nome;");
            rs = stm.executeQuery();
            
            
           
            
            while(rs.next()){
     
                
               
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF_PK");
                int rg = rs.getInt("RG");
                String logradouro = rs.getString("LOGRADOURO");
                int numero = rs.getInt("NUMERO");
                String complemento = rs.getString("COMPLEMENTO");
                String bairro = rs.getString("BAIRRO");
                String cidade = rs.getString("CIDADE");
                String estado = rs.getString("ESTADO");
                int cep = rs.getInt("CEP");
                int telefone = rs.getInt("TELEFONE");
                Endereco end = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, telefone);             
                Paciente p = new Paciente(nome, cpf, rg, end);
                
                lista.add(p);
               
                
                
                
            }
            stm.close();
            con.close();   
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public void atualizar(Paciente p) {
        try {
            con = (Connection) Conexao.getConnection();
            
            stm = (PreparedStatement) con.prepareStatement("update paciente set nome = '"+ p.getNome()+"',"
                    + " rg = '"+p.getRg()+"',"
                    + " logradouro = '"+p.getEndereco().getLogradouro()+"',"
                    + " numero = '"+p.getEndereco().getNumero()+"',"
                    + " complemento = '"+p.getEndereco().getComplemento()+"',"
                    + " bairro = '"+p.getEndereco().getBairro()+"',"
                    + " cidade = '"+p.getEndereco().getCidade()+"',"
                    + " estado = '"+p.getEndereco().getEstado()+"',"
                    + " cep = '"+p.getEndereco().getCep()+"',"
                    + " telefone = '"+p.getEndereco().getTelefone()+"'"
                    +" where cpf_pk = '"+p.getCpf()+"';");
                                                         
            stm.execute();
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(String s) {
        try {
            con = (Connection) Conexao.getConnection();

                     
            stm = (PreparedStatement) con.prepareStatement("delete from paciente where cpf_pk = '" + s+"';");

            stm.execute();            
            stm.close();
            con.close();


        } catch (SQLException ex) {
            Logger.getLogger(RepositorioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
