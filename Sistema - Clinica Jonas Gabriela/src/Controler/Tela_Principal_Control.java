/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Facade.Facade_Menu;
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
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Tela_Principal_Control {
    private Tela_Principal_View theView;
    private Tela_Principal_Model theModel;
    private Pessoa_Generica logado;
    private Facade_Menu fachada;
    public Tela_Principal_Control(Tela_Principal_View theView, Tela_Principal_Model theModel, Pessoa_Generica logado){
        this.theModel=theModel;
        this.theView=theView;
        this.logado=logado;
        this.theView.getView().setEntrada("Bem Vindo "+this.logado.getNome());
        this.theView.setVisible(true);
        this.theView.Opcao_Cadastrar_FuncionarioActionListener(new Cadastro());
        this.theView.Opcao_Funcionarios_CadastradosActionListener(new Funcionarios());
        this.theView.Opcao_Funcionarios_EnderecosActionListener(new Enderecos());
        this.theView.Opcao_Agendar_ConsultaActionPerformed(new Consulta());
        this.theView.Opcao_Consultas_AgendadasActionPerformed(new ConsultasMarcadas());
        this.theView.Opcao_Pagar_ConsultaActionPerformed(new PagarConsulta());
        this.theView.Opcao_Realizar_ConsultaActionPerformed(new RealizarConsulta());
        this.theView.Opcao_Verificar_ConsultasActionPerformed(new ConsultarConsulta());
    }
    class ConsultarConsulta implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                //login= theView.getLogin();
                //Tela_Consultar_Atendimento_View cadastro_view= new Tela_Consultar_Atendimento_View();
                //Tela_Consultar_Atendimento_Model cadastro_model = new Tela_Consultar_Atendimento_Model();
                //Tela_Consultar_Atendimento_Control cadastro_control = new Tela_Consultar_Atendimento_Control(cadastro_view, cadastro_model);
                //theView.Adicione_Telas(cadastro_view);
                fachada = new Facade_Menu("consultasconsultar", theView, theModel);
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class RealizarConsulta implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                //login= theView.getLogin();
                //Tela_Fazer_Atendimento_View cadastro_view= new Tela_Fazer_Atendimento_View();
                //Tela_Fazer_Atendimento_Model cadastro_model = new Tela_Fazer_Atendimento_Model();
                //Tela_Fazer_Atendimento_Control cadastro_control = new Tela_Fazer_Atendimento_Control(cadastro_view, cadastro_model);
                //theView.Adicione_Telas(cadastro_view);
                fachada = new Facade_Menu("realizarconsulta", theView, theModel);
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class PagarConsulta implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                //login= theView.getLogin();
                //Tela_Pagar_Consulta_View cadastro_view= new Tela_Pagar_Consulta_View();
                //Tela_Pagar_Consulta_Model cadastro_model = new Tela_Pagar_Consulta_Model();
                //Tela_Pagar_Consulta_Control cadastro_control = new Tela_Pagar_Consulta_Control(cadastro_view, cadastro_model);
                //theView.Adicione_Telas(cadastro_view);
                fachada = new Facade_Menu("pagarconsulta", theView, theModel);
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class Cadastro implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                //login= theView.getLogin();
                //Tela_Cadastro_Funcionarios_View cadastro_view= new Tela_Cadastro_Funcionarios_View();
                //Tela_Cadastro_Funcionarios_Model cadastro_model = new Tela_Cadastro_Funcionarios_Model();
                //Tela_Cadastro_Funcionarios_Control cadastro_control = new Tela_Cadastro_Funcionarios_Control(cadastro_view, cadastro_model);
                //theView.Adicione_Telas(cadastro_view);
                fachada = new Facade_Menu("cadastrofun", theView, theModel);
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class Funcionarios implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                //login= theView.getLogin();
                //Tela_Funcionarios_Cadastrados_View funcionario_view= new Tela_Funcionarios_Cadastrados_View();
                //Tela_Funcionarios_Cadastrados_Model funcionario_model = new Tela_Funcionarios_Cadastrados_Model();
                //Tela_Funcionarios_Cadastrados_Control funcionario_control = new Tela_Funcionarios_Cadastrados_Control(funcionario_view, funcionario_model);
                //theView.Adicione_Telas(funcionario_view);
                fachada = new Facade_Menu("funcionarios", theView, theModel);
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class Enderecos implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                //login= theView.getLogin();
                //Tela_Funcionarios_Enderecos_View funcionario_view= new Tela_Funcionarios_Enderecos_View();
                //Tela_Funcionarios_Enderecos_Model funcionario_model = new Tela_Funcionarios_Enderecos_Model();
                //Tela_Funcionarios_Enderecos_Control funcionario_control= new Tela_Funcionarios_Enderecos_Control(funcionario_view, funcionario_model);
                //theView.Adicione_Telas(funcionario_view);
                fachada = new Facade_Menu("enderecos", theView, theModel);
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class Consulta implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                //login= theView.getLogin();
                //Tela_Agendar_Consulta_View funcionario_view= new Tela_Agendar_Consulta_View();
                //Tela_Agendar_Consulta_Model funcionario_model = new Tela_Agendar_Consulta_Model();
                //Tela_Agendar_Consulta_Control funcionario_control= new Tela_Agendar_Consulta_Control(funcionario_view, funcionario_model, theView.getControl());
                //theView.Adicione_Telas(funcionario_view);
                fachada = new Facade_Menu("consulta", theView, theModel);
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    class ConsultasMarcadas implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                //login= theView.getLogin();
                //Tela_Agendamentos_View funcionario_view= new Tela_Agendamentos_View();
                //Tela_Agendamentos_Model funcionario_model = new Tela_Agendamentos_Model();
                //Tela_Agendamentos_Control funcionario_control= new Tela_Agendamentos_Control(funcionario_view, funcionario_model);
                //theView.Adicione_Telas(funcionario_view);
                fachada = new Facade_Menu("consultasmarcadas", theView, theModel);
            }
            catch(NumberFormatException ex){		
                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
}
