/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public interface InterfaceRepositorios <T>{
    
    public void cadastrar(T t);
    public ArrayList<T> consultar();
    public ArrayList<T> consultarNome(String s);
    public void atualizar(T t);
    public void deletar(String s);
    
}
