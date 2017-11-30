/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Models.Tela_Agendamentos_Model;
import Models.Tela_Informacoes_Model;
import Models.Tela_Pagar_Consulta_Model;
import View.Tela_Agendamentos_View;
import View.Tela_Informacoes_View;
import View.Tela_Pagar_Consulta_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



/**
 *
 * @author Rodrigo
 */
public class Tela_Pagar_Consulta_Control {
    private Tela_Pagar_Consulta_View theView;
    private Tela_Pagar_Consulta_Model theModel;
    public Tela_Pagar_Consulta_Control(Tela_Pagar_Consulta_View theView, Tela_Pagar_Consulta_Model theModel){
        this.theModel=theModel;
        this.theView=theView;
        String[] temp= new String[1000];
        temp=theModel.getInformacoes();
        for(int i=0;i<temp.length;i++)
            this.theView.setNoticias(temp[i]);
        this.theView.setVisible(true);
        theView.setPaciente(theModel.getPaciente());
        theView.Button_SairActionListener(new Out());
        theView.Button_PagamentoActionPerformed(new Pag());
        
        this.theView.Combo_Box_PacienteActionPerformed(new Pac());
    }
    class Out implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theView.dispose();
        }
    }
    class Pac implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                theView.ZeraNoticias();
                String[] temp= new String[1000];
                temp=theModel.getInformacoes(theView.getPaciente());
                for(int i=0;i<temp.length;i++)
                    theView.setNoticias(temp[i]);
                theView.habilitaConsulta(true);
                theView.setConsulta(theModel.getAgenda(null));
                theView.setConsulta(theModel.getAgenda(theView.getPaciente()));
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class Pag implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                if(theModel.realizarPagamento(theView.getConsulta())){
                    JOptionPane.showMessageDialog(null,"Pagamento efetuado com sucesso.");
                    String[] temp= new String[1000];
                    theView.ZeraNoticias();
                    theView.habilitaConsulta(false);
                    temp=theModel.getInformacoes(theView.getPaciente());
                    for(int i=0;i<temp.length;i++)
                        theView.setNoticias(temp[i]);
                }
                else
                    JOptionPane.showMessageDialog(null,"O pagamento não efetuado com sucesso.");
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
}
