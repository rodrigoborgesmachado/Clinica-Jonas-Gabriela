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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Agendamentos_DAO {
    private Connection instancia;
    public Tela_Agendamentos_DAO(){
        this.instancia = Singleton_Connection_Banco_Mysql.GetInstance();
    }
    public String setHora(int i){
        if(i<10)return "0"+i;            
        return ""+i;
    }
    public String[] Retorna_Noticias(){
        String texto[] = new String[1000];
        String sql="SELECT agenda.pago, agenda.CODAGENDAMENTO, agenda.DAT as data, agenda.HORA,"
                + " funcionario.nome as nomefun, paciente.NOME as nomepa FROM agenda, funcionario,"
                + " paciente "
                + "WHERE AGENDA.CODFUNCIONARIO = FUNCIONARIO.CODFUN "
                + "AND AGENDA.CODPACIENTE = PACIENTE.CODPACIENTE;";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            int j=0;
            while(results.next()){
                int hora = results.getInt("HORA")/100;
                String time=setHora(hora);
                texto[j++]= new String("Nº Consulta: "+results.getString("CODAGENDAMENTO"));
                texto[j++]= new String("Dia "+results.getString("Data"));    
                texto[j++]= new String("\nHora: "+time);    
                texto[j++]= new String("\nFuncionário: "+results.getString("nomefun"));    
                texto[j++]= new String("\nPaciente: "+results.getString("nomepa"));    
                int t=results.getInt("pago");
                if(t == 0)texto[j++]= new String("\nO pagamento não foi efetuado.");   
                else texto[j++]= new String("\nPagamento Efetuado.");   
                texto[j++]= new String("           ");    
            }
            stm.close();
            return texto;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return texto;
        }
    }
    public String[] Retorna_Noticias(String medico){
        String texto[] = new String[1000];
        String sql="SELECT agenda.pago, agenda.CODAGENDAMENTO, agenda.DATA, agenda.HORA, funcionario.nome as nomefun, paciente.NOME as nomepa FROM agenda, funcionario, paciente WHERE AGENDA.CODFUNCIONARIO = FUNCIONARIO.CODFUN AND AGENDA.CODPACIENTE = PACIENTE.CODPACIENTE "
                + "AND funcionario.NOME = ?;";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setString(1, medico);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            int j=0;
            while(results.next()){
                int hora = results.getInt("HORA")/100;
                String time=setHora(hora);
                texto[j++]= new String("Nº Consulta: "+results.getString("CODAGENDAMENTO"));
                texto[j++]= new String("Dia "+results.getString("Data"));    
                texto[j++]= new String("\nHora: "+time);    
                texto[j++]= new String("\nFuncionário: "+results.getString("nomefun"));    
                texto[j++]= new String("\nPaciente: "+results.getString("nomepa"));
                int t=results.getInt("pago");
                if(t == 0)texto[j++]= new String("\nO pagamento não foi efetuado.");   
                else texto[j++]= new String("\nPagamento Efetuado.");   
                texto[j++]= new String("           ");    
            }
            stm.close();
            return texto;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return texto;
        }
    }
    public ArrayList Medicos(){
        String sql="SELECT * FROM funcionario WHERE CARGO = 'medico'";
        ArrayList temp = new ArrayList<String>();
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
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
}
