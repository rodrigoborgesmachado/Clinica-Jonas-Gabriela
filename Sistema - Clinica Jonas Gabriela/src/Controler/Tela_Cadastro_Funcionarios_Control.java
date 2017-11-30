/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;


import Models.Tela_Cadastro_Funcionarios_Model;
import Models.Tela_Funcionarios_Enderecos_Model;
import Models.Tela_Principal_Model;
import Pessoa.Pessoa_Generica;
import View.Tela_Cadastro_Funcionarios_View;
import View.Tela_Funcionarios_Enderecos_View;
import View.Tela_Principal_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Cadastro_Funcionarios_Control {
    private Tela_Cadastro_Funcionarios_View theView;
    private Tela_Cadastro_Funcionarios_Model theModel;
    public Tela_Cadastro_Funcionarios_Control(Tela_Cadastro_Funcionarios_View theView, Tela_Cadastro_Funcionarios_Model theModel){
        this.theView=theView;
        this.theModel=theModel;
        this.theView.Button_ConfirmarActionListener(new AddFun());
	this.theView.Button_SairActionListener(new Out());
    }
    class AddFun implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                theModel.Cadastro_Endereco(theView.getCEP(), theView.getLogradouro(), theView.getNumero(), theView.getComplemento(), theView.getTipoLogradouro(), theView.getBairro(), theView.getCidade(), theView.getEstado());
                Pessoa_Generica pessoa= new Pessoa_Generica(0, theView.getData(), theView.getNome(), theView.getSexo(), theView.getEstadoCivil(), theView.getCargo(), theView.getEspecialidade(), theView.getEmail(), theView.getCPF(), theView.getRG(), theView.getOutro(), theModel.Retorna_IdEndereco(theView.getCEP()));
                if(theModel.Cadastro_Funcionario(pessoa)){
                    JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
                    theView.LimpaCadastros();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Funcionário não cadastrado com sucesso! Algum dado está incorreto, entre em contato com o suporte ou tente novamente!");
                }
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class Out implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theView.dispose();
        }
    }
}
 
