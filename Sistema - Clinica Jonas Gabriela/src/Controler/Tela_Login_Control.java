/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Banco_de_Dados.Singleton_Connection_Banco_Mysql;
import Models.Tela_Login_Model;
import Models.Tela_Principal_Model;
import Pessoa.Pessoa_Generica;
import View.Tela_Login_View;
import View.Tela_Principal_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Login_Control {
    private Tela_Login_View theView;
    private Tela_Login_Model theModel;
    public Tela_Login_Control(Tela_Login_View theView, Tela_Login_Model theModel){
        this.theView=theView;
        this.theModel=theModel;
        this.theView.Button_LoginActionListener(new Login());
	this.theView.Button_outActionListener(new Out());
        this.theView.Text_SenhaActionPerformed(new Login());
    }
    class Login implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                //login= theView.getLogin();
                int id = theModel.Verifica_Login(theView.GetLogin(), theView.GetSenha());
                if( id != 0){
                    theView.dispose();
                    Pessoa_Generica logado= new Pessoa_Generica(id, Pessoa_Generica.transformaData(theModel.retorna_data(id)), theModel.retorna_Nome(id), theModel.retorna_Sexo(id), theModel.retorna_Estado_Civil(id), theModel.retorna_Cargo(id), theModel.retorna_Especialidade(id), theModel.retorna_Email(id), theModel.retorna_CPF(id), theModel.retorna_RG(id), theModel.retorna_Outro(id), theModel.retorna_IDEndereco(id));
                    Tela_Principal_View principal =  new Tela_Principal_View();
                    Tela_Principal_Model model = new Tela_Principal_Model();
                    Tela_Principal_Control control = new Tela_Principal_Control(principal, model, logado);
                }
                else{
                    theView.SetVazio();
                    JOptionPane.showMessageDialog(null,"Login ou senha incorretos");
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
 
