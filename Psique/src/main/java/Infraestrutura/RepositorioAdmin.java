/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Admin;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class RepositorioAdmin implements InterfaceRepositorios<Admin> {

    @Override
    public void cadastrar(Admin t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Admin> consultar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Admin> consultarNome(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Admin t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
