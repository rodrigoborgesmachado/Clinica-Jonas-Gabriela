/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

import java.sql.Date;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

/**
 *
 * @author Rodrigo
 */
public class Pessoa_Generica {
    private int codfun, idendereco;
    private String nome, sexo, estado_civil, cargo, especialidade, email, cpf, rg, outro;
    private Date data_nascimento;
    public static Date transformaData(String dat){
        String temp=dat;
        if(dat.charAt(2) == '/'){
            temp="";
            temp+= dat.charAt(6);
            temp+= dat.charAt(7);
            temp+= dat.charAt(8);
            temp+= dat.charAt(9);
            temp+='-';
            temp+= dat.charAt(3);
            temp+= dat.charAt(4);
            temp+='-';
            temp+= dat.charAt(0);
            temp+= dat.charAt(1);
        }
        return Date.valueOf(temp);
    }
    public Pessoa_Generica(int codfun, Date data_nascimento, String nome, String sexo, String estado_civil, String cargo, String especialidade, String email, String cpf, String rg, String outro, int idendereco){
        this.cargo=cargo;
        this.codfun=codfun;
        this.cpf=cpf;
        this.data_nascimento=data_nascimento;
        this.email=email;
        this.especialidade=especialidade;
        this.estado_civil=estado_civil;
        this.idendereco=idendereco;
        this.nome=nome;
        this.rg=rg;
        this.outro=outro;
        this.sexo=sexo;
    }
    /**
     * @return the codfun
     */
    public int getCodfun() {
        return codfun;
    }

    /**
     * @param codfun the codfun to set
     */
    public void setCodfun(int codfun) {
        this.codfun = codfun;
    }

    /**
     * @return the idendereco
     */
    public int getIdendereco() {
        return idendereco;
    }

    /**
     * @param idendereco the idendereco to set
     */
    public void setIdendereco(int idendereco) {
        this.idendereco = idendereco;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the estado_civil
     */
    public String getEstado_civil() {
        return estado_civil;
    }

    /**
     * @param estado_civil the estado_civil to set
     */
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the data_nascimento
     */
    public Date getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return the outro
     */
    public String getOutro() {
        return outro;
    }

    /**
     * @param outro the outro to set
     */
    public void setOutro(String outro) {
        this.outro = outro;
    }
    
}
