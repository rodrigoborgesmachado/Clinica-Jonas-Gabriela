/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;


import Models.Tela_Agendar_Consulta_Model;
import Models.Tela_Cadastro_Funcionarios_Model;
import Models.Tela_Funcionarios_Enderecos_Model;
import Models.Tela_Principal_Model;
import Observer.Home_Broker_Observer;
import Observer.Server_Subject;
import Pessoa.Pessoa_Generica;
import View.Tela_Agendar_Consulta_View;
import View.Tela_Cadastro_Funcionarios_View;
import View.Tela_Funcionarios_Enderecos_View;
import View.Tela_Informacoes_View;
import View.Tela_Principal_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Agendar_Consulta_Control extends Server_Subject{
    private Tela_Agendar_Consulta_View theView;
    private Tela_Agendar_Consulta_Model theModel;
    private Home_Broker_Observer theObserver;
    public Tela_Agendar_Consulta_Control(Tela_Agendar_Consulta_View theView, Tela_Agendar_Consulta_Model theModel, Home_Broker_Observer o){
        this.theView=theView;
        this.theModel=theModel;
        theView.setEspecialidade(theModel.getEspecialidade());
        this.theView.Button_ConfirmarActionListener(new AddFun());
	this.theView.Button_SairActionListener(new Out());
        this.theView.Combo_Box_EspecialidadeActionPerformed(new PreFun());
        this.theView.Text_DataActionPerformed(new PreHora());
        this.theObserver = o;
    }

    
    public void registrar_Observador(Home_Broker_Observer o) {
        this.theObserver = o;
    }

    public void Notifica_Observador() {
        this.theObserver.atualizar();
    }
    class PreFun implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theView.setVisibleBoxMedico(true);
            try {
                theView.setMedico(theModel.getMedico(theView.getEspecialidade()));
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class PreHora implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theView.setVisibleHora(true);
            try {
                theView.setHora(theModel.getHora(theView.getEspecialidade(), theView.getData()));
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class AddFun implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                if(theView.verifica()){
                    if(theModel.Agendar(theView.getNome(), theView.getEmail(), theView.getData(), theView.getHora(), theView.getEspecialidade(), theView.getMedico())){
                        JOptionPane.showMessageDialog(null, "Horário agendado com sucesso!");
                        theView.LimpaCadastros();
                        theObserver.atualizar();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Horário não agendado com sucesso! Algum dado está incorreto, entre em contato com o suporte ou tente novamente!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Preencher todos os campos");
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
 
