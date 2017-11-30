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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Cadastro_Funcionarios_DAO {
    private Connection instancia;
    public Tela_Cadastro_Funcionarios_DAO(){
        this.instancia = Singleton_Connection_Banco_Mysql.GetInstance();
    }
    public boolean Insert_Funcionario(Pessoa_Generica pessoa){
        String sql="INSERT INTO funcionario(NOME, DATA_NASCIMENTO, SEXO, ESTADO_CIVIL, CARGO, ESPECIALIDADE,"+
                "EMAIL, CPF, RG, OUTRO, IDENDERECO) VALUES "
                +"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setString(1, pessoa.getNome());
            stm.setDate(2, pessoa.getData_nascimento());
            stm.setString(3, pessoa.getSexo());
            stm.setString(4, pessoa.getEstado_civil());
            stm.setString(5, pessoa.getCargo());
            stm.setString(6, pessoa.getEspecialidade());
            stm.setString(7, pessoa.getEmail());
            stm.setString(8, pessoa.getCpf());
            stm.setString(9, pessoa.getRg());
            stm.setString(10, pessoa.getOutro());
            stm.setInt(11, pessoa.getIdendereco());
            stm.execute();
            ResultSet results=stm.getResultSet();
            stm.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public int IdEndereco(String cep){
        String sql="SELECT * FROM enderecofun WHERE CEP = ?";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.setString(1, cep);
            stm.executeQuery();
            ResultSet results=stm.getResultSet();
            if(results.next()){
                int temp=results.getInt("IDENDERECO");
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
    public boolean Insert_Endereco(String cep, String tipodelogradouro, String numero, String complemento, String logradouro, String bairro, String cidade, String estado){
        if(this.IdEndereco(cep)!= -1) return true;
        String sql="INSERT INTO ENDERECOFUN(CEP, TIPO_DE_LOGRADOURO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO)"
                +" VALUES ('"+cep+"','"+tipodelogradouro+"','"+logradouro+"','"+numero+"','"+complemento
                +"','"+bairro+"','"+cidade+"','"+estado+"');";
        try {
            instancia.setAutoCommit(true);
            PreparedStatement stm= instancia.prepareStatement(sql);
            stm.execute();
            ResultSet results=stm.getResultSet();
            stm.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
