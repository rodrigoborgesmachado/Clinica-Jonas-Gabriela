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

/**
 *
 * @author Rodrigo
 */
public class Tela_Informacoes_DAO {
    private Connection instancia;
    public Tela_Informacoes_DAO(){
        this.instancia = Singleton_Connection_Banco_Mysql.GetInstance();
    }
    public String setHora(int i){
        if(i<10)return "0"+i;            
        return ""+i;
    }
    public String[] Retorna_Noticias(){
        String texto[] = {"", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        String sql="SELECT agenda.DAT as data, agenda.HORA, funcionario.nome as nomefun, "
                + "paciente.NOME as nomepa FROM agenda, funcionario, paciente "
                + "WHERE AGENDA.CODFUNCIONARIO = FUNCIONARIO.CODFUN "
                + "AND AGENDA.CODPACIENTE = PACIENTE.CODPACIENTE "
                + "AND AGENDA.DAT > NOW() ORDER BY AGENDA.DAT";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            int i=0, j=0;
            while(results.next() && i<10){
                int hora = results.getInt("HORA")/100;
                String time=setHora(hora);
                texto[j++]= new String("Dia "+results.getString("Data"));    
                texto[j++]= new String("\nHora: "+time);    
                texto[j++]= new String("\nFuncionário: "+results.getString("nomefun"));    
                texto[j++]= new String("\nPaciente: "+results.getString("nomepa"));    
                texto[j++]= new String("           ");    
                i++;
            }
            stm.close();
            return texto;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return texto;
        }
    }
}
