/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Models.Tela_Informacoes_Model;
import Observer.Home_Broker_Observer;
import View.Tela_Informacoes_View;



/**
 *
 * @author Rodrigo
 */
public class Tela_Informacoes_Control extends Home_Broker_Observer {
    private Tela_Informacoes_View theView;
    private Tela_Informacoes_Model theModel;
    public Tela_Informacoes_Control(Tela_Informacoes_View theView, Tela_Informacoes_Model theModel){
        this.theModel=theModel;
        this.theView=theView;
        this.theView.setNoticias(theModel.getInformacoes());
        this.theView.setVisible(true);
    }
    public void atualizar() {
        this.theView.setNoticias(theModel.getInformacoes());
    }
}
