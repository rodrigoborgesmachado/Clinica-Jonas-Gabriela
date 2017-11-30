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
public class Tela_Funcionarios_Cadastrados_DAO {
    private Connection instancia;
    public Tela_Funcionarios_Cadastrados_DAO(){
        this.instancia = Singleton_Connection_Banco_Mysql.GetInstance();
    }
    public String getSexo(String c){
        if(c.length()>0)
            if(c.charAt(0) == 'F' || c.charAt(0) == 'f')
                return "Femenino";
        return "Masculino";
    }
    public ArrayList Retorna_Funcionarios(){
        ArrayList texto = new ArrayList<String>();
        String sql="SELECT * FROM FUNCIONARIO";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            while(results.next()){
                texto.add("Funcionário "+results.getString("NOME"));
                texto.add("   Cargo: "+results.getString("Cargo"));
                texto.add("   Especialidade: "+results.getString("ESPECIALIDADE"));
                texto.add("   Sexo: "+this.getSexo(results.getString("SEXO")));
                texto.add("   Estado Civil: "+results.getString("ESTADO_CIVIL"));
                texto.add("   Data de Nascimento: "+results.getString("DATA_NASCIMENTO"));
                texto.add("   Email: "+results.getString("EMAIL"));
                texto.add("   RG: "+results.getString("RG"));
                texto.add("   CPF: "+results.getString("CPF"));
                texto.add("    ");
            }
            stm.close();
            return texto;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return texto;
        }
    }
}
