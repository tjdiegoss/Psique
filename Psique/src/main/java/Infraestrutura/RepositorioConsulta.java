/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Consulta;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class RepositorioConsulta implements InterfaceRepositorios<Consulta> {

    @Override
    public void cadastrar(Consulta t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Consulta> consultar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Consulta> consultarNome(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Consulta t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
