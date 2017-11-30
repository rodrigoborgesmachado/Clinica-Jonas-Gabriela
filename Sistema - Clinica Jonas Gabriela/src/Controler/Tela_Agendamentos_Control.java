/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Models.Tela_Agendamentos_Model;
import Models.Tela_Informacoes_Model;
import View.Tela_Agendamentos_View;
import View.Tela_Informacoes_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



/**
 *
 * @author Rodrigo
 */
public class Tela_Agendamentos_Control {
    private Tela_Agendamentos_View theView;
    private Tela_Agendamentos_Model theModel;
    public Tela_Agendamentos_Control(Tela_Agendamentos_View theView, Tela_Agendamentos_Model theModel){
        this.theModel=theModel;
        this.theView=theView;
        String[] temp= new String[1000];
        temp=theModel.getInformacoes();
        for(int i=0;i<temp.length;i++)
            this.theView.setNoticias(temp[i]);
        this.theView.setVisible(true);
        theView.setMedico(theModel.getMedico());
        theView.Button_SairActionListener(new Out());
        this.theView.Combo_Box_MedicaActionPerformed(new Medic());
    }
    class Out implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theView.dispose();
        }
    }
    class Medic implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                theView.ZeraNoticias();
                String[] temp= new String[1000];
                temp=theModel.getInformacoes(theView.getMedico());
                for(int i=0;i<temp.length;i++)
                    theView.setNoticias(temp[i]);
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
}
