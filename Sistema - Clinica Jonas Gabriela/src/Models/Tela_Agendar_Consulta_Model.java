/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.Tela_Agendar_Consulta_DAO;
import DAO.Tela_Cadastro_Funcionarios_DAO;
import Pessoa.Pessoa_Generica;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Rodrigo
 */
public class Tela_Agendar_Consulta_Model {    
    private final Tela_Agendar_Consulta_DAO banco= new Tela_Agendar_Consulta_DAO();
    public boolean Agendar(String nome, String email, String data, int hora, String especialidade, String medico){
        if(banco.Insert_Paciente(nome, email)) 
            if(banco.Insert_Agenda(data, hora, banco.IdFuncionario(medico, especialidade), banco.IdPaciente(email))){
                return true;
            }
            else{
                return false;
            }
        else 
            return false;
    }
    public ArrayList getEspecialidade(){
        return this.banco.Especialidade();
    }
    public ArrayList getMedico(String especialidade){
        return this.banco.Medicos(especialidade);
    }
    public ArrayList getHora(String especialidade, String date){
        return this.banco.hora(especialidade, date);
    }
}
