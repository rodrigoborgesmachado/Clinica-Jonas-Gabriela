/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;


import Models.Tela_Cadastro_Funcionarios_Model;
import Models.Tela_Funcionarios_Cadastrados_Model;
import Models.Tela_Principal_Model;
import Pessoa.Pessoa_Generica;
import View.Tela_Cadastro_Funcionarios_View;
import View.Tela_Funcionarios_Cadastrados_View;
import View.Tela_Principal_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Funcionarios_Cadastrados_Control {
    private Tela_Funcionarios_Cadastrados_View theView;
    private Tela_Funcionarios_Cadastrados_Model theModel;
    public Tela_Funcionarios_Cadastrados_Control(Tela_Funcionarios_Cadastrados_View theView, Tela_Funcionarios_Cadastrados_Model theModel){
        this.theView=theView;
        this.theModel=theModel;
        this.setNoticias();
	this.theView.Button_SairActionListener(new Out());
    }
    public void setNoticias(){
        ArrayList texto;
        texto = this.theModel.Retorna_Noticias();
        for(int i=0;i<texto.size();i++){
            String temp=(String)texto.get(i);
            this.theView.setNoticias(temp);
        }
    }
    class Out implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theView.dispose();
        }
    }
}
 
