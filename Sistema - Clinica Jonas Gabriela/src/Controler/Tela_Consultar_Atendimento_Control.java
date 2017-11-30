/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Models.Tela_Agendamentos_Model;
import Models.Tela_Consultar_Atendimento_Model;
import Models.Tela_Fazer_Atendimento_Model;
import Models.Tela_Informacoes_Model;
import Models.Tela_Pagar_Consulta_Model;
import View.Tela_Agendamentos_View;
import View.Tela_Consultar_Atendimento_View;
import View.Tela_Fazer_Atendimento_View;
import View.Tela_Informacoes_View;
import View.Tela_Pagar_Consulta_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



/**
 *
 * @author Rodrigo
 */
public class Tela_Consultar_Atendimento_Control {
    private Tela_Consultar_Atendimento_View theView;
    private Tela_Consultar_Atendimento_Model theModel;
    public Tela_Consultar_Atendimento_Control(Tela_Consultar_Atendimento_View theView, Tela_Consultar_Atendimento_Model theModel){
        this.theModel=theModel;
        this.theView=theView;
        String[] temp= new String[1000];
        temp=theModel.getInformacoes();
        for(int i=0;i<temp.length;i++)
            this.theView.setNoticias(temp[i]);
        this.theView.setVisible(true);
        theView.setPaciente(theModel.getPaciente());
        theView.Button_SairActionListener(new Out());
        theView.Combo_Box_PacienteActionPerformed(new Med());
        this.theView.Combo_Box_MedicaActionPerformed(new Pac());
        this.theView.Combo_Box_ConsultaActionPerformed(new Cons());
    }
    class Out implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theView.dispose();
        }
    }
    class Cons implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                theView.setText(theModel.getText(theView.getPaciente(), theView.getMedico(), theView.getConsulta()));
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class Med implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                theView.habilitaMedico(true);
                String[] temp= new String[1000];
                theView.setMedico(theModel.Medicos());
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class Pac implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                theView.ZeraNoticias();
                String[] temp= new String[1000];
                temp=theModel.getInformacoes(theView.getPaciente(), theView.getMedico());
                for(int i=0;i<temp.length;i++)
                    theView.setNoticias(temp[i]);
                theView.habilitaConsulta(true);
                theView.setConsulta(theModel.getAgenda(theView.getPaciente(), theView.getMedico()));
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
}
