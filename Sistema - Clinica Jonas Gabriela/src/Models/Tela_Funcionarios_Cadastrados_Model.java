/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.Tela_Cadastro_Funcionarios_DAO;
import DAO.Tela_Funcionarios_Cadastrados_DAO;
import Pessoa.Pessoa_Generica;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Rodrigo
 */
public class Tela_Funcionarios_Cadastrados_Model {    
    private final Tela_Funcionarios_Cadastrados_DAO banco= new Tela_Funcionarios_Cadastrados_DAO();
    public ArrayList Retorna_Noticias(){
        return this.banco.Retorna_Funcionarios();
    }
}
