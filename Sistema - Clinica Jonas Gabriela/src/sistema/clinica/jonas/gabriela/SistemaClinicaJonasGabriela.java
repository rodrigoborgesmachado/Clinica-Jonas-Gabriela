/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.clinica.jonas.gabriela;

import Banco_de_Dados.Singleton_Connection_Banco_Mysql;
import Banco_de_Dados.Singleton_Connection_Banco_SQLite;
import Banco_de_Dados.Template;
import Controler.Tela_Login_Control;
import Models.Tela_Login_Model;
import View.Tela_Login_View;
import View.Tela_Principal_View;
import java.sql.Connection;

/**
 *
 * @author Rodrigo
 */
public class SistemaClinicaJonasGabriela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conexao = Template.GetInstance();
        Tela_Login_View v = new Tela_Login_View();
        Tela_Principal_View v1 = new Tela_Principal_View();
        Tela_Login_Model t1= new Tela_Login_Model();
        Tela_Login_Control t = new Tela_Login_Control(v, t1);
        v.setVisible(true);
    }
    
}
