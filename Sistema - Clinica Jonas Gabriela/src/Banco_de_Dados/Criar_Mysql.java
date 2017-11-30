/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco_de_Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rodrigo
 */
public class Criar_Mysql implements Strategy{

    Criar_Mysql() throws SQLException{
        this.Criar_Banco_Dados();
    }
    public void Criar_Banco_Dados() throws SQLException {
        String SQL1="CREATE TABLE paciente(" +
                "	CODPACIENTE integer AUTO_INCREMENT," +
                "  NOME varchar(60)," +
                "  EMAIL varchar(60)," +
                "	PRIMARY KEY(CODPACIENTE)" +
                ");";
        String SQL2="CREATE TABLE enderecofun(" +
                "  IDENDERECO INTEGER AUTO_INCREMENT," +
                "  CEP VARCHAR(20)," +
                "  TIPO_DE_LOGRADOURO VARCHAR(50)," +
                "  LOGRADOURO VARCHAR(50)," +
                "  NUMERO VARCHAR(11)," +
                "  COMPLEMENTO VARCHAR(50)," +
                "  BAIRRO VARCHAR(50)," +
                "  CIDADE VARCHAR(50)," +
                "  ESTADO VARCHAR (50)," +
                "  PRIMARY KEY (IDENDERECO)" +
                ");";
        String SQL3="CREATE TABLE contato(" +
                "  idcontato integer AUTO_INCREMENT," +
                "  NAME VARCHAR(50)," +
                "  EMAIL VARCHAR(50)," +
                "  COMENTARIO VARCHAR(500)," +
                "  PRIMARY KEY (idcontato)" +
                ");";
        String SQL4="CREATE TABLE funcionario(" +
                "  CODFUN integer AUTO_INCREMENT," +
                "  NOME varchar(100)," +
                "  DATA_NASCIMENTO date," +
                "  SEXO varchar(10)," +
                "  ESTADO_CIVIL varchar(20)," +
                "  CARGO varchar(50)," +
                "  ESPECIALIDADE varchar(50)," +
                "  EMAIL VARCHAR(50)," +
                "  CPF VARCHAR(20)," +
                "  RG VARCHAR(20)," +
                "  OUTRO VARCHAR(50)," +
                "  IDENDERECO integer(11)," +
                "  PRIMARY KEY(CODFUN)," +
                "  FOREIGN KEY(IDENDERECO) REFERENCES enderecofun(IDENDERECO)" +
                ");";
        String SQL5="CREATE TABLE agenda(" +
                "  CODAGENDAMENTO integer AUTO_INCREMENT," +
                "  DAT date," +
                "  HORA intEGER(11)," +
                "  CODFUNCIONARIO INTEGER(11)," +
                "  CODPACIENTE INTEGER(11)," +
                "  PAGO intEGER(2)," +
                "  PRIMARY KEY(CODAGENDAMENTO)," +
                "  FOREIGN KEY(CODFUNCIONARIO) REFERENCES funcionario(CODFUN)," +
                "  FOREIGN KEY(CODPACIENTE) REFERENCES paciente(CODPACIENTE)" +
                ");";
        String SQL6="CREATE TABLE usuario(" +
                "  Login varchar(50)," +
                "  Senha varchar(50)," +
                "  CODFUN INTEGER(11)," +
                "  PRIMARY KEY(Login)," +
                "  FOREIGN KEY(CODFUN) REFERENCES funcionario(CODFUN)" +
                ");";
        String SQL7="CREATE TABLE receitas(" +
                "  IDRECEITA INTEGER AUTO_INCREMENT," +
                "  IDCONSULTA INTEGER(11)," +
                "  IDPACIENTE INTEGER(11)," +
                "  IDMEDICO INTEGER(11)," +
                "  RECEITA text," +
                "  PRIMARY KEY(IDRECEITA)," +
                "  FOREIGN KEY(IDCONSULTA) references agenda(CODAGENDAMENTO)," +
                "  FOREIGN KEY(IDPACIENTE) REFERENCES paciente(CODPACIENTE)," +
                "  FOREIGN KEY(IDMEDICO) references funcionario(CODFUN)" +
                "  );";
        String SQL8= "insert into enderecofun( CEP, TIPO_DE_LOGRADOURO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO) values ('---', '', '', 0, '', '', '', '');";
        String SQL9= "insert into funcionario( NOME, DATA_NASCIMENTO, SEXO, ESTADO_CIVIL, CARGO, ESPECIALIDADE, EMAIL, CPF, RG, OUTRO, IDENDERECO) values ('admin', '2017-07-08', '', '', '', '', '', '', '', '', 1);";
        String SQL10= "insert into usuario (Login, Senha, CODFUN) values('admin', '12345', 1);";
        Connection instancia;
        instancia = Singleton_Connection_Banco_Mysql.GetInstance();
        PreparedStatement stm= instancia.prepareStatement(SQL1);
        instancia.setAutoCommit(true);
        stm.execute();
        stm= instancia.prepareStatement(SQL2);
        stm.execute();
        stm= instancia.prepareStatement(SQL3);
        stm.execute();
        stm= instancia.prepareStatement(SQL4);
        stm.execute();
        stm= instancia.prepareStatement(SQL5);
        stm.execute();
        stm= instancia.prepareStatement(SQL6);
        stm.execute();
        stm= instancia.prepareStatement(SQL7);
        stm.execute();
        stm= instancia.prepareStatement(SQL8);
        stm.execute();
        stm= instancia.prepareStatement(SQL9);
        stm.execute();
        stm= instancia.prepareStatement(SQL10);
        stm.execute();
    }
    
}
