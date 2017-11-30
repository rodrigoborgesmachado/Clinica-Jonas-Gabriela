/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.Tela_Agendamentos_DAO;
import DAO.Tela_Informacoes_DAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Agendamentos_Model {
    public Tela_Agendamentos_DAO dao;
    public Tela_Agendamentos_Model(){
        this.dao=new Tela_Agendamentos_DAO();
    }
    public String[] getInformacoes() {
        return this.dao.Retorna_Noticias();
    }
    public String[] getInformacoes(String medico) {
        return this.dao.Retorna_Noticias(medico);
    }
    public ArrayList getMedico(){
        return this.dao.Medicos();
    }
    
}
