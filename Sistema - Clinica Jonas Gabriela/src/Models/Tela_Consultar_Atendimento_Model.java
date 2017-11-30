/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.Tela_Agendamentos_DAO;
import DAO.Tela_Consultar_Atendimento_DAO;
import DAO.Tela_Fazer_Atendimento_DAO;
import DAO.Tela_Informacoes_DAO;
import DAO.Tela_Pagar_Consulta_DAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Consultar_Atendimento_Model {
    public Tela_Consultar_Atendimento_DAO dao;
    public Tela_Consultar_Atendimento_Model(){
        this.dao=new Tela_Consultar_Atendimento_DAO();
    }
    public String[] getInformacoes() {
        return this.dao.Retorna_Noticias();
    }
    public String[] getInformacoes(String paciente, String medico) {
        return this.dao.Retorna_Noticias(paciente, medico);
    }
    public ArrayList getPaciente(){
        return this.dao.Pacientes();
    }
    public ArrayList getAgenda(String paciente, String medico){
        return this.dao.Agendas(paciente, medico);
    }
    public ArrayList Medicos(){
        return this.dao.Medicos();
    }
    public String getText(String idpaciente, String idfuncionario, String consulta){
        return this.dao.getText(this.dao.IdPaciente(idpaciente), this.dao.IdFuncionario(idfuncionario), Integer.parseInt(consulta));
    }
}
