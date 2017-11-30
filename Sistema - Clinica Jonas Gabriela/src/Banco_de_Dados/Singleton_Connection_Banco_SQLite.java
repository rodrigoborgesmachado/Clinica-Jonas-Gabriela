/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco_de_Dados;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Singleton_Connection_Banco_SQLite extends Template{
    public static String caminho;
    private Singleton_Connection_Banco_SQLite(){}
    
    public static Connection GetInstance(){
        //Singleton_Connection_Banco_SQLite.GetInformation();
        if(Singleton_Connection_Banco_SQLite.getInstancia()==null){
            synchronized (Singleton_Connection_Banco_SQLite.class){
                if(Singleton_Connection_Banco_SQLite.getInstancia() == null){
                    try {
                        
                        System.out.println(Singleton_Connection_Banco_SQLite.getIp().trim());
                        Singleton_Connection_Banco_SQLite.setInstancia(DriverManager.getConnection("jdbc:sqlite:"+Singleton_Connection_Banco_SQLite.getIp().trim()));
                        //JOptionPane.showMessageDialog(null, "Conectado com o banco de dados!");
                    }
                    
                    catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Sem conexão com o banco de dados! Erro SQL");
                        System.out.println(e);
                        System.exit(-1);
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Sem conexão com o banco de dados! Erro");
                        System.exit(-1);
                    }
                }
            }
        }
        return Singleton_Connection_Banco_SQLite.getInstancia();
    }
    
}
