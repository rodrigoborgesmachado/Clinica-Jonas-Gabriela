package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Tela_Funcionarios_Enderecos_DAO {
    private Connection instancia;
    public Tela_Funcionarios_Enderecos_DAO(){
        this.instancia = Singleton_Connection_Banco_Mysql.GetInstance();
    }
    public ArrayList Retorna_Enderecos(){
        ArrayList texto = new ArrayList<String>();
        String sql="SELECT FUN.NOME AS NOME, ENDE.* FROM funcionario FUN, "
                + "enderecofun ENDE WHERE FUN.IDENDERECO=ENDE.IDENDERECO;";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            while(results.next()){
                texto.add("Funcionário "+results.getString("NOME"));
                texto.add("   CEP: "+results.getString("CEP"));
                texto.add("   Logradouro: "+results.getString("Logradouro"));
                texto.add("   Numero: "+results.getString("Numero"));
                texto.add("   Complemento: "+results.getString("Complemento"));
                texto.add("   Bairro: "+results.getString("Bairro"));
                texto.add("   Cidade: "+results.getString("Cidade"));
                texto.add("   Estado: "+results.getString("Estado"));
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
