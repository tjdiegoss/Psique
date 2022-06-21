/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Diego
 */
public class Usuario {

    private String login;
    private String senha;
    private String cargo;

    public Usuario(String login, String senha, String cargo) {
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;


    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "<td>" +"<a href="+"\"DetalhesUsuarioServlet?busca="+login+"\">"+ login + "</a></td>"+"<td>"+ cargo+"</td>";
    }
}
