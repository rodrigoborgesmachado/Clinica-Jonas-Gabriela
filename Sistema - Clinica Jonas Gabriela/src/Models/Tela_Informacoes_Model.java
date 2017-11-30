/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.Tela_Informacoes_DAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Informacoes_Model {
    public Tela_Informacoes_DAO dao;
    public Tela_Informacoes_Model(){
        this.dao=new Tela_Informacoes_DAO();
    }
    public String[] getInformacoes() {
        return this.dao.Retorna_Noticias();
    }
}
