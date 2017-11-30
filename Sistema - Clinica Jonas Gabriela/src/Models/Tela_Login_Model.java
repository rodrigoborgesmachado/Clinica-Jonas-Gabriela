/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Banco_de_Dados.Singleton_Connection_Banco_Mysql;
import DAO.Tela_Login_DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

/**
 *
 * @author Rodrigo
 */
public class Tela_Login_Model {    
    private Tela_Login_DAO banco= new Tela_Login_DAO();
    public int Verifica_Login(String login, String senha){
        int id=banco.Valida_Usuario(login, senha);
        if(id!=0)
            return id;
        return 0;
    }
    public String retorna_data(int id){
        String temp = banco.Retorna_String(id, "DATA_NASCIMENTO"); 
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
    public String retorna_Nome(int id){
        String temp= banco.Retorna_String(id, "NOME");
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
    public String retorna_Sexo(int id){
        String temp= banco.Retorna_String(id, "SEXO");
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
    public String retorna_Estado_Civil(int id){
        String temp=banco.Retorna_String(id, "ESTADO_CIVIL");
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
    public String retorna_Cargo(int id){
        String temp = banco.Retorna_String(id, "CARGO");
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
    public String retorna_Especialidade(int id){
        String temp = banco.Retorna_String(id, "ESPECIALIDADE");
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
    public String retorna_Email(int id){
        String temp= banco.Retorna_String(id, "EMAIL");
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
    public String retorna_CPF(int id){
        String temp= banco.Retorna_String(id, "CPF");
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
    public String retorna_RG(int id){
        String temp=banco.Retorna_String(id, "RG");
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
    public String retorna_Outro(int id){
        String temp=banco.Retorna_String(id, "OUTRO");
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
    public int retorna_IDEndereco(int id){
        int temp= banco.Retorna_Int(id, "IDENDERECO");
        //JOptionPane.showMessageDialog(null, temp);
        return temp;
    }
}
