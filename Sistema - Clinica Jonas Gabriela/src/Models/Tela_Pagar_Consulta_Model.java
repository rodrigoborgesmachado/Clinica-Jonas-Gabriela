/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.Tela_Agendamentos_DAO;
import DAO.Tela_Informacoes_DAO;
import DAO.Tela_Pagar_Consulta_DAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Pagar_Consulta_Model {
    public Tela_Pagar_Consulta_DAO dao;
    public Tela_Pagar_Consulta_Model(){
        this.dao=new Tela_Pagar_Consulta_DAO();
    }
    public String[] getInformacoes() {
        return this.dao.Retorna_Noticias();
    }
    public String[] getInformacoes(String medico) {
        return this.dao.Retorna_Noticias(medico);
    }
    public ArrayList getPaciente(){
        return this.dao.Pacientes();
    }
    public ArrayList getAgenda(String paciente){
        return this.dao.Agendas(paciente);
    }
    public boolean realizarPagamento(String codigo){
        return this.dao.realizarPagamento( Integer.parseInt(codigo));
    }
}
