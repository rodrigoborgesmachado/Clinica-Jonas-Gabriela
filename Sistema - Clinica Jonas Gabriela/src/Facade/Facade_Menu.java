/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;
import Controler.Tela_Agendamentos_Control;
import Controler.Tela_Agendar_Consulta_Control;
import Controler.Tela_Cadastro_Funcionarios_Control;
import Controler.Tela_Consultar_Atendimento_Control;
import Controler.Tela_Fazer_Atendimento_Control;
import Controler.Tela_Funcionarios_Cadastrados_Control;
import Controler.Tela_Funcionarios_Enderecos_Control;
import Controler.Tela_Pagar_Consulta_Control;
import Models.Tela_Agendamentos_Model;
import Models.Tela_Agendar_Consulta_Model;
import Models.Tela_Cadastro_Funcionarios_Model;
import Models.Tela_Consultar_Atendimento_Model;
import Models.Tela_Fazer_Atendimento_Model;
import Models.Tela_Funcionarios_Cadastrados_Model;
import Models.Tela_Funcionarios_Enderecos_Model;
import Models.Tela_Pagar_Consulta_Model;
import Models.Tela_Principal_Model;
import Pessoa.Pessoa_Generica;
import View.Tela_Agendamentos_View;
import View.Tela_Agendar_Consulta_View;
import View.Tela_Cadastro_Funcionarios_View;
import View.Tela_Consultar_Atendimento_View;
import View.Tela_Fazer_Atendimento_View;
import View.Tela_Funcionarios_Cadastrados_View;
import View.Tela_Funcionarios_Enderecos_View;
import View.Tela_Pagar_Consulta_View;
import View.Tela_Principal_View;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author Rodrigo
 */
public class Facade_Menu {
    private Tela_Principal_View theView;
    private Tela_Principal_Model theModel;
    public Facade_Menu(String s, Tela_Principal_View theView, Tela_Principal_Model theModel){
        this.theView=theView;
        this.theModel=theModel;
        if(s.equals("consulta"))this.Consulta();
        if(s.equals("cadastrofun"))this.Cadastro();
        if(s.equals("funcionarios"))this.Funcionarios();
        if(s.equals("consultasconsultar"))this.ConsultarConsulta();
        if(s.equals("realizarconsulta"))this.RealizarConsulta();
        if(s.equals("enderecos"))this.Enderecos();
        if(s.equals("consultasmarcadas"))this.ConsultasMarcadas();
        if(s.equals("pagarconsulta"))this.PagarConsulta();
    }
    
    public void ConsultarConsulta(){
        try {
            //login= theView.getLogin();
            Tela_Consultar_Atendimento_View cadastro_view= new Tela_Consultar_Atendimento_View();
            Tela_Consultar_Atendimento_Model cadastro_model = new Tela_Consultar_Atendimento_Model();
            Tela_Consultar_Atendimento_Control cadastro_control = new Tela_Consultar_Atendimento_Control(cadastro_view, cadastro_model);
            theView.Adicione_Telas(cadastro_view);
        }
        catch(NumberFormatException ex){		
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void RealizarConsulta(){
        try {
            //login= theView.getLogin();
            Tela_Fazer_Atendimento_View cadastro_view= new Tela_Fazer_Atendimento_View();
            Tela_Fazer_Atendimento_Model cadastro_model = new Tela_Fazer_Atendimento_Model();
            Tela_Fazer_Atendimento_Control cadastro_control = new Tela_Fazer_Atendimento_Control(cadastro_view, cadastro_model);
            theView.Adicione_Telas(cadastro_view);
        }
        catch(NumberFormatException ex){		
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void Cadastro(){
        try {
            //login= theView.getLogin();
            Tela_Cadastro_Funcionarios_View cadastro_view= new Tela_Cadastro_Funcionarios_View();
            Tela_Cadastro_Funcionarios_Model cadastro_model = new Tela_Cadastro_Funcionarios_Model();
            Tela_Cadastro_Funcionarios_Control cadastro_control = new Tela_Cadastro_Funcionarios_Control(cadastro_view, cadastro_model);
            theView.Adicione_Telas(cadastro_view);
        }
        catch(NumberFormatException ex){		
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void Funcionarios(){
        try {
            //login= theView.getLogin();
            Tela_Funcionarios_Cadastrados_View funcionario_view= new Tela_Funcionarios_Cadastrados_View();
            Tela_Funcionarios_Cadastrados_Model funcionario_model = new Tela_Funcionarios_Cadastrados_Model();
            Tela_Funcionarios_Cadastrados_Control funcionario_control = new Tela_Funcionarios_Cadastrados_Control(funcionario_view, funcionario_model);
            theView.Adicione_Telas(funcionario_view);
        }
        catch(NumberFormatException ex){		
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void Enderecos(){
        try {
            //login= theView.getLogin();
            Tela_Funcionarios_Enderecos_View funcionario_view= new Tela_Funcionarios_Enderecos_View();
            Tela_Funcionarios_Enderecos_Model funcionario_model = new Tela_Funcionarios_Enderecos_Model();
            Tela_Funcionarios_Enderecos_Control funcionario_control= new Tela_Funcionarios_Enderecos_Control(funcionario_view, funcionario_model);
            theView.Adicione_Telas(funcionario_view);
        }
        catch(NumberFormatException ex){		
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void Consulta(){
        try {
            //login= theView.getLogin();
            Tela_Agendar_Consulta_View funcionario_view= new Tela_Agendar_Consulta_View();
            Tela_Agendar_Consulta_Model funcionario_model = new Tela_Agendar_Consulta_Model();
            Tela_Agendar_Consulta_Control funcionario_control= new Tela_Agendar_Consulta_Control(funcionario_view, funcionario_model, theView.getControl());
            theView.Adicione_Telas(funcionario_view);
        }
        catch(NumberFormatException ex){		
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public void ConsultasMarcadas(){
        try {
            //login= theView.getLogin();
            Tela_Agendamentos_View funcionario_view= new Tela_Agendamentos_View();
            Tela_Agendamentos_Model funcionario_model = new Tela_Agendamentos_Model();
            Tela_Agendamentos_Control funcionario_control= new Tela_Agendamentos_Control(funcionario_view, funcionario_model);
            theView.Adicione_Telas(funcionario_view);
        }
        catch(NumberFormatException ex){		
            JOptionPane.showMessageDialog(null,ex);
        }
        
    }
    public void PagarConsulta(){
        try {
            //login= theView.getLogin();
            Tela_Pagar_Consulta_View cadastro_view= new Tela_Pagar_Consulta_View();
            Tela_Pagar_Consulta_Model cadastro_model = new Tela_Pagar_Consulta_Model();
            Tela_Pagar_Consulta_Control cadastro_control = new Tela_Pagar_Consulta_Control(cadastro_view, cadastro_model);
            theView.Adicione_Telas(cadastro_view);
        }
        catch(NumberFormatException ex){		
            JOptionPane.showMessageDialog(null,ex);
        }
    }
}
