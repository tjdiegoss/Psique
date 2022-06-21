/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Diego
 */
public class Paciente {

    private String nome;
    private String cpf;
    private int rg;
    private Endereco endereco;

    public Paciente(String nome, String cpf, int rg, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "<td>" + nome + "</td>"+"<td>"+ cpf+"</td>"+"</td>"+"<td>"+ rg+"</td>"+"<td>"+ endereco.toString()+"</td>";
    }
    
    public String toString1() {
        return "<td>" + nome + "</td>"+"<td>"+ cpf+"</td>"+"</td>"+"<td>"+ rg+"</td>"+"<td>"+ endereco.getTelefone()+"</td>";
    }
    
    
}
