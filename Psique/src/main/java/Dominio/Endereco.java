/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Diego
 */
public class Endereco {
    
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;
    private int telefone;

    public Endereco(String logradouro, int numero, String complemento, String bairro, String cidade, String estado, int cep, int telefone) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "<td>" + logradouro + "</td>"+"<td>" +numero+"</td>"+ "<td>" + complemento +"</td>"+ "<td>" + bairro +"</td>" +"<td>" + cidade+"</td>" + "<td>" + estado + "</td>"+"<td>" +cep+"</td>"+"<td>" +telefone+"</td>";
    }
    
    
    
    
}
