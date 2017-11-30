/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.Tela_Cadastro_Funcionarios_DAO;
import Pessoa.Pessoa_Generica;
import javax.swing.JOptionPane;
/**
 *
 * @author Rodrigo
 */
public class Tela_Cadastro_Funcionarios_Model {    
    private final Tela_Cadastro_Funcionarios_DAO banco= new Tela_Cadastro_Funcionarios_DAO();
    public boolean Cadastro_Endereco(String cep, String tipodelogradouro, String numero, String complemento, String logradouro, String bairro, String cidade, String estado){
        if(!banco.Insert_Endereco(cep, tipodelogradouro, numero, complemento, logradouro, bairro, cidade, estado)){
            JOptionPane.showMessageDialog(null, "Endereço não cadastrado com sucesso! Entre em contato com o suporte!");
            return false;
        }
        return true;
    }
    public boolean Cadastro_Funcionario(Pessoa_Generica pessoa){
        return banco.Insert_Funcionario(pessoa);
    }
    public int Retorna_IdEndereco(String cep){
        return banco.IdEndereco(cep);
    }
}
