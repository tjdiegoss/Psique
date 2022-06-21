/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class Consulta {
    
    private Paciente paciente;
    private Date data;
    private double valor;

    public Consulta(Paciente paciente, Date data, double valor) {
        this.paciente = paciente;
        this.data = data;
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Consulta{" + "paciente=" + paciente + ", data=" + data + ", valor=" + valor + '}';
    }
    
    
    
}
