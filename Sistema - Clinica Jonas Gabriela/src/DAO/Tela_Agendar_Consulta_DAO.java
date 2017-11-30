/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Banco_de_Dados.Singleton_Connection_Banco_Mysql;
import Models.Tela_Login_Model;
import Pessoa.Pessoa_Generica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Agendar_Consulta_DAO {
    private Connection instancia;
    public Tela_Agendar_Consulta_DAO(){
        this.instancia = Singleton_Connection_Banco_Mysql.GetInstance();
    }
    public boolean Verifica_Paciente(String nome, String email){
        String sql="SELECT * FROM paciente WHERE EMAIL = ? && NOME = ?";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, nome);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            if(results.next()){
                stm.close();
                return true;
            }
            stm.close();
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean Insert_Paciente(String nome, String Email){
        if(!this.Verifica_Paciente(nome, Email)){
            String sql="INSERT INTO paciente(NOME, EMAIL) VALUES "
                +"(?, ?)";
            try {
                instancia.setAutoCommit(true);
                PreparedStatement stm= instancia.prepareStatement(sql);
                stm.setString(1, nome);
                stm.setString(2, Email);
                stm.execute();
                ResultSet results=stm.getResultSet();
                stm.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    public boolean Insert_Agenda(String data, int hora, int codf, int codp){
        String sql="INSERT INTO agenda(DAT, HORA, CODFUNCIONARIO, CODPACIENTE, PAGO) VALUES "
                +"(?, ?, ?, ?, 0)";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setDate(1, this.transformaData(data));
            stm.setInt(2, hora*100);
            stm.setInt(3, codf);
            stm.setInt(4, codp);
            stm.execute();
            ResultSet results=stm.getResultSet();
            stm.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public int IdPaciente(String email){
        String sql="SELECT * FROM paciente WHERE EMAIL = ?";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setString(1, email);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            if(results.next()){
                int temp=results.getInt("CODPACIENTE");
                stm.close();
                return temp;
            }
            stm.close();
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public int IdFuncionario(String nome, String especialidade){
        String sql="SELECT * FROM funcionario WHERE NOME = ? AND ESPECIALIDADE = ?";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setString(1, nome);
            stm.setString(2, especialidade);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            if(results.next()){
                int temp=results.getInt("CODFUN");
                stm.close();
                return temp;
            }
            stm.close();
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public ArrayList Medicos(String especialidade){
        String sql="SELECT * FROM funcionario WHERE CARGO = 'medico' AND ESPECIALIDADE = ?";
        ArrayList temp = new ArrayList<String>();
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setString(1, especialidade);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            while(results.next()){
                temp.add(results.getString("NOME"));
            }
            stm.close();
            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return temp;
        }
    }
    public ArrayList Especialidade(){
        String sql="SELECT DISTINCT(ESPECIALIDADE) FROM funcionario";
        ArrayList temp = new ArrayList<String>();
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            while(results.next()){
                temp.add(results.getString("ESPECIALIDADE"));
            }
            stm.close();
            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return temp;
        }
    }
    public ArrayList hora(String medico, String date){
        String sql="SELECT agenda.HORA FROM AGENDA, funcionario WHERE funcionario.CODFUN = agenda.CODFUNCIONARIO AND agenda.DATA = ? AND funcionario.NOME = ?";
        ArrayList temp = new ArrayList<String>();
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setDate(1, this.transformaData(date));
            
            stm.setString(2, medico);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            for(int i=8;i<19;i++)temp.add(i);
            while(results.next()){
                int i, r=-1;
                for(i=0;i<temp.size();i++)
                    if(results.getInt("HORA") == (int)temp.get(i)){
                        r=i;
                        break;
                    }
                temp.remove(r);
                
            }
            stm.close();
            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return temp;
        }
    }
    public Date transformaData(String dat){
        String temp=dat;
        if(dat.charAt(2) == '/'){
            temp="";
            temp+= dat.charAt(6);
            temp+= dat.charAt(7);
            temp+= dat.charAt(8);
            temp+= dat.charAt(9);
            temp+='-';
            temp+= dat.charAt(3);
            temp+= dat.charAt(4);
            temp+='-';
            temp+= dat.charAt(0);
            temp+= dat.charAt(1);
        }
        return Date.valueOf(temp);
    }
}
