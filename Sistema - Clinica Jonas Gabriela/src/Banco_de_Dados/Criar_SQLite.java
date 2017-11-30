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
public class Criar_SQLite  implements Strategy{

    Criar_SQLite() throws SQLException{
        this.Criar_Banco_Dados();
    }
    public void Criar_Banco_Dados() throws SQLException {
        String SQL="CREATE TABLE paciente(" +
                "	CODPACIENTE integer AUTO_INCREMENT," +
                "  NOME varchar(60)," +
                "  EMAIL varchar(60)," +
                "	PRIMARY KEY(CODPACIENTE)" +
                ");" +
                "" +
                "CREATE TABLE enderecofun(" +
                "  IDENDERECO INTEGER(11)," +
                "  CEP VARCHAR(20)," +
                "  TIPO_DE_LOGRADOURO VARCHAR(50)," +
                "  LOGRADOURO VARCHAR(50)," +
                "  NUMERO VARCHAR(11)," +
                "  COMPLEMENTO VARCHAR(50)," +
                "  BAIRRO VARCHAR(50)," +
                "  CIDADE VARCHAR(50)," +
                "  ESTADO VARCHAR (50)," +
                "  PRIMARY KEY (IDENDERECO)" +
                ");" +
                "" +
                "CREATE TABLE contato(" +
                "  idcontato integer AUTO_INCREMENT," +
                "  NAME VARCHAR(50)," +
                "  EMAIL VARCHAR(50)," +
                "  COMENTARIO VARCHAR(500)," +
                "  PRIMARY KEY (idcontato)" +
                ");" +
                "" +
                "CREATE TABLE funcionario(" +
                "	CODFUN integer AUTO_INCREMENT," +
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
                ");" +
                "" +
                "" +
                "CREATE TABLE agenda(" +
                "  CODAGENDAMENTO integer AUTO_INCREMENT," +
                "  'DATA' date," +
                "  HORA intEGER(11)," +
                "  CODFUNCIONARIO INTEGER(11)," +
                "  CODPACIENTE INTEGER(11)," +
                "  PAGO intEGER(2)," +
                "  PRIMARY KEY(CODAGENDAMENTO)," +
                "  FOREIGN KEY(CODFUNCIONARIO) REFERENCES funcionario(CODFUN)," +
                "  FOREIGN KEY(CODPACIENTE) REFERENCES paciente(CODPACIENTE)" +
                ");" +
                "" +
                "" +
                "CREATE TABLE usuario(" +
                "  Login varchar(50)," +
                "  Senha varchar(50)," +
                "  CODFUN INTERGER(11)," +
                "  PRIMARY KEY(Login)," +
                "  FOREIGN KEY(CODFUN) REFERENCES funcionario(CODFUN)" +
                ");" +
                "" +
                "CREATE TABLE receitas(" +
                "  IDRECEITA INTEGER AUTO_INCREMENT," +
                "  IDCONSULTA INTEGER(11)," +
                "  IDPACIENTE INTEGER(11)," +
                "  IDMEDICO INTEGER(11)," +
                "  RECEITA text," +
                "  PRIMARY KEY(IDRECEITA)," +
                "  FOREIGN KEY(IDCONSULTA) references agenda(CODAGENDAMENTO)," +
                "  FOREIGN KEY(IDPACIENTE) REFERENCES paciente(CODPACIENTE)," +
                "  FOREIGN KEY(IDMEDICO) references funcionario(CODFUN)" +
                "  );" +
                "" +
                "insert into enderecofun values (1,'---', '', '', 0, '', '', '', '');" +
                "insert into funcionario values (1, 'admin', 'admin', '', '', '', '', '', '', '', '', 1);" +
                "insert into usuario values('admin', '12345', 1);";
        Connection instancia;
        instancia = Singleton_Connection_Banco_SQLite.GetInstance();
        PreparedStatement stm= instancia.prepareStatement(SQL);
        stm.execute();
    }
    
}
