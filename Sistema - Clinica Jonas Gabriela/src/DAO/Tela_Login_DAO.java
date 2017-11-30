/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Banco_de_Dados.Singleton_Connection_Banco_Mysql;
import Models.Tela_Login_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

/**
 *
 * @author Rodrigo
 */
public class Tela_Login_DAO {
    private Connection instancia;
    public Tela_Login_DAO(){
        this.instancia = Singleton_Connection_Banco_Mysql.GetInstance();
    }
    public int Valida_Usuario(String user, String pass){
        String sql="SELECT funcionario.codfun as codigo FROM usuario, funcionario WHERE Login = ? and Senha = ? and funcionario.codfun = usuario.codfun;";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            if(results.next()){
                int temp=results.getInt("codigo");
                stm.close();
                return temp;
            }
            stm.close();
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public Data Retorna_Data(int id, String Campo){
        Data date = null;
        String sql="SELECT DATA_NASCIMENTO as Data FROM funcionario WHERE codfun = ?";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            if(results.next())
                date= (Data) results.getDate("Data");
            stm.close();
            return date;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return date;
        }
    }
    public String Retorna_String(int id, String Campo){
        String nome = null;
        String sql="SELECT * FROM funcionario WHERE codfun = ?";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            if(results.next())
                nome= results.getString(Campo);
            stm.close();
            return nome;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return nome;
        }
    }
    public int Retorna_Int(int id, String Campo){
        int nome = 0;
        String sql="SELECT * FROM funcionario WHERE codfun = ?";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            if(results.next())
                nome= results.getInt(Campo);
            stm.close();
            return nome;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return nome;
        }
    }
}
