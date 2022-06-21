/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

/**
 *
 * @author Diego
 */
public class TesteBanco {
    
    
    public static void main(String[] args){
    
    String nome = "Tiago";
    String email = "tiago@email.com";
    Pessoa p = new Pessoa(nome, email);
    
    Repositorio r = new Repositorio();
    r.add(p);
    
    System.out.println("Adicionado com sucesso!");
    
    }

    public TesteBanco() {
    }
    
    
}
